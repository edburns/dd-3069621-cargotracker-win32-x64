$ErrorActionPreference = 'Stop'
Set-StrictMode -Version Latest

$repo = 'edburns/dd-3069621-cargotracker-win32-x64'
$parentIssue = 1
$logDirectory = 'C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549'
$ledgerPath = Join-Path $logDirectory 'creation-ledger.json'
$resultPath = Join-Path $logDirectory 'stage-20-result.json'
$preCreationPath = Join-Path $logDirectory 'pre-creation-children.json'
$finalChildrenPath = Join-Path $logDirectory 'final-children.json'
$bodyVerifier = 'C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\verify-github-issue-body.ps1'
$childLinkVerifier = 'C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\verify-stage20-child-links.ps1'

$specifications = @(
    [pscustomobject]@{
        subsection = '4.1 — Issue 1: Add the application-layer deadline change operation'
        title = '4.1: Add the application-layer deadline change operation'
        bodyFile = 'issue-bodies/01-4.1-body.md'
    },
    [pscustomobject]@{
        subsection = '4.2 — Issue 2: Expose deadline changes through the booking facade'
        title = '4.2: Expose deadline changes through the booking facade'
        bodyFile = 'issue-bodies/02-4.2-body.md'
    },
    [pscustomobject]@{
        subsection = '4.3 — Issue 3: Implement the deadline editor backing model'
        title = '4.3: Implement the deadline editor backing model'
        bodyFile = 'issue-bodies/03-4.3-body.md'
    },
    [pscustomobject]@{
        subsection = '4.4 — Issue 4: Implement the PrimeFaces deadline dialog'
        title = '4.4: Implement the PrimeFaces deadline dialog'
        bodyFile = 'issue-bodies/04-4.4-body.md'
    },
    [pscustomobject]@{
        subsection = '4.5 — Issue 5: Integrate deadline editing into the Administration dashboard'
        title = '4.5: Integrate deadline editing into the Administration dashboard'
        bodyFile = 'issue-bodies/05-4.5-body.md'
    }
)

function Write-AtomicText {
    param(
        [Parameter(Mandatory)][string]$Path,
        [Parameter(Mandatory)][string]$Content
    )

    $temporaryPath = "$Path.tmp"
    [IO.File]::WriteAllText(
        $temporaryPath,
        $Content + [Environment]::NewLine,
        [Text.UTF8Encoding]::new($false)
    )
    Move-Item -Force -LiteralPath $temporaryPath -Destination $Path
}

function Read-CreationLedger {
    $parsed = [IO.File]::ReadAllText($ledgerPath) |
        ConvertFrom-Json -NoEnumerate
    if ($parsed -isnot [System.Array]) {
        throw 'Creation ledger JSON root must be an array.'
    }

    $ledger = [object[]]$parsed
    if (@($ledger | Where-Object { $_ -is [System.Array] }).Count -ne 0) {
        throw 'Creation ledger must not contain nested array entries.'
    }
    return $ledger
}

function Write-CreationLedger {
    param([Parameter(Mandatory)][AllowEmptyCollection()][object[]]$Ledger)

    $json = ConvertTo-Json -InputObject ([object[]]$Ledger) -Depth 10
    Write-AtomicText -Path $ledgerPath -Content $json
}

function Update-LedgerFlag {
    param(
        [Parameter(Mandatory)][int]$Number,
        [Parameter(Mandatory)][ValidateSet('body_verified', 'linked')][string]$Field,
        [Parameter(Mandatory)][bool]$Value
    )

    $ledger = @(Read-CreationLedger)
    $entry = $ledger | Where-Object { $_.number -eq $Number }
    if (@($entry).Count -ne 1) {
        throw "Expected exactly one ledger entry for issue #$Number."
    }
    $entry.$Field = $Value
    Write-CreationLedger -Ledger $ledger
}

function Get-NormalizedChildren {
    $childrenOutput = & gh api "repos/$repo/issues/$parentIssue/sub_issues" --paginate --slurp 2>&1
    $childrenExitCode = $LASTEXITCODE
    if ($childrenExitCode -ne 0) {
        throw "Unable to query parent children: $($childrenOutput | Out-String)"
    }

    $normalizationOutput = ($childrenOutput | Out-String) |
        jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end'
    $normalizationExitCode = $LASTEXITCODE
    if ($normalizationExitCode -ne 0) {
        throw "Unable to normalize parent children: $($normalizationOutput | Out-String)"
    }

    $normalizedJson = ($normalizationOutput | Out-String).Trim()
    $parsed = $normalizedJson | ConvertFrom-Json -NoEnumerate
    if ($parsed -isnot [System.Array]) {
        throw 'Normalized parent-child response root must be an array.'
    }
    return [pscustomobject]@{
        json = $normalizedJson
        children = [object[]]$parsed
    }
}

function Write-StageResult {
    param(
        [Parameter(Mandatory)][ValidateSet('in_progress', 'complete', 'failed')][string]$Status,
        [AllowNull()][string]$OperationError
    )

    $result = [ordered]@{
        schemaVersion = 1
        status = $Status
        ledgerFile = 'creation-ledger.json'
        operationError = $OperationError
    }
    Write-AtomicText -Path $resultPath -Content (
        ConvertTo-Json -InputObject $result -Depth 5
    )
}

function Reconcile-Failure {
    param([Parameter(Mandatory)][string]$Failure)

    try {
        $server = Get-NormalizedChildren
        $serverIds = @($server.children | ForEach-Object { [long]$_.id })
        $ledger = @(Read-CreationLedger)
        foreach ($entry in $ledger) {
            $entry.linked = $serverIds -contains [long]$entry.id
        }
        Write-CreationLedger -Ledger $ledger
    }
    catch {
        $Failure = "$Failure Reconciliation error: $($_.Exception.Message)"
    }

    Write-StageResult -Status failed -OperationError $Failure
    Write-Output "STAGE20_FAILED: $Failure"
    $ledger = @(Read-CreationLedger)
    if ($ledger.Count -eq 0) {
        Write-Output 'No issues were created; no cleanup is required.'
        return
    }
    $ledger |
        Select-Object number, title, url, bodyFile, body_verified, linked |
        Format-Table -AutoSize |
        Out-String |
        Write-Output
    foreach ($entry in $ledger) {
        Write-Output "gh issue delete $($entry.number) --repo `"$repo`" --yes"
    }
    Write-Output 'The operation did not complete and no automatic rollback was performed. Delete every issue in the ledger before invoking this skill again.'
}

$initialLedger = @(Read-CreationLedger)
if ($initialLedger.Count -ne 0) {
    throw 'Creation ledger is not empty; refusing to rerun this one-shot operation.'
}

$failedOperation = $null
try {
    foreach ($specification in $specifications) {
        $absoluteBodyPath = Join-Path $logDirectory (
            $specification.bodyFile -replace '/', '\'
        )

        $createOutput = & gh api "repos/$repo/issues" `
            -X POST `
            -f "title=$($specification.title)" `
            -F "body=@$absoluteBodyPath" 2>&1
        $createExitCode = $LASTEXITCODE
        if ($createExitCode -ne 0) {
            throw "Create failed for $($specification.subsection): $($createOutput | Out-String)"
        }
        $createdIssue = ($createOutput | Out-String) | ConvertFrom-Json

        $ledger = @(Read-CreationLedger)
        $ledger += [pscustomobject][ordered]@{
            implementationSubsection = $specification.subsection
            bodyFile = $specification.bodyFile
            id = [long]$createdIssue.id
            number = [int]$createdIssue.number
            title = [string]$createdIssue.title
            url = [string]$createdIssue.html_url
            body_verified = $false
            linked = $false
        }
        Write-CreationLedger -Ledger $ledger

        try {
            $observedIssue = & $bodyVerifier `
                -Repository $repo `
                -IssueNumber ([int]$createdIssue.number) `
                -ExpectedBodyPath $absoluteBodyPath `
                -MaxAttempts 6 `
                -DelaySeconds 5 `
                -DiagnosticPath (
                    Join-Path $logDirectory (
                        "issue-$($createdIssue.number)-body-verification-failure.json"
                    )
                )
        }
        catch {
            throw "Issue body verification failed for issue #$($createdIssue.number): $($_.Exception.Message)"
        }
        Update-LedgerFlag -Number ([int]$createdIssue.number) -Field body_verified -Value $true

        $linked = $false
        $linkError = ''
        for ($attempt = 1; $attempt -le 3 -and -not $linked; $attempt++) {
            $payload = @{sub_issue_id = [long]$createdIssue.id} |
                ConvertTo-Json -Compress
            $linkOutput = $payload |
                & gh api "repos/$repo/issues/$parentIssue/sub_issues" -X POST --input - 2>&1
            $linkExitCode = $LASTEXITCODE
            if ($linkExitCode -eq 0) {
                $linked = $true
            }
            else {
                $linkError = ($linkOutput | Out-String).Trim()
                if ($attempt -lt 3) {
                    Start-Sleep -Seconds 2
                }
            }
        }
        if (-not $linked) {
            throw "Link failed for issue #$($createdIssue.number) after 3 attempts: $linkError"
        }
        Update-LedgerFlag -Number ([int]$createdIssue.number) -Field linked -Value $true
        Write-Output "CREATED_AND_LINKED #$($createdIssue.number) $($createdIssue.title)"
    }

    $final = Get-NormalizedChildren
    Write-AtomicText -Path $finalChildrenPath -Content $final.json

    try {
        & $childLinkVerifier `
            -PreCreationChildrenPath $preCreationPath `
            -FinalChildrenPath $finalChildrenPath `
            -CreationLedgerPath $ledgerPath
    }
    catch {
        throw "Child-link postcondition verification failed: $($_.Exception.Message)"
    }

    foreach ($entry in @(Read-CreationLedger)) {
        $absoluteBodyPath = Join-Path $logDirectory (
            $entry.bodyFile -replace '/', '\'
        )
        try {
            $observedIssue = & $bodyVerifier `
                -Repository $repo `
                -IssueNumber ([int]$entry.number) `
                -ExpectedBodyPath $absoluteBodyPath `
                -MaxAttempts 6 `
                -DelaySeconds 5 `
                -DiagnosticPath (
                    Join-Path $logDirectory (
                        "issue-$($entry.number)-final-body-verification-failure.json"
                    )
                )
        }
        catch {
            throw "Final body verification failed for issue #$($entry.number): $($_.Exception.Message)"
        }
        if ($observedIssue.state -ne 'open') {
            throw "Issue #$($entry.number) is not open."
        }
        if (@($observedIssue.assignees).Count -ne 0) {
            throw "Issue #$($entry.number) is assigned but must remain unassigned."
        }
    }

    Write-StageResult -Status complete -OperationError $null
    Write-Output 'STAGE20_COMPLETE'
    @(Read-CreationLedger) |
        Select-Object implementationSubsection, number, title, url |
        ConvertTo-Json -Depth 5
}
catch {
    $failedOperation = $_.Exception.Message
    Reconcile-Failure -Failure $failedOperation
    exit 1
}
