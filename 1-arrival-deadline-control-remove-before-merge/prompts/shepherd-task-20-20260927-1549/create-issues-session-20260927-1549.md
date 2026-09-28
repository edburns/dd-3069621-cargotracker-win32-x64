# Copilot CLI Session

> [!NOTE]
> - **Session ID:** `c840e67f-b772-47b8-972a-911954d8dc35`  
> - **Started:** 9/27/2026, 3:49:19 PM  
> - **Duration:** 2m 57s  
> - **Exported:** 9/27/2026, 3:52:17 PM  

---

<sub>6s</sub>

### User

Invoke skill `shepherd-task-20-create-issues-from-plan` with these inputs:

- CAMPAIGN_ID: ce692e79-febf-4b62-be97-8761f1b47240
- LESSON_PROPAGATION: off
- REPO: edburns/dd-3069621-cargotracker-win32-x64
- BASE_BRANCH: experiment/shepherd-control
- PARENT_ISSUE: 1
- PLAN_DIRECTORY: 1-arrival-deadline-control-remove-before-merge
- PLAN_FILE_NAME: add-change-arrival-deadline-feature-ignorance-reduction-plan.md
- QUESTIONS_SECTION: ## Phase 3 — Ignorance reduction: questions to answer before writing code
- IMPLEMENTATION_SECTION: ## Phase 4 — Implementation (five serial issues)
- EXPECTED_TASK_COUNT: 5
- BASE_REMOTE: origin
- LOG_DIRECTORY: C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549
- DRAFT_VALIDATOR: C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\validate-stage20-drafts.ps1
- ISSUE_BODY_VERIFIER: C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\verify-github-issue-body.ps1
- CHILD_LINK_VERIFIER: C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\verify-stage20-child-links.ps1

Fixture pagination response contract (mandatory):

- `gh api ... --paginate --slurp` returns a JSON array of page payloads, so a
  one-page response has the shape `[[{...}]]`, not `[{...}]`.
- Before indexing child issue fields such as `.id`, normalize the response to
  one flat issue array exactly once.
- In Bash, use:
  `jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end'`.
- In PowerShell, capture the `gh` output and `$LASTEXITCODE` first, then pass
  the complete JSON through the same `jq` normalization before
  `ConvertFrom-Json`.
- Use the normalized flat array for the pre-creation baseline, final child
  count/order checks, and failure reconciliation. Do not apply `add` a second
  time to an already-flat array.


---

<sub>11s</sub>

### `skill`

**shepherd-task-20-create-issues-from-plan**

<details>
<summary>Arguments</summary>

```json
{
  "skill": "shepherd-task-20-create-issues-from-plan"
}
```

</details>

```
Skill "shepherd-task-20-create-issues-from-plan" loaded successfully. Follow the instructions in the skill context.
```


---

<sub>15s</sub>

### Copilot

I’m validating the campaign inputs, base branch, parent issue, plan structure, and required tooling before any GitHub mutation.

---

<sub>27s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\01-1682-java-tool-ergonomics.md.**

C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\01-1682-java-tool-ergonomics.md

<details>
<summary>15 lines</summary>

```
# Example 01: 1682-java-tool-ergonomics-prompts-remove-before-merge

Read `copilot-sdk/1682-java-tool-ergonomics-prompts-remove-before-merge/dd-3018003-ignorance-reduction-for-implementation-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 3 — Ignorance reduction: questions to answer before writing code`.

In this session, we are creating issues of type **Task** as children of Epic https://github.com/github/copilot-sdk/issues/1682 . These issues correspond to the sub-sections in `## Phase 4 — Implementation (the build order)`.

I want you to use `gh` to create issues as sub-issues of 1682.

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Set the type to **Task**.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `upstream`: `edburns/1682-java-tool-ergonomics`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `1682-java-tool-ergonomics-prompts-remove-before-merge`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 4 — Implementation (the build order)` have essential details for each corresponding **Task**.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 4 — Implementation (the build order)` have essential details for each corresponding **Task**, I want you to carefully consider if there are additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>28s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\02-1810-java-tool-as-lambda.md.**

C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\02-1810-java-tool-as-lambda.md

<details>
<summary>12 lines</summary>

```
# Example 02: 1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge

Carefully read the plan `copilot-sdk/1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge/1810-ignorance-reduction-for-implementation-plan.md`.

We have completed Phases 1 - 3. We are now on Phase 4.

For each sub item in Phase 4, file a child issue of Feature #1810.

Use `gh` to look at Epic #1682 and its child issues for the standard of verbosity and concreteness for issue descriptions.

The issue should be assignable to a coding agent and there must be sufficient detail in the description for the agent to proceed to completion.

Pull out the specific relevant content from Phase 3 as it applies to this current issue in Phase 4.

Tell the agent to take `edburns/1810-java-tool-ergonomics-tool-as-lambda` as the base branch. When I assign the issue to the coding agent, I will set this as the base branch.

Tell the agent to read `1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge/1810-ignorance-reduction-for-implementation-plan.md`, which is present on the branch, for context.

Tell the agent which sub-item within Phase 4 they are solving.

Tell the agent that each issue will be assigned, resolved and merged to the base branch in the order in which they appear in the plan.

No work is to start until I assign each issue to the coding agent, in turn.
```

</details>


---

<sub>28s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\03-dd-3017826-java-real-estate-demo.md.**

C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\03-dd-3017826-java-real-estate-demo.md

<details>
<summary>14 lines</summary>

```
# Example 03: dd-3017826-java-real-estate-demo-remove-before-merge

Read `dd-3017826-java-real-estate-demo-remove-before-merge\dd-3017826-java-real-estate-demo-ignorance-reduction-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`.

In this session, we are creating sub-issues as children of https://github.com/edburns/Build26-BRK206-your-agent-anywhere-multiclient-multidevice-with-github-copilot-sdk/issues/2 . These issues correspond to the sub-sections in `## Phase 3 — Implementation (build order)`.

I want you to use `gh` to create issues as sub-issues of #2.

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `origin`: `edburns/2-build-out-demo`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `dd-3017826-java-real-estate-demo-remove-before-merge`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue, I want you to carefully consider if there are additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>26s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\04-28-python-agent-demo.md.**

C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\04-28-python-agent-demo.md

<details>
<summary>16 lines</summary>

```
# Example 04: 28-python-agent-demo-remove-before-merge

Read `28-python-agent-demo-remove-before-merge/28-python-agent-demo-ignorance-reduction-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`. These pertain to the implementation tasks in Phase 3. ✅✅✅ Include relevant spike findings as self-contained prose in the issue description; do not direct the agent to spike directories or source files.

In this session, we are creating sub-issues as children of https://github.com/edburns/Build26-BRK206-your-agent-anywhere-multiclient-multidevice-with-github-copilot-sdk/issues/28 . These issues correspond to the sub-sections in `## Phase 3 — Implementation (build order)`.

I want you to use `gh` to create issues as sub-issues of #28

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Again, ✅✅For each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`, include the relevant Resolution values in the issue description. These pertain to the implementation tasks in Phase 3. ✅✅✅ State relevant spike findings directly in the issue body with enough detail to implement them without reading spike code.

- For tasks dealing with the UI, make sure to refer to the relevant screengrabs, but only ones within `28-python-agent-demo-remove-before-merge/`.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `origin`: `edburns/28-python-agent-demo`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `28-python-agent-demo-remove-before-merge/`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue, I want you to carefully consider if there are additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>29s</sub>

### `powershell`

**Validate log directory and scripts**

<details>
<summary>Arguments</summary>

```json
{
  "command": "$ErrorActionPreference='Stop'; $paths=@('C:\\Users\\edburns\\workareas\\dd-3069621-cargotracker-win32-x64-shepherd-control\\1-arrival-deadline-control-remove-before-merge\\prompts\\shepherd-task-20-20260927-1549','C:\\Users\\edburns\\.copilot\\plugins\\shepherd-task\\scripts\\validate-stage20-drafts.ps1','C:\\Users\\edburns\\.copilot\\plugins\\shepherd-task\\scripts\\verify-github-issue-body.ps1','C:\\Users\\edburns\\.copilot\\plugins\\shepherd-task\\scripts\\verify-stage20-child-links.ps1'); foreach($p in $paths){ $item=Get-Item -LiteralPath $p -ErrorAction Stop; [pscustomobject]@{Path=$item.FullName;Type=if($item.PSIsContainer){'Directory'}else{'File'}} }; $probe=Join-Path $paths[0] '.write-probe'; [IO.File]::WriteAllText($probe,'ok'); Remove-Item -LiteralPath $probe; New-Item -ItemType Directory -Force -Path (Join-Path $paths[0] 'issue-bodies') | Out-Null; 'LOG_WRITABLE=YES'",
  "description": "Validate log directory and scripts"
}
```

</details>

<details>
<summary>8 lines</summary>

```
Path
----                                                                                                                   
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before…
C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\validate-stage20-drafts.ps1                                    
C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\verify-github-issue-body.ps1                                   
C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\verify-stage20-child-links.ps1                                 
LOG_WRITABLE=YES
<shellId: 0 completed with exit code 0>
```

</details>


---

<sub>29s</sub>

### `powershell`

**Inspect branch campaign files**

<details>
<summary>Arguments</summary>

```json
{
  "command": "$ErrorActionPreference='Stop'; git remote -v; git branch --list 'experiment/shepherd-control'; git show 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md'; git show 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/shepherd-campaign.json'; git cat-file -e 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/campaign-lessons.md'; if($LASTEXITCODE -ne 0){ throw 'Required base-branch campaign files are missing.' }",
  "description": "Inspect branch campaign files"
}
```

</details>

<details>
<summary>12 lines</summary>

```
Output too large to read at once (34.2 KB). Saved to: C:\Users\edburns\AppData\Local\Temp\1790538584708-copilot-tool-output-22248-caffa9aa-8ebd-40d4-ad15-efec2cde4be0.txt
Consider using tools like rg (for searching), head/tail (for viewing start/end), view with view_range (for specific sections), or jq (for JSON) to examine portions of the output.

Preview (first 500 chars):
origin	git@github.com:edburns/dd-3069621-cargotracker-win32-x64.git (fetch)
origin	git@github.com:edburns/dd-3069621-cargotracker-win32-x64.git (push)
* experiment/shepherd-control
# Implementation plan: Change Arrival Deadline Date (`eclipse-ee4j/cargotracker#64`)

Human DRI: Ed Burns
Starting commit: `9b9f311b2a3a2854bdac947593950d9edb6bca7d` (`Make the system ready for implementation`)
Working directory: repository root of the current campaign worktree
Runtime baseline: Java 17, Java EE 7 (`j
<shellId: 2 completed with exit code 0>
```

</details>


---

<sub>30s</sub>

### `powershell`

**Validate repository parent and issue types**

<details>
<summary>Arguments</summary>

```json
{
  "command": "$ErrorActionPreference='Stop'; $repo='edburns/dd-3069621-cargotracker-win32-x64'; $repoOut=& gh api \"repos/$repo\" 2>&1; $repoCode=$LASTEXITCODE; if($repoCode -ne 0){throw ($repoOut|Out-String)}; $repoJson=($repoOut|Out-String)|ConvertFrom-Json; $parentOut=& gh api \"repos/$repo/issues/1\" 2>&1; $parentCode=$LASTEXITCODE; if($parentCode -ne 0){throw ($parentOut|Out-String)}; $parentJson=($parentOut|Out-String)|ConvertFrom-Json; [pscustomobject]@{default_branch=$repoJson.default_branch;owner_login=$repoJson.owner.login;owner_type=$repoJson.owner.type;parent_number=$parentJson.number;parent_state=$parentJson.state;parent_url=$parentJson.html_url}|ConvertTo-Json -Compress; if($repoJson.owner.type -eq 'Organization'){ $typesOut=& gh api \"orgs/$($repoJson.owner.login)/issue-types\" 2>&1; $typesCode=$LASTEXITCODE; if($typesCode -ne 0){throw ($typesOut|Out-String)}; 'ISSUE_TYPES=' + ($typesOut|Out-String).Trim() } elseif($repoJson.owner.type -eq 'User'){ 'ISSUE_TYPES=UNAVAILABLE_FOR_USER_OWNER' } else { throw \"Unrecognized owner type: $($repoJson.owner.type)\" }",
  "description": "Validate repository parent and issue types"
}
```

</details>

```
{"default_branch":"20260902-2104Z-commit-e7b651f-liberty","owner_login":"edburns","owner_type":"User","parent_number":1,"parent_state":"open","parent_url":"https://github.com/edburns/dd-3069621-cargotracker-win32-x64/issues/1"}
ISSUE_TYPES=UNAVAILABLE_FOR_USER_OWNER
<shellId: 1 completed with exit code 0>
```


---

<sub>35s</sub>

### Copilot

Validation passed: the non-default base branch exists, parent #1 is open, the owner is a user account, so children will be created **without an issue type**. I’m now extracting the resolved decisions, implementation subsections, supporting findings, and normalized pre-creation child baseline.

---

<sub>43s</sub>

### `view`

**view the file at C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md.**

C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md (lines 1-220)

<details>
<summary>171 lines</summary>

````
# Implementation plan: Change Arrival Deadline Date (`eclipse-ee4j/cargotracker#64`)

Human DRI: Ed Burns
Starting commit: `9b9f311b2a3a2854bdac947593950d9edb6bca7d` (`Make the system ready for implementation`)
Working directory: repository root of the current campaign worktree
Runtime baseline: Java 17, Java EE 7 (`javax.*`), Open Liberty 26.0.0.8, PrimeFaces 8.0
Baseline run instructions: `README.md`
Baseline preparation: fixed source branch and immutable SHA validated by the campaign fixture
Historical issue: `eclipse-ee4j/cargotracker#64`

Related directories and files:

- `src/main/java/org/eclipse/cargotracker/application/`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/`
- `src/main/webapp/admin/dialogs/`
- `src/main/webapp/admin/tables/listNotRouted.xhtml`
- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`

---

## Goal

Add an Administration dashboard operation that lets a shipping administrator
change the arrival deadline of a cargo listed in the **Not Routed Cargo** table.
The operation must preserve Cargo Tracker's layered architecture:

1. The application service owns the domain mutation.
2. The booking facade shields the web layer from domain types.
3. A JSF backing bean loads and submits the editable date.
4. A PrimeFaces dynamic dialog presents the editor.
5. The existing Not Routed Cargo table opens the dialog and refreshes after a
   successful update.

### User-visible acceptance behavior

Using the stable sample cargo `DEF789`:

1. Start the application with Java 17:

   ```bash
   ./mvnw clean package -Popenliberty liberty:run
   ```

2. Open `http://localhost:8080/cargo-tracker/`.
3. Select **Administration**.
4. Find `DEF789` in the **Not Routed Cargo** table.
5. The Deadline cell displays its date together with an edit icon.
6. Hovering over the deadline displays:
   `Click to change cargo arrival deadline date.`
7. Selecting the deadline opens a modal dialog titled **Change Deadline**.
8. The dialog displays the cargo's origin and destination as read-only
   context.
9. The date editor is initialized to the cargo's current arrival deadline.
10. Selecting a different date and pressing **Update** closes the dialog and
    refreshes the Administration view.
11. The new date is shown in the Not Routed Cargo table.
12. Reloading the page continues to show the new date for the lifetime of the
    running in-memory sample application.
13. Pressing **Cancel** closes the dialog without changing the deadline.

### Domain acceptance behavior

Changing the deadline must:

- locate the cargo by `TrackingId`;
- preserve its existing origin;
- preserve its existing destination;
- replace only the arrival deadline in its `RouteSpecification`;
- apply the specification through `Cargo.specifyNewRoute(...)`;
- preserve the currently assigned itinerary rather than silently discarding
  it;
- allow the domain model to recalculate routing status and delivery-derived
  values against the new route specification;
- persist the changed cargo through `CargoRepository.store(...)`.

### Hard scope constraints

- Begin from commit `9b9f311b2a3a2854bdac947593950d9edb6bca7d`.
- Preserve Java EE 7 and the `javax.*` namespace.
- Preserve the Java 7 source/target level used by this historical codebase.
- Run the application on JDK 17 using the existing Open Liberty profile.
- Do not migrate the application to Jakarta EE 8+, Jakarta EE 9+, Spring, or a
  different UI framework.
- Do not replace the in-memory Derby configuration or the Open Liberty runtime.
- Do not redesign unrelated cargo booking, routing, destination editing,
  messaging, batch, REST, or persistence behavior.
- Do not copy commits or files from feature-bearing branches. This plan is the
  implementation specification.
- Implement the five build issues below in order. Each issue must be complete
  and gated before the next issue begins.

---

## Completed phases

### Phase 1 ✅ — Establish a runnable feature-absent baseline

- Commit `9b9f311b2a3a2854bdac947593950d9edb6bca7d` is based on the historical
  feature-absent commit and contains only the compatibility work needed to run
  the sample on JDK 17 and Open Liberty.
- `./mvnw clean package -Popenliberty liberty:run` starts the application.
- The home page and Administration flows return HTTP 200.
- JSF view metadata is placed at `UIViewRoot` scope for MyFaces compatibility.
- The internal routing REST client works without a Jersey/MOXy classloading
  conflict.
- The scheduled batch job has the local authorization it needs.

### Phase 2 ✅ — Verify the before and after user experience

- Before implementation, `DEF789` appears in the Not Routed Cargo table with a
  plain-text deadline and no edit operation.
- The neighboring Destination column demonstrates the existing PrimeFaces
  dynamic-dialog interaction pattern.
- The desired after behavior has been manually exercised: open the deadline
  editor, choose a new date, update, refresh the table, and observe the
  persisted value.
- The historical architectural boundaries and affected files have been
  identified.

---

## Phase 3 — Ignorance reduction: questions to answer before writing code

Resolve these questions before production implementation begins. The
recommendations intentionally define the desired design closely enough that an
implementing agent should not need to invent a different architecture.

### 3.1 — Which cargos expose the edit operation?

**Question:** Should deadline editing be exposed for all cargos or only for
cargos displayed in the Not Routed Cargo table?

The requested feature originates in the Administration dashboard's Not Routed
Cargo table. Other tables represent routed, misrouted, claimed, or otherwise
progressed cargo. Adding the affordance to every table would expand the feature
and require additional business rules about changing deadlines after handling
has begun.

| Option | UI scope | Trade-off |
|--------|----------|-----------|
| A | Not Routed Cargo table only | Matches the requested feature and the established destination-edit affordance. |
| B | Every Administration cargo table | Broader capability, but introduces lifecycle and authorization questions outside the request. |
| C | Cargo details page only | Avoids table complexity but does not meet the requested dashboard interaction. |

The application-service operation itself does not need to encode a UI-table
restriction. It should accept a tracking ID and apply the domain mutation to
the located cargo. The presentation layer determines where the operation is
offered.

**Recommendation:** Option A. Add the edit affordance only to
`src/main/webapp/admin/tables/listNotRouted.xhtml`. Keep the application
operation generally usable for a valid cargo.

**Resolution:**

Select Option A. Expose the edit affordance only in
`src/main/webapp/admin/tables/listNotRouted.xhtml`. The application and facade
operations remain generally callable for any cargo that can be found by
tracking ID; they do not encode knowledge of dashboard table membership.

### 3.2 — What is the exact domain mutation?

**Question:** Should the feature mutate the existing `RouteSpecification`, add
a setter to `Cargo`, or replace the specification using the existing domain
operation?

`RouteSpecification` is a value object describing origin, destination, and
arrival deadline. The existing `changeDestination(...)` implementation already
establishes the correct pattern: create a replacement specification, call
`Cargo.specifyNewRoute(...)`, and store the aggregate.

Proposed application-service shape:

```java
void changeDeadline(TrackingId trackingId, Date deadline);
```

Proposed implementation:

```java
Cargo cargo = cargoRepository.find(trackingId);
RouteSpecification specification = new RouteSpecification(
        cargo.getOrigin(),
        cargo.getRouteSpecification().getDestination(),
        deadline);

cargo.specifyNewRoute(specification);
cargoRepository.store(cargo);
```

Calling `specifyNewRoute(...)` is significant. It lets the aggregate recalculate
delivery and routing status relative to the new specification. Direct field
mutation or a persistence-only update would bypass that behavior.

**Recommendation:** Replace the `RouteSpecification` through
`Cargo.specifyNewRoute(...)`. Preserve origin, destination, and itinerary.
Persist using the existing repository. Do not add a deadline setter to the
domain model.

**Resolution:**

Use the same aggregate-update pattern as `changeDestination(...)`. Add
`BookingService.changeDeadline(TrackingId, Date)` and implement it by loading
the cargo, constructing a new `RouteSpecification` from the existing origin,
existing destination, and supplied deadline, calling
`cargo.specifyNewRoute(...)`, and storing the cargo through
`cargoRepository.store(...)`. Do not add mutable deadline setters to the domain
objects.

### 3.3 — What should happen to an existing itinerary and delivery state?

**Question:** When a routed cargo's deadline changes, should its itinerary be
cleared, retained, or recomputed?

Although the UI initially exposes the feature only for unrouted cargo, the
application operation should have deterministic domain behavior if invoked for
a routed cargo. The existing `changeDestination(...)` behavior preserves the
assigned itinerary and lets `Cargo.specifyNewRoute(...)` recalculate whether
that itinerary still satisfies the new specification.
````

</details>


---

<sub>44s</sub>

### `view`

**view the file at C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md.**

C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md (lines 221-500)

<details>
<summary>208 lines</summary>

````

The core application test should deliberately invoke the operation after:

1. booking a cargo;
2. requesting route candidates;
3. assigning an itinerary;
4. changing its destination;
5. changing its deadline.

This sequence verifies that the feature uses the aggregate correctly rather
than assuming the cargo always has an empty itinerary.

**Recommendation:** Preserve the itinerary. Let the domain model recompute
routing and delivery-derived state. Assert all unaffected fields explicitly in
`BookingServiceTest`.

**Resolution:**

Retain the existing itinerary. Do not clear, replace, or reroute it as part of
the deadline change. `Cargo.specifyNewRoute(...)` recalculates the delivery
snapshot and routing status against the replacement specification. In the
established sequential application test, the assigned itinerary remains
unchanged and the cargo remains `MISROUTED` after the deadline changes.

### 3.4 — What type crosses the facade boundary?

**Question:** Should the booking facade accept a `Date`, a formatted string, or
a newly introduced request DTO?

The existing facade already uses `java.util.Date` for
`bookNewCargo(...)`. Introducing another representation for this one operation
would create unnecessary conversion code and depart from the historical
application style.

Proposed facade shape:

```java
void changeDeadline(String trackingId, Date arrivalDeadline);
```

The implementation converts only the identifier:

```java
bookingService.changeDeadline(
        new TrackingId(trackingId),
        arrivalDeadline);
```

**Recommendation:** Use `String` for the tracking ID and `java.util.Date` for
the deadline. Do not expose `TrackingId`, `Cargo`, or `RouteSpecification` to
the JSF layer and do not introduce a new DTO solely for this command.

**Resolution:**

Add `void changeDeadline(String trackingId, Date arrivalDeadline)` to
`BookingServiceFacade`. `DefaultBookingServiceFacade` converts the string to
`new TrackingId(trackingId)` and passes the same `Date` to
`BookingService.changeDeadline(...)`. No new command DTO or formatted-string
service parameter is introduced.

### 3.5 — How is the DTO's formatted deadline converted for editing?

**Question:** `CargoRoute` exposes its deadline as formatted strings, while
`p:datePicker` binds naturally to `java.util.Date`. How should the backing bean
initialize the editor?

At the starting commit:

- `CargoRoute.getArrivalDeadline()` returns
  `MM/dd/yyyy hh:mm a z`.
- `CargoRoute.getArrivalDeadlineDate()` returns only the date component.
- The table displays `getArrivalDeadlineDate()`.

Options:

| Option | Approach | Trade-off |
|--------|----------|-----------|
| A | Parse `cargo.getArrivalDeadlineDate()` with `MM/dd/yyyy` | Small, localized change; preserves the existing DTO contract. |
| B | Add a `Date` property to `CargoRoute` | Cleaner typing, but broadens a DTO used throughout the application. |
| C | Reload the domain object in the backing bean | Violates the facade boundary. |

The formatter/parser must be created per operation or per view bean; do not add
a shared mutable `SimpleDateFormat`.

**Recommendation:** Option A. Load `CargoRoute` through
`BookingServiceFacade.loadCargoForRouting(trackingId)` and parse
`cargo.getArrivalDeadlineDate()` using `new SimpleDateFormat("MM/dd/yyyy")`.
Surface an explicit failure if the existing DTO value cannot be parsed; do not
silently submit a null date.

**Resolution:**

Use Option A and keep date conversion inside the view-scoped editor bean. The
existing implementation loads the `CargoRoute`, creates
`new SimpleDateFormat("MM/dd/yyyy")`, and parses the leading date portion of
`cargo.getArrivalDeadline()`. Because that value begins with `MM/dd/yyyy`,
`SimpleDateFormat.parse(...)` obtains the same date that
`getArrivalDeadlineDate()` displays. A per-load formatter is used, so no shared
mutable formatter is added.

### 3.6 — Which JSF bean scopes and interaction pattern should be used?

**Question:** Should deadline editing introduce a new navigation page, use an
inline editor, or mirror the existing Change Destination dynamic-dialog
pattern?

The baseline already contains:

- `ChangeDestination`, a CDI `@Named` and JSF `@ViewScoped` editor bean;
- `ChangeDestinationDialog`, a session-scoped JSF managed bean that opens and
  closes a PrimeFaces dynamic dialog;
- `changeDestination.xhtml`, a dialog view;
- a `dialogReturn` Ajax listener that refreshes `tableNotRouted`.

Using the same pattern minimizes changes and provides a consistent user
experience.

Proposed bean names:

```text
changeArrivalDeadlineDate
changeArrivalDeadlineDateDialog
```

**Recommendation:** Add a serializable CDI `@Named @ViewScoped`
`ChangeArrivalDeadlineDate` editor and a serializable
`@ManagedBean(name = "changeArrivalDeadlineDateDialog") @SessionScoped`
launcher. Mirror the existing destination-dialog lifecycle rather than
introducing a new navigation or inline-edit framework.

**Resolution:**

Mirror the existing Change Destination interaction. Implement
`ChangeArrivalDeadlineDate` as a serializable CDI `@Named @ViewScoped` bean and
`ChangeArrivalDeadlineDateDialog` as a serializable
`@ManagedBean(name = "changeArrivalDeadlineDateDialog") @SessionScoped` bean.
Use a PrimeFaces dynamic dialog rather than navigation to a full page or inline
cell editing.

### 3.7 — What is the dynamic-dialog contract?

**Question:** What path, request parameters, dimensions, and close result should
the PrimeFaces dialog use?

The launcher needs one parameter, `trackingId`, supplied as a
`Map<String, List<String>>`. The dialog metadata binds the parameter and invokes
the editor bean's `load()` action.

Proposed launcher contract:

```java
PrimeFaces.current().dialog().openDynamic(
        "/admin/dialogs/changeArrivalDeadlineDate.xhtml",
        options,
        params);
```

Required options:

| Option | Value |
|--------|-------|
| `modal` | `true` |
| `draggable` | `true` |
| `resizable` | `false` |
| `contentWidth` | `410` |
| `contentHeight` | `280` |

Required completion behavior:

- successful update: `closeDynamic("DONE")`;
- cancel: `closeDynamic("")`;
- caller listens for `dialogReturn` and updates `tableNotRouted`.

Because Open Liberty uses MyFaces, `<f:metadata>` must be a direct child of the
view root, before `<h:head>` and `<h:body>`. It must not be nested inside
`<h:body>`.

**Recommendation:** Use the contract above and preserve the metadata placement
required by the prepared baseline.

**Resolution:**

Open `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with a single
`trackingId` request parameter and these options: modal and draggable are
`true`, resizable is `false`, content width is `410`, and content height is
`280`. Successful submission closes with `"DONE"`; cancellation closes with
the empty string. The caller handles `dialogReturn` and updates
`tableNotRouted`. Place the dialog's `<f:metadata>` directly under the root
`<html>` element, before `<h:head>` and `<h:body>`, so the known MyFaces
`UIViewRoot` requirement is satisfied.

### 3.8 — What date validation is required?

**Question:** Must the new deadline be non-null, in the future, after the
current date, or after itinerary completion?

The requested feature is an administrative correction to an existing arrival
deadline. No new domain policy about future dates is part of the request.
Inventing such a rule could reject dates accepted by existing cargo booking or
`RouteSpecification` behavior.

The UI must nevertheless prevent a null submission because the operation
requires a concrete replacement deadline.

**Recommendation:** Require a date value in the JSF form and display a normal
Faces validation message when it is absent. Do not add a new minimum-date,
future-date, or itinerary-date business rule. Continue to rely on the existing
domain model for its established invariants.

**Resolution:**

Require a non-null date selection, but add no new chronological business rule.
In particular, do not require the replacement deadline to be after today,
after the old deadline, or after every itinerary leg. Pass the selected
`java.util.Date` to the existing domain construction path and let the current
`RouteSpecification` invariants apply.

### 3.9 — How will the feature be tested on the prepared historical baseline?

**Question:** Which automated and runtime tests are mandatory, given that the
historical JUnit/Arquillian suite is configured for a remote Payara 4
container, while the prepared production baseline runs on JDK 17/Open Liberty?

The starting POM deliberately leaves `skipTests=true`. The Open Liberty profile
builds and compiles all test sources but does not provide a Liberty Arquillian
adapter. Modernizing the entire integration-test runtime is outside this
feature's scope.

The feature still needs layered evidence:

1. Extend `BookingServiceTest` with the domain/application assertions that
   specify the deadline mutation.
2. Ensure all test sources compile as part of
   `./mvnw clean package -Popenliberty`.
3. Add focused JUnit tests for facade and backing-bean delegation where they
   can run without a container, using hand-written fakes rather than adding a
   mocking framework.
4. Perform mandatory end-to-end verification against the running Open Liberty
   application.
5. Preserve the existing Payara Arquillian test path; do not delete, disable,
   or rewrite it to manufacture a passing result.

**Spike needed:** Before Issue 1 implementation, run the starting commit's
standard Open Liberty package command and record whether tests are compiled but
skipped. Confirm the new `BookingServiceTest` method can be added without
expanding the runtime modernization scope.

**Recommendation:** Treat the JDK 17/Open Liberty build plus HTTP/UI acceptance
as the mandatory executable gate. Keep the historical Arquillian test as a
precise application-layer specification and run it only when its documented
Payara environment is available.

**Resolution:**

Extend the existing sequential Arquillian `BookingServiceTest` with
`testChangeDeadline()` after `testChangeDestination()`. The test changes the
deadline by one month, reloads the cargo through JPA, and asserts the complete
set of preserved and recalculated domain state described above. The prepared
Open Liberty build compiles this test but retains the historical default
`skipTests=true`; executing that Arquillian suite still requires its documented
remote Payara environment. Therefore the mandatory executable gates are the
JDK 17 Open Liberty package/start command, direct HTTP checks, and the complete
`DEF789` browser acceptance flow. No Arquillian-runtime modernization or new
mocking dependency is part of this feature.

---

## Phase 4 — Implementation (five serial issues)

Implement these issues in order. Each issue should be a separate commit. Do not
start an issue until the previous issue's gating criteria are satisfied.

### 4.1 — Issue 1: Add the application-layer deadline change operation

**What to build**

Add the core use case to the application layer. This issue must contain no JSF
or PrimeFaces changes.

**Files to modify**
````

</details>


---

<sub>44s</sub>

### `glob`

**1-arrival-deadline-control-remove-before-merge\**\***

"1-arrival-deadline-control-remove-before-merge\**\*"

<details>
<summary>7 matches</summary>

```
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\shepherd-test-experiment.json
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\shepherd-campaign.json
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\campaign-lessons.md
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549\create-issues-otel-20260927-1549.jsonl
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549\20260927-1549-invoke-shepherd-task-20-create-issues-from-plan-skill.ps1
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549\20260927-1549-invoke-shepherd-task-20-create-issues-from-plan-skill.md
```

</details>


---

<sub>45s</sub>

### `powershell`

**Normalize and save child baseline**

<details>
<summary>Arguments</summary>

```json
{
  "command": "$ErrorActionPreference='Stop'; $repo='edburns/dd-3069621-cargotracker-win32-x64'; $out=& gh api \"repos/$repo/issues/1/sub_issues\" --paginate --slurp 2>&1; $code=$LASTEXITCODE; if($code -ne 0){throw ($out|Out-String)}; $raw=($out|Out-String); $normalizedOut=$raw | jq 'if length == 0 then [] elif all(.[]; type == \"array\") then add else . end'; $jqCode=$LASTEXITCODE; if($jqCode -ne 0){throw 'Failed to normalize paginated child response.'}; $normalized=($normalizedOut|Out-String).Trim(); $parsed=$normalized|ConvertFrom-Json -NoEnumerate; if($parsed -isnot [System.Array]){throw 'Normalized child response is not an array.'}; $path='C:\\Users\\edburns\\workareas\\dd-3069621-cargotracker-win32-x64-shepherd-control\\1-arrival-deadline-control-remove-before-merge\\prompts\\shepherd-task-20-20260927-1549\\pre-creation-children.json'; $tmp=\"$path.tmp\"; [IO.File]::WriteAllText($tmp,$normalized+[Environment]::NewLine,[Text.UTF8Encoding]::new($false)); Move-Item -Force -LiteralPath $tmp -Destination $path; [pscustomobject]@{count=$parsed.Count;children=@($parsed|ForEach-Object{[pscustomobject]@{id=$_.id;number=$_.number;title=$_.title}})}|ConvertTo-Json -Depth 5",
  "description": "Normalize and save child baseline"
}
```

</details>

```
{
  "count": 0,
  "children": []
}
<shellId: 3 completed with exit code 0>
```


---

<sub>53s</sub>

### `view`

**view the file at C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md.**

C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md (lines 500-760)

<details>
<summary>187 lines</summary>

````
**Files to modify**

- `src/main/java/org/eclipse/cargotracker/application/BookingService.java`
- `src/main/java/org/eclipse/cargotracker/application/internal/DefaultBookingService.java`
- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`

**Required API**

```java
void changeDeadline(TrackingId trackingId, Date deadline);
```

**Required implementation behavior**

1. Load the cargo using `cargoRepository.find(trackingId)`.
2. Obtain the current destination from
   `cargo.getRouteSpecification().getDestination()`.
3. Construct a replacement `RouteSpecification` from:
   - `cargo.getOrigin()`;
   - the current destination;
   - the new deadline.
4. Apply it using `cargo.specifyNewRoute(routeSpecification)`.
5. Persist using `cargoRepository.store(cargo)`.
6. Log the tracking ID and new deadline at `Level.INFO`, following the style of
   `changeDestination(...)`.

Do not:

- add a setter to `Cargo` or `RouteSpecification`;
- modify the origin or destination;
- clear or replace the itinerary directly;
- update persistence entities behind the aggregate's back.

**Tests to write first**

Append a sequential `testChangeDeadline()` case to `BookingServiceTest` after
`testChangeDestination()`. Build a new deadline one month after the test's
original `deadline`, invoke the service, reload the cargo with
`Cargo.findByTrackingId`, and assert:

- origin remains Chicago;
- destination remains Helsinki;
- stored deadline is the same calendar day as the requested new deadline;
- assigned itinerary remains unchanged;
- transport status remains `NOT_RECEIVED`;
- last known location remains `Location.UNKNOWN`;
- current voyage remains `Voyage.NONE`;
- cargo is not marked misdirected;
- estimated time of arrival is `Delivery.ETA_UNKOWN`;
- next expected activity is `Delivery.NO_ACTIVITY`;
- cargo is not unloaded at destination;
- routing status reflects the domain model's recalculation and remains
  `MISROUTED` for the established test sequence.

**Gating criteria**

- The test source compiles.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
- No web, facade, REST, Liberty, or persistence configuration files change in
  this issue.

### 4.2 — Issue 2: Expose deadline changes through the booking facade

**What to build**

Expose the use case to presentation clients without leaking domain identifier
types into the web layer.

**Files to modify**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/BookingServiceFacade.java`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacade.java`

**Optional focused test file**

- `src/test/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacadeTest.java`

**Required API**

```java
void changeDeadline(String trackingId, Date arrivalDeadline);
```

**Required implementation**

```java
bookingService.changeDeadline(
        new TrackingId(trackingId),
        arrivalDeadline);
```

The facade must not:

- load and mutate `Cargo` itself;
- call `CargoRepository.store(...)`;
- parse a formatted date;
- introduce JSF or PrimeFaces types.

**Tests**

Where a container-free test is added, use a hand-written `BookingService` fake
or spy and prove that:

- the same `Date` object/value reaches the application service;
- the tracking-ID string is converted to an equivalent `TrackingId`;
- the facade delegates exactly once;
- no repository work is duplicated in the facade.

Do not add Mockito or another dependency solely for this test.

**Gating criteria**

- Existing facade consumers still compile.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
- The application-layer test added in Issue 1 remains unchanged and compiling.

### 4.3 — Issue 3: Implement the deadline editor backing model

**What to build**

Add the view-scoped backing bean that loads a cargo's current deadline and
submits a replacement deadline through the booking facade. Do not add the
dialog launcher or XHTML in this issue.

**File to create**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDate.java`

**Required bean shape**

```java
@Named
@ViewScoped
public class ChangeArrivalDeadlineDate implements Serializable {
    private static final long serialVersionUID = 1L;

    private String trackingId;
    private CargoRoute cargo;
    private Date arrivalDeadlineDate;

    @Inject
    private BookingServiceFacade bookingServiceFacade;
}
```

Required properties and methods:

- `getTrackingId()` / `setTrackingId(String)`
- `getCargo()`
- `getArrivalDeadlineDate()` / `setArrivalDeadlineDate(Date)`
- `load()`
- `changeArrivalDeadline()`

**Load behavior**

1. Call `bookingServiceFacade.loadCargoForRouting(trackingId)`.
2. Store the returned `CargoRoute`.
3. Parse `cargo.getArrivalDeadlineDate()` using `MM/dd/yyyy`.
4. Store the resulting `Date` in `arrivalDeadlineDate`.
5. Do not query a repository or domain object directly.
6. Do not ignore a parsing failure or merely print its stack trace. Surface a
   clear application/view error consistent with existing JSF behavior.

**Submit behavior**

1. Refuse a null date through JSF validation or explicit bean validation.
2. Call
   `bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate)`.
3. Close the dynamic dialog with:

   ```java
   PrimeFaces.current().dialog().closeDynamic("DONE");
   ```

4. Do not close the dialog if the facade call fails.

**Tests to write**

Add a container-free JUnit test if practical, using a hand-written fake facade,
that proves:

- `load()` requests the correct tracking ID;
- `load()` converts an `MM/dd/yyyy` DTO date into the editable `Date`;
- `changeArrivalDeadline()` delegates the selected date and tracking ID;
- a malformed DTO deadline is surfaced rather than converted to null;
- a null selected date is rejected.

Do not add a mocking framework solely for these tests.

**Gating criteria**

- The bean is serializable and uses the established CDI/JSF annotations.
- The bean references only facade DTOs, not domain model classes.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.

### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog

**What to build**

Add the session-scoped dialog launcher and the dynamic dialog view. The dialog
must work when addressed directly with a `trackingId` query parameter, but it
is not yet linked from the dashboard in this issue.

**Files to create**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDateDialog.java`
- `src/main/webapp/admin/dialogs/changeArrivalDeadlineDate.xhtml`

**Launcher requirements**

Use:

```java
@ManagedBean(name = "changeArrivalDeadlineDateDialog")
@SessionScoped
```

Implement:

- `showDialog(String trackingId)`
- `handleReturn(SelectEvent event)`
- `cancel()`

`showDialog(...)` must:

- set the options documented in Question 3.7;
- pass `trackingId` as a dynamic-dialog request parameter;
- open `/admin/dialogs/changeArrivalDeadlineDate.xhtml`.

`cancel()` must close the dialog without invoking the facade.

**XHTML requirements**

The page title must be:

```xhtml
<title>Change Deadline</title>
```

Place metadata directly beneath the root `<html>` element and before
`<h:head>`:

```xhtml
<f:metadata>
    <f:viewParam name="trackingId"
                 value="#{changeArrivalDeadlineDate.trackingId}"/>
    <f:viewAction action="#{changeArrivalDeadlineDate.load}"/>
</f:metadata>
```

The form must display:

- `Origin:` and `changeArrivalDeadlineDate.cargo.originName`;
- `Destination:` and
  `changeArrivalDeadlineDate.cargo.finalDestinationName`;
- `Deadline:` and a `p:datePicker` bound to
  `changeArrivalDeadlineDate.arrivalDeadlineDate`;
- **Cancel**, invoking
  `changeArrivalDeadlineDateDialog.cancel()`;
- **Update**, invoking
  `changeArrivalDeadlineDate.changeArrivalDeadline()`.
````

</details>


---

<sub>54s</sub>

### `view`

**view the file at C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\shepherd-campaign.json.**

C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\shepherd-campaign.json

<details>
<summary>16 lines</summary>

```
{
  "schemaVersion": 1,
  "campaignId": "ce692e79-febf-4b62-be97-8761f1b47240",
  "campaignIssueNumber": 1,
  "campaignShortname": "arrival-deadline-control",
  "repository": "edburns/dd-3069621-cargotracker-win32-x64",
  "baseBranch": "experiment/shepherd-control",
  "lessonPropagation": "off",
  "campaignMetadataDirectory": "1-arrival-deadline-control-remove-before-merge",
  "lessonsFile": "campaign-lessons.md",
  "createdBy": {
    "shepherdTaskVersion": "1.0.5",
    "stageOutcomeProtocolVersion": 1
  },
  "createdAt": "2026-09-27T19:49:12Z"
}
```

</details>


---

<sub>53s</sub>

### `view`

**view the file at C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\campaign-lessons.md.**

C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\campaign-lessons.md

<details>
<summary>5 lines</summary>

```
# Campaign lessons

This file contains validated, reusable lessons for subsequent issues in this campaign.
The issue specification and repository instructions remain authoritative.

## Validated lessons

No validated lessons have been recorded yet.
```

</details>


---

<sub>54s</sub>

### `rg`

**^## Phase 3 — Ignorance reduction: questions to answer before writing code$|^## Phase 4 — Implementation \(five serial issues\)$|^### 4\.[0-9]+**

"^## Phase 3 — Ignorance reduction: questions to answer before writing code$|^## Phase 4 — Implementation \(five serial issues\)$|^### 4\.[0-9]+" (1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md)

<details>
<summary>7 matches</summary>

```
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md:123:## Phase 3 — Ignorance reduction: questions to answer before writing code
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md:488:## Phase 4 — Implementation (five serial issues)
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md:493:### 4.1 — Issue 1: Add the application-layer deadline change operation
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md:561:### 4.2 — Issue 2: Expose deadline changes through the booking facade
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md:616:### 4.3 — Issue 3: Implement the deadline editor backing model
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md:695:### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md:792:### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard
```

</details>


---

<sub>58s</sub>

### `view`

**view the file at C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md.**

C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\add-change-arrival-deadline-feature-ignorance-reduction-plan.md (lines 760-930)

<details>
<summary>115 lines</summary>

````
  `changeArrivalDeadlineDate.changeArrivalDeadline()`.

The date picker must require a value. The Update action must reload or refresh
the calling Administration view after a successful dialog close, following the
existing destination-dialog behavior.

**Runtime tests**

With the application running, request:

```text
http://localhost:8080/cargo-tracker/admin/dialogs/changeArrivalDeadlineDate.xhtml?trackingId=DEF789
```

Verify:

- HTTP 200;
- title is **Change Deadline**;
- origin and destination render;
- the existing deadline is selected;
- no `TagException`, `Parent UIComponent`, `FacesException`, or server error is
  present;
- Cancel does not change the persisted deadline;
- Update changes the deadline.

**Gating criteria**

- `./mvnw clean package -Popenliberty liberty:run` succeeds on JDK 17.
- Direct dialog loading and both actions work.
- Destination editing continues to work.
- Stop Liberty cleanly before completing the issue.

### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard

**What to build**

Replace the plain deadline text in the Not Routed Cargo table with the
PrimeFaces command-link affordance that opens the completed dialog and refreshes
the table after return.

**File to modify**

- `src/main/webapp/admin/tables/listNotRouted.xhtml`

**Required UI shape**

Within the existing Deadline column, add a `p:commandLink` that:

- calls
  `changeArrivalDeadlineDateDialog.showDialog(cargoNotRouted.trackingId)`;
- retains the displayed
  `cargoNotRouted.arrivalDeadlineDate`;
- adds the existing Font Awesome edit icon style;
- uses a stable component ID such as `arrivalDeadlineToUpdate`;
- listens for `dialogReturn`;
- invokes
  `changeArrivalDeadlineDateDialog.handleReturn`;
- updates `tableNotRouted`;
- provides the tooltip:
  `Click to change cargo arrival deadline date.`

Follow the adjacent Destination column's established structure and styling. Do
not alter tracking-ID routing or destination editing.

**End-to-end acceptance test**

1. Start from a clean build on JDK 17:

   ```bash
   ./mvnw clean package -Popenliberty liberty:run
   ```

2. Confirm the home page returns HTTP 200.
3. Open Administration and locate `DEF789`.
4. Record the original deadline.
5. Confirm the deadline now has an edit icon and tooltip.
6. Open the deadline dialog.
7. Confirm origin and destination identify the same cargo.
8. Choose a visibly different date.
9. Press **Update**.
10. Confirm the dialog closes and the Not Routed Cargo table refreshes.
11. Confirm the table shows the selected date.
12. Reload the browser and confirm the selected date remains.
13. Reopen the dialog and confirm the editor initializes to the changed date.
14. Press **Cancel** and confirm no additional change occurs.
15. Verify the Destination edit dialog still opens.
16. Verify selecting `DEF789` for routing still loads without an error page.

**Log acceptance**

The final run must contain none of:

- `<f:metadata> Parent UIComponent`;
- `TagException`;
- `VerifyError`;
- `FacesException`;
- `CWWKZ0002E` or `CWWKZ0003E`;
- recurring batch authorization failures;
- new FFDC files attributable to this feature.

Transient JMS activation-order warnings are acceptable only if all message
endpoints subsequently activate, as established by the prepared baseline.

**Final regression and scope checks**

- `./mvnw clean package -Popenliberty` succeeds.
- The existing test sources and the new deadline test compile.
- No Java EE namespace migration occurred.
- No Open Liberty, Derby, Jackson, JSF metadata, batch authorization, or REST
  compatibility fix from the starting commit was reverted.
- The feature affects only the intended application, facade, web, dialog,
  table, and test surfaces.
- Stop Liberty cleanly.

---

## Phase 5 — Documentation and implementation handoff

- Update `README.md` only if user-facing Administration capabilities are
  enumerated there; add one concise sentence that administrators can change an
  unrouted cargo's arrival deadline.
- Record the exact JDK 17 run command in the final issue or pull-request
  description:

  ```bash
  ./mvnw clean package -Popenliberty liberty:run
  ```

- Include `DEF789` and the before/after deadline values in the acceptance
  evidence.
- State explicitly that data is in-memory and resets when the application is
  rebuilt/restarted.

---

## Cross-cutting concerns

| Concern | Required handling |
|---------|--------------------|
| Domain-driven design | Mutate the aggregate through `Cargo.specifyNewRoute(...)`; do not bypass it with persistence-level field updates. |
| Layering | Web bean → booking facade → booking service → cargo repository. |
| Date handling | Use `java.util.Date` at service/facade boundaries and `MM/dd/yyyy` for the date-only editor representation. |
| Time zones | Acceptance compares the calendar date displayed by the application; do not introduce a new timezone policy in this feature. |
| Error handling | Do not silently swallow parse, lookup, validation, or persistence failures. A failed update must not look successful. |
| JSF compatibility | Keep `<f:metadata>` at view-root scope for MyFaces. |
| Bean lifecycle | Editor is CDI `@ViewScoped`; dynamic-dialog launcher mirrors the existing session-scoped JSF managed bean. |
| Accessibility | Preserve visible labels; the date editor must have an associated label and validation feedback. |
| Backward compatibility | Existing destination editing, routing, tracking, REST, messaging, batch, and startup behavior must remain intact. |
| Test discipline | Add tests before production code where practical; every issue must preserve all prior gates. |
| Experiment integrity | Implement from this specification starting at `9b9f311b2a3a2854bdac947593950d9edb6bca7d`; do not cherry-pick or inspect feature-bearing commits. |
````

</details>


---

<sub>1m 5s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\validate-stage20-drafts.ps1.**

C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\validate-stage20-drafts.ps1

<details>
<summary>60 lines</summary>

```
# shepherd-task-version: 1.0.5
<#
.SYNOPSIS
    Validates persisted stage-20 issue bodies before GitHub mutation.
#>

[CmdletBinding()]
param(
    [Parameter(Mandatory)]
    [string]$BodyDirectory,

    [Parameter(Mandatory)]
    [ValidateRange(1, [int]::MaxValue)]
    [int]$ExpectedCount,

    [Parameter(Mandatory)]
    [ValidateSet('off', 'campaign')]
    [string]$LessonPropagation
)

Set-StrictMode -Version Latest
$ErrorActionPreference = 'Stop'

if (-not (Test-Path -LiteralPath $BodyDirectory -PathType Container)) {
    throw "Stage-20 body directory does not exist: $BodyDirectory"
}

$bodyFiles = @(
    Get-ChildItem -LiteralPath $BodyDirectory -Filter '*-body.md' -File |
        Where-Object { $_.Name -notlike '*-observed-body.md' } |
        Sort-Object Name
)
if ($bodyFiles.Count -ne $ExpectedCount) {
    throw "Expected $ExpectedCount persisted stage-20 body files; found $($bodyFiles.Count)."
}

$requiredHeadings = @(
    '## Campaign context and required reading',
    '## Branch and execution order',
    '## Implement',
    '## Completion gates',
    '## Out of scope'
)

foreach ($bodyFile in $bodyFiles) {
    $text = [System.IO.File]::ReadAllText($bodyFile.FullName)
    $lines = [System.IO.File]::ReadAllLines($bodyFile.FullName)
    if ([string]::IsNullOrWhiteSpace($text) -or $text -notmatch "`r?`n" -or $lines.Count -le 1) {
        throw "Persisted issue body must contain physical Markdown lines: $($bodyFile.FullName)"
    }

    $firstNonblank = $lines | Where-Object { -not [string]::IsNullOrWhiteSpace($_) } | Select-Object -First 1
    if ($firstNonblank -notmatch '^##\s+\S') {
        throw "Persisted issue body must begin with a level-two heading: $($bodyFile.FullName)"
    }

    foreach ($heading in $requiredHeadings) {
        if ($lines -cnotcontains $heading) {
            throw "Persisted issue body is missing the physical heading '$heading': $($bodyFile.FullName)"
        }
    }

    $hasCampaignLessons = $lines -ccontains '## Campaign lessons (REQUIRED)'
    if ($LessonPropagation -eq 'campaign' -and -not $hasCampaignLessons) {
        throw "Treatment issue body is missing its campaign-lessons heading: $($bodyFile.FullName)"
    }
    if ($LessonPropagation -eq 'off' -and $hasCampaignLessons) {
        throw "Control issue body unexpectedly contains a campaign-lessons heading: $($bodyFile.FullName)"
    }
}

$bodyFiles
```

</details>


---

<sub>1m 4s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\verify-stage20-child-links.ps1.**

C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\verify-stage20-child-links.ps1

<details>
<summary>39 lines</summary>

```
# shepherd-task-version: 1.0.5
<#
.SYNOPSIS
    Verifies Stage 20 child count, identity uniqueness, and creation order.
#>

[CmdletBinding()]
param(
    [Parameter(Mandatory)]
    [string]$PreCreationChildrenPath,

    [Parameter(Mandatory)]
    [string]$FinalChildrenPath,

    [Parameter(Mandatory)]
    [string]$CreationLedgerPath
)

Set-StrictMode -Version Latest
$ErrorActionPreference = 'Stop'

$filterPath = Join-Path $PSScriptRoot 'verify-stage20-child-links.jq'
if (-not (Test-Path -LiteralPath $filterPath -PathType Leaf)) {
    throw "Stage-20 child-link verification filter was not found: $filterPath"
}

foreach ($inputPath in @(
    $PreCreationChildrenPath,
    $FinalChildrenPath,
    $CreationLedgerPath
)) {
    if (-not (Test-Path -LiteralPath $inputPath -PathType Leaf)) {
        throw "Stage-20 child-link verification input was not found: $inputPath"
    }
}

$output = & jq -n `
    --slurpfile baseline $PreCreationChildrenPath `
    --slurpfile final $FinalChildrenPath `
    --slurpfile ledger $CreationLedgerPath `
    -f $filterPath 2>&1
$jqExitCode = $LASTEXITCODE
if ($jqExitCode -ne 0) {
    throw "Stage-20 child-link verification failed: $($output | Out-String)"
}

$output
```

</details>


---

<sub>1m 6s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\verify-github-issue-body.ps1.**

C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\verify-github-issue-body.ps1

<details>
<summary>166 lines</summary>

```
# shepherd-task-version: 1.0.5
<#
.SYNOPSIS
    Fetches a GitHub issue through REST and verifies its body against a file.
#>

[CmdletBinding()]
param(
    [Parameter(Mandatory)]
    [ValidatePattern('^[A-Za-z0-9_.-]+/[A-Za-z0-9_.-]+$')]
    [string]$Repository,

    [Parameter(Mandatory)]
    [ValidateRange(1, [int]::MaxValue)]
    [int]$IssueNumber,

    [Parameter(Mandatory)]
    [string]$ExpectedBodyPath,

    [ValidateRange(1, 100)]
    [int]$MaxAttempts = 6,

    [ValidateRange(0, 300)]
    [int]$DelaySeconds = 5,

    [string]$DiagnosticPath,

    [string]$GitHubCli = 'gh'
)

Set-StrictMode -Version Latest
$ErrorActionPreference = 'Stop'
$PSNativeCommandUseErrorActionPreference = $false

function ConvertTo-NormalizedLineEndings {
    param([AllowEmptyString()][string]$Text)
    return $Text -replace "`r`n|`r", "`n"
}

function Test-EquivalentBody {
    param(
        [AllowEmptyString()][string]$Actual,
        [AllowEmptyString()][string]$Expected
    )

    if ($Actual -ceq $Expected) {
        return $true
    }
    if ($Actual.EndsWith("`n") -and $Actual.Substring(0, $Actual.Length - 1) -ceq $Expected) {
        return $true
    }
    if ($Expected.EndsWith("`n") -and $Expected.Substring(0, $Expected.Length - 1) -ceq $Actual) {
        return $true
    }
    return $false
}

function Get-Sha256 {
    param([AllowEmptyString()][string]$Text)

    $bytes = [System.Text.UTF8Encoding]::new($false).GetBytes($Text)
    return [Convert]::ToHexString([System.Security.Cryptography.SHA256]::HashData($bytes)).ToLowerInvariant()
}

function Get-FirstDifference {
    param(
        [AllowEmptyString()][string]$Actual,
        [AllowEmptyString()][string]$Expected
    )

    $limit = [Math]::Min($Actual.Length, $Expected.Length)
    $offset = 0
    while ($offset -lt $limit -and $Actual[$offset] -ceq $Expected[$offset]) {
        $offset++
    }
    if ($offset -eq $limit -and $Actual.Length -eq $Expected.Length) {
        return $null
    }

    $prefix = $Expected.Substring(0, [Math]::Min($offset, $Expected.Length))
    $line = ([regex]::Matches($prefix, "`n").Count) + 1
    $lastNewline = $prefix.LastIndexOf("`n", [StringComparison]::Ordinal)
    $column = if ($lastNewline -lt 0) { $offset + 1 } else { $offset - $lastNewline }
    return [ordered]@{
        offset = $offset
        line = $line
        column = $column
    }
}

function Test-TerminalGitHubFailure {
    param([string]$Message)
    return $Message -match '(?i)(HTTP\s+(401|403)|authentication|not authorized|resource not accessible)'
}

function Write-Diagnostic {
    param(
        [string]$Reason,
        [int]$Attempts,
        [AllowEmptyString()][string]$Actual,
        [AllowEmptyString()][string]$Expected
    )

    if ([string]::IsNullOrWhiteSpace($DiagnosticPath)) {
        return
    }

    $parent = Split-Path -Parent $DiagnosticPath
    if (-not [string]::IsNullOrWhiteSpace($parent) -and
        -not (Test-Path -LiteralPath $parent -PathType Container)) {
        New-Item -ItemType Directory -Path $parent | Out-Null
    }

    $diagnostic = [ordered]@{
        schemaVersion = 1
        repository = $Repository
        issueNumber = $IssueNumber
        endpoint = "repos/$Repository/issues/$IssueNumber"
        attempts = $Attempts
        observedAt = (Get-Date).ToUniversalTime().ToString('o')
        reason = $Reason
        expectedLength = $Expected.Length
        actualLength = $Actual.Length
        expectedSha256 = Get-Sha256 $Expected
        actualSha256 = Get-Sha256 $Actual
        firstDifference = Get-FirstDifference -Actual $Actual -Expected $Expected
    }
    $diagnostic | ConvertTo-Json -Depth 4 |
        Set-Content -LiteralPath $DiagnosticPath -Encoding utf8NoBOM
}

if (-not (Test-Path -LiteralPath $ExpectedBodyPath -PathType Leaf)) {
    throw "Expected issue body file not found: $ExpectedBodyPath"
}

$expected = ConvertTo-NormalizedLineEndings (
    Get-Content -LiteralPath $ExpectedBodyPath -Raw
)
$lastReason = ''
$lastActual = ''
$previousConsoleOutputEncoding = [Console]::OutputEncoding
$previousOutputEncoding = $OutputEncoding
$utf8Encoding = [System.Text.UTF8Encoding]::new($false)

try {
    [Console]::OutputEncoding = $utf8Encoding
    $OutputEncoding = $utf8Encoding

    for ($attempt = 1; $attempt -le $MaxAttempts; $attempt++) {
        $output = (& $GitHubCli api "repos/$Repository/issues/$IssueNumber" 2>&1 | Out-String).Trim()
        $exitCode = $LASTEXITCODE
        if ($exitCode -ne 0) {
            $lastReason = "GitHub REST request failed with exit code $exitCode."
            if (Test-TerminalGitHubFailure $output) {
                Write-Diagnostic -Reason $lastReason -Attempts $attempt -Actual '' -Expected $expected
                throw "Unable to fetch issue #$IssueNumber from ${Repository}: $output"
            }
        }
        else {
            try {
                $issue = $output | ConvertFrom-Json
                $lastActual = ConvertTo-NormalizedLineEndings ([string]$issue.body)
                if (Test-EquivalentBody -Actual $lastActual -Expected $expected) {
                    return $issue
                }
                $lastReason = 'GitHub issue body differs from the persisted draft.'
            }
            catch {
                $lastReason = "GitHub REST response was invalid JSON: $($_.Exception.Message)"
            }
        }

        if ($attempt -lt $MaxAttempts) {
            Write-Warning "$lastReason Retrying issue #$IssueNumber body verification ($attempt/$MaxAttempts)."
            if ($DelaySeconds -gt 0) {
                Start-Sleep -Seconds $DelaySeconds
            }
        }
    }

    Write-Diagnostic -Reason $lastReason -Attempts $MaxAttempts -Actual $lastActual -Expected $expected
    $diagnosticSuffix = if ([string]::IsNullOrWhiteSpace($DiagnosticPath)) {
        ''
    }
    else {
        " Diagnostic: $DiagnosticPath"
    }
    throw "Issue #$IssueNumber body verification failed after $MaxAttempts attempts. $lastReason$diagnosticSuffix"
}
finally {
    $OutputEncoding = $previousOutputEncoding
    [Console]::OutputEncoding = $previousConsoleOutputEncoding
}
```

</details>


---

<sub>1m 10s</sub>

### Copilot

All nine gating questions have complete, substantive resolutions; the plan contains exactly five direct implementation tasks, the campaign manifest matches the supplied UUID and `off` mode, and there are currently no child issues. I’m persisting all five complete specifications and validating them before creating anything.

---

<sub>1m 48s</sub>

### `apply_patch`

<details>
<summary>Arguments</summary>

````json
"*** Begin Patch\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1549/issue-bodies/01-4.1-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, including User-visible acceptance behavior, Domain acceptance behavior, and Hard scope constraints.\n+- `### 3.2 — What is the exact domain mutation?`\n+- `### 3.3 — What should happen to an existing itinerary and delivery state?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.1 — Issue 1: Add the application-layer deadline change operation`\n+- `## Cross-cutting concerns`\n+\n+The resolved design is concrete: add `BookingService.changeDeadline(TrackingId, Date)`, load the cargo, preserve its origin and current destination, create a replacement `RouteSpecification`, apply it through `Cargo.specifyNewRoute(...)`, and persist with `CargoRepository.store(...)`. Preserve the assigned itinerary and allow the aggregate to recalculate delivery and routing state. Do not add a mutable deadline setter.\n+\n+Research on the prepared historical baseline established that the Open Liberty build compiles the Arquillian test sources while retaining the existing `skipTests=true`; executing the remote Arquillian suite still requires its documented Payara environment. The mandatory executable gate for this issue is therefore the JDK 17 Open Liberty package build, while the sequential Arquillian test remains the precise application-layer specification. Do not modernize the test runtime or add a mocking dependency.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the base branch. This is serial task 1 of 5. Tasks are assigned, completed, and merged to the base branch in plan order. Do not begin until this issue is assigned; task 2 must not begin until this task is merged and its gates pass.\n+\n+Begin from the campaign baseline and preserve Java EE 7, `javax.*`, the Java 7 source/target level, JDK 17 runtime compatibility, Open Liberty, and Derby.\n+\n+## Implement\n+\n+Modify only:\n+\n+- `src/main/java/org/eclipse/cargotracker/application/BookingService.java`\n+- `src/main/java/org/eclipse/cargotracker/application/internal/DefaultBookingService.java`\n+- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`\n+\n+Add this application API:\n+\n+```java\n+void changeDeadline(TrackingId trackingId, Date deadline);\n+```\n+\n+Implement it by:\n+\n+1. Loading with `cargoRepository.find(trackingId)`.\n+2. Reading the existing destination from the current route specification.\n+3. Constructing a new `RouteSpecification` from the cargo's existing origin, existing destination, and supplied deadline.\n+4. Calling `cargo.specifyNewRoute(routeSpecification)` so domain-derived state is recalculated.\n+5. Calling `cargoRepository.store(cargo)`.\n+6. Logging tracking ID and new deadline at `Level.INFO` in the style of `changeDestination(...)`.\n+\n+Write the test first. Add sequential `testChangeDeadline()` immediately after `testChangeDestination()` in `BookingServiceTest`. Advance the original test deadline by one month, invoke the operation, reload through `Cargo.findByTrackingId`, and assert:\n+\n+- origin remains Chicago and destination remains Helsinki;\n+- the stored deadline is the same calendar day as requested;\n+- the assigned itinerary is unchanged;\n+- transport status is `NOT_RECEIVED`;\n+- last known location is `Location.UNKNOWN`;\n+- current voyage is `Voyage.NONE`;\n+- the cargo is not misdirected;\n+- ETA is `Delivery.ETA_UNKOWN`;\n+- next expected activity is `Delivery.NO_ACTIVITY`;\n+- the cargo is not unloaded at destination;\n+- routing status remains `MISROUTED` for the established sequential scenario.\n+\n+The operation is generally callable for any cargo found by tracking ID; the later presentation layer, not this service, limits where the edit affordance appears. Require a concrete date through callers but add no new rule requiring it to be in the future, later than the old deadline, or after itinerary legs. Let existing `RouteSpecification` invariants apply.\n+\n+## Completion gates\n+\n+- The new sequential application test source compiles in its required position.\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- Review the diff and confirm no web, facade, REST, Liberty, or persistence-configuration file changed.\n+- Confirm no setter was added to `Cargo` or `RouteSpecification`.\n+- Confirm the test proves itinerary preservation and the full recalculated domain state, not only the changed date.\n+\n+## Out of scope\n+\n+- JSF, PrimeFaces, facade, REST, messaging, batch, Liberty, Derby, or unrelated persistence changes.\n+- Clearing, replacing, or rerouting the itinerary.\n+- Direct persistence-field mutation or deadline setters.\n+- Arquillian/Payara modernization, new test frameworks, or dependency changes.\n+- Cherry-picking or inspecting feature-bearing commits.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1549/issue-bodies/02-4.2-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, especially Domain acceptance behavior and Hard scope constraints.\n+- `### 3.2 — What is the exact domain mutation?`\n+- `### 3.4 — What type crosses the facade boundary?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.2 — Issue 2: Expose deadline changes through the booking facade`\n+- `## Cross-cutting concerns`\n+\n+The resolved facade contract is `void changeDeadline(String trackingId, Date arrivalDeadline)`. Convert only the identifier with `new TrackingId(trackingId)` and pass the same `Date` to the application service. Domain types such as `Cargo`, `TrackingId`, and `RouteSpecification` must not cross into the JSF-facing API, and no command DTO or formatted-string service parameter is warranted.\n+\n+Research on the prepared baseline established that test sources compile in the JDK 17 Open Liberty package build but the historical remote Arquillian suite remains skipped by default. A container-free facade test may use a hand-written fake; do not add a mocking library or modernize the runtime.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the base branch. This is serial task 2 of 5. Tasks are assigned, completed, and merged in order. Do not begin until this issue is assigned and task 1 has been merged with all gates passing. Preserve task 1's application API and tests unchanged.\n+\n+## Implement\n+\n+Modify:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/BookingServiceFacade.java`\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacade.java`\n+\n+Optionally add:\n+\n+- `src/test/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacadeTest.java`\n+\n+Add:\n+\n+```java\n+void changeDeadline(String trackingId, Date arrivalDeadline);\n+```\n+\n+Delegate exactly once:\n+\n+```java\n+bookingService.changeDeadline(\n+        new TrackingId(trackingId),\n+        arrivalDeadline);\n+```\n+\n+Keep the facade as a boundary adapter. It must not load or mutate a cargo, call the repository, parse date strings, enforce a new chronological rule, or introduce JSF/PrimeFaces types. Preserve the same `Date` value/object through delegation and use the application service implemented in task 1.\n+\n+If practical in this codebase, add a container-free JUnit test with a hand-written `BookingService` fake or spy proving:\n+\n+- the tracking string becomes an equivalent `TrackingId`;\n+- the same deadline reaches the application service;\n+- delegation occurs exactly once;\n+- no repository behavior is duplicated.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- Existing facade consumers compile without source changes unrelated to this API addition.\n+- The application-layer test from task 1 remains unchanged and compiling.\n+- A focused test, if added, runs without a container and without new dependencies.\n+- Diff inspection confirms the facade contains only conversion and delegation, with no domain mutation or date parsing.\n+\n+## Out of scope\n+\n+- JSF backing beans, dialog launchers, XHTML, dashboard integration, or PrimeFaces behavior.\n+- Loading `Cargo`, storing through `CargoRepository`, or reproducing application-service logic.\n+- New DTOs, formatted deadline parameters, mocking frameworks, or dependency changes.\n+- New future-date or itinerary-date validation rules.\n+- Changes to the task 1 implementation except corrections required for compilation.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1549/issue-bodies/03-4.3-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, including User-visible acceptance behavior and Hard scope constraints.\n+- `### 3.4 — What type crosses the facade boundary?`\n+- `### 3.5 — How is the DTO's formatted deadline converted for editing?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.7 — What is the dynamic-dialog contract?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.3 — Issue 3: Implement the deadline editor backing model`\n+- `## Cross-cutting concerns`\n+\n+The resolved presentation design uses a serializable CDI `@Named @ViewScoped` editor bean. It loads `CargoRoute` only through `BookingServiceFacade`, converts the DTO's `MM/dd/yyyy` date representation with a per-load `SimpleDateFormat`, and submits a `java.util.Date` through the facade. Do not introduce a shared mutable formatter, access domain objects directly, or silently turn malformed input into null.\n+\n+The resolved validation rule is only that a selected date is non-null. Do not invent a minimum date, future-only rule, ordering against the previous deadline, or itinerary chronology rule. A failed facade update must not be presented as success or close the dialog.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the base branch. This is serial task 3 of 5. Tasks are assigned, completed, and merged in order. Do not begin until assigned and tasks 1 and 2 are merged with all gates passing. Build only the backing model in this task; task 4 adds the launcher and XHTML.\n+\n+## Implement\n+\n+Create:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDate.java`\n+\n+Use this shape:\n+\n+```java\n+@Named\n+@ViewScoped\n+public class ChangeArrivalDeadlineDate implements Serializable {\n+    private static final long serialVersionUID = 1L;\n+\n+    private String trackingId;\n+    private CargoRoute cargo;\n+    private Date arrivalDeadlineDate;\n+\n+    @Inject\n+    private BookingServiceFacade bookingServiceFacade;\n+}\n+```\n+\n+Provide `getTrackingId()`, `setTrackingId(String)`, `getCargo()`, `getArrivalDeadlineDate()`, `setArrivalDeadlineDate(Date)`, `load()`, and `changeArrivalDeadline()`.\n+\n+`load()` must:\n+\n+1. Call `bookingServiceFacade.loadCargoForRouting(trackingId)`.\n+2. Retain the returned `CargoRoute`.\n+3. Parse the DTO's displayed `MM/dd/yyyy` deadline using a newly created `SimpleDateFormat(\"MM/dd/yyyy\")` for this load.\n+4. Store the parsed value in `arrivalDeadlineDate`.\n+5. Surface malformed DTO data as a clear application/view failure consistent with repository conventions; do not swallow it, print only a stack trace, or submit null.\n+\n+`changeArrivalDeadline()` must:\n+\n+1. Reject a null selected date through normal JSF validation or explicit bean validation.\n+2. Call `bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate)`.\n+3. Only after successful delegation, call `PrimeFaces.current().dialog().closeDynamic(\"DONE\")`.\n+4. Leave the dialog open and surface the failure if delegation fails.\n+\n+If practical, add a container-free JUnit test using a hand-written fake facade. Prove the correct tracking ID is loaded, the date-only DTO value becomes the editable date, selected tracking ID/date are delegated, malformed input is surfaced, and null submission is rejected.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- The bean is serializable and uses the established CDI/JSF annotations.\n+- Imports and fields show that the bean depends only on the facade and facade DTOs, never domain model or repository classes.\n+- Date parsing uses a per-load formatter and failures cannot become a null/success-shaped result.\n+- Submission closes with `\"DONE\"` only after successful facade delegation.\n+- Any focused test is container-free and introduces no mocking dependency.\n+\n+## Out of scope\n+\n+- Dialog launcher, XHTML, Administration table, navigation, or inline editing.\n+- Direct domain/repository access or changes to the facade/service contracts.\n+- Shared `SimpleDateFormat`, new DTO date fields, new date libraries, or dependency additions.\n+- New chronological business rules.\n+- Swallowing parse, validation, lookup, or facade failures.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1549/issue-bodies/04-4.4-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, especially User-visible acceptance behavior and Hard scope constraints.\n+- `### 3.5 — How is the DTO's formatted deadline converted for editing?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.7 — What is the dynamic-dialog contract?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog`\n+- `## Cross-cutting concerns`\n+\n+The resolved interaction mirrors the existing Change Destination dynamic-dialog lifecycle: a serializable session-scoped JSF managed launcher opens a dynamic PrimeFaces view, while task 3's view-scoped editor loads and submits. The dialog accepts one `trackingId` parameter; modal and draggable are `true`, resizable is `false`, content width is `410`, and content height is `280`. Success closes with `\"DONE\"` and cancel closes with an empty string.\n+\n+The prepared MyFaces baseline established a strict compatibility constraint: `<f:metadata>` must be a direct child of the root `<html>` element before `<h:head>` and `<h:body>`. Nesting it in the body causes view-build failures. Implement the production dialog directly from this contract rather than copying research or throwaway code.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the base branch. This is serial task 4 of 5. Tasks are assigned, completed, and merged in order. Do not begin until assigned and tasks 1 through 3 are merged with all gates passing. This task makes the dialog directly addressable but does not link it from the dashboard; task 5 performs that integration.\n+\n+## Implement\n+\n+Create:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDateDialog.java`\n+- `src/main/webapp/admin/dialogs/changeArrivalDeadlineDate.xhtml`\n+\n+The launcher must be serializable and use:\n+\n+```java\n+@ManagedBean(name = \"changeArrivalDeadlineDateDialog\")\n+@SessionScoped\n+```\n+\n+Implement `showDialog(String trackingId)`, `handleReturn(SelectEvent event)`, and `cancel()`. `showDialog(...)` must pass `trackingId` as a `Map<String, List<String>>` request parameter and open `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with the exact resolved dimensions and modal/draggable/resizable options. `cancel()` must close with the empty string and must never invoke the facade.\n+\n+The XHTML title must be `Change Deadline`. Put this metadata directly below the root `<html>` and before `<h:head>`:\n+\n+```xhtml\n+<f:metadata>\n+    <f:viewParam name=\"trackingId\"\n+                 value=\"#{changeArrivalDeadlineDate.trackingId}\"/>\n+    <f:viewAction action=\"#{changeArrivalDeadlineDate.load}\"/>\n+</f:metadata>\n+```\n+\n+The form must visibly label and display origin and destination from `changeArrivalDeadlineDate.cargo`, and provide an associated `Deadline:` label, validation feedback, and a required `p:datePicker` bound to `changeArrivalDeadlineDate.arrivalDeadlineDate`. Add Cancel calling `changeArrivalDeadlineDateDialog.cancel()` and Update calling `changeArrivalDeadlineDate.changeArrivalDeadline()`. Preserve the task 3 rule that Update closes only after a successful facade call.\n+\n+Run the application and directly request:\n+\n+`http://localhost:8080/cargo-tracker/admin/dialogs/changeArrivalDeadlineDate.xhtml?trackingId=DEF789`\n+\n+Verify HTTP 200, title, origin, destination, current selected deadline, successful update, and cancellation without mutation. Exercise the existing destination dialog as a regression check.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty liberty:run` succeeds on JDK 17.\n+- Direct dialog loading for `DEF789` returns HTTP 200 and renders the required context and selected date.\n+- Update persists the selected date and closes with `\"DONE\"`; Cancel closes with no mutation.\n+- No `TagException`, `Parent UIComponent`, `FacesException`, or server error appears.\n+- Existing destination editing still works.\n+- `<f:metadata>` is at view-root scope before head/body.\n+- Liberty is stopped cleanly before task completion.\n+\n+## Out of scope\n+\n+- Modifying `listNotRouted.xhtml` or exposing the dialog from the dashboard.\n+- Navigation to a full page, inline cell editing, or changing the established PrimeFaces interaction pattern.\n+- Changes to task 1-3 service, facade, or editor contracts except compilation fixes.\n+- New date policies, JSF framework migration, Jakarta namespace migration, or dependency changes.\n+- Copying or adapting spike source code.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1549/issue-bodies/05-4.5-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, including all User-visible acceptance behavior, Domain acceptance behavior, and Hard scope constraints.\n+- `### 3.1 — Which cargos expose the edit operation?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.7 — What is the dynamic-dialog contract?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard`\n+- `## Phase 5 — Documentation and implementation handoff`\n+- `## Cross-cutting concerns`\n+\n+The resolved UI scope is Option A: expose deadline editing only in `src/main/webapp/admin/tables/listNotRouted.xhtml`. The application and facade operations remain generally callable and must not encode table membership. Mirror the adjacent Destination column's established command-link, dynamic-dialog return, refresh, icon, and styling pattern without altering destination editing or routing.\n+\n+The mandatory runtime evidence uses stable sample cargo `DEF789`. The prepared baseline established that the JDK 17 Open Liberty package/start flow, direct HTTP checks, and complete browser flow are the executable acceptance gates; the historical remote Payara Arquillian runtime is not to be modernized. Data is in-memory and persists only for the lifetime of the running sample.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the base branch. This is serial task 5 of 5. Tasks are assigned, completed, and merged in order. Do not begin until assigned and tasks 1 through 4 are merged with all gates passing. Preserve every prior task's behavior and complete the final end-to-end integration and regression gate.\n+\n+## Implement\n+\n+Modify:\n+\n+- `src/main/webapp/admin/tables/listNotRouted.xhtml`\n+\n+In the existing Deadline column, replace the plain text with a `p:commandLink` that:\n+\n+- calls `changeArrivalDeadlineDateDialog.showDialog(cargoNotRouted.trackingId)`;\n+- continues to display `cargoNotRouted.arrivalDeadlineDate`;\n+- uses the existing Font Awesome edit-icon style;\n+- has a stable ID such as `arrivalDeadlineToUpdate`;\n+- registers a `dialogReturn` listener invoking `changeArrivalDeadlineDateDialog.handleReturn`;\n+- updates `tableNotRouted`;\n+- provides exactly this tooltip: `Click to change cargo arrival deadline date.`\n+\n+Follow the adjacent Destination column's structure and styling. Do not alter tracking-ID routing or destination editing.\n+\n+Run the complete acceptance flow on JDK 17:\n+\n+1. Start with `./mvnw clean package -Popenliberty liberty:run`.\n+2. Verify the home page returns HTTP 200.\n+3. Open Administration, locate `DEF789`, and record its original deadline.\n+4. Verify the edit icon and exact tooltip.\n+5. Open Change Deadline and verify origin/destination identify `DEF789` and the current date is selected.\n+6. Select a visibly different date and press Update.\n+7. Verify the dialog closes, `tableNotRouted` refreshes, and the selected date appears.\n+8. Reload and verify the changed date remains.\n+9. Reopen and verify the editor initializes to the changed date.\n+10. Cancel and verify no further change.\n+11. Verify the Destination dialog still opens and routing `DEF789` does not produce an error page.\n+\n+If `README.md` enumerates Administration capabilities, add only one concise sentence describing deadline editing for unrouted cargo. In the PR evidence, include the exact run command, `DEF789`, before/after deadline values, and the fact that in-memory data resets on rebuild/restart.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty` succeeds and all test sources compile.\n+- The complete browser flow above passes with recorded before/after dates.\n+- The final run contains no `<f:metadata> Parent UIComponent`, `TagException`, `VerifyError`, `FacesException`, `CWWKZ0002E`, `CWWKZ0003E`, recurring batch authorization failure, or new feature-attributable FFDC.\n+- Existing destination editing, cargo routing, tracking, REST, messaging, batch, startup, Liberty, Derby, and MyFaces compatibility continue to work.\n+- No Java EE/Jakarta migration or unrelated redesign appears in the diff.\n+- Liberty is stopped cleanly.\n+\n+## Out of scope\n+\n+- Adding the affordance to routed, misrouted, claimed, details, or other cargo views.\n+- Changing application/facade semantics or encoding UI table membership below the presentation layer.\n+- Redesigning destination editing, routing, tracking, messaging, batch, REST, persistence, or runtime configuration.\n+- Arquillian/Payara modernization, dependency additions, new UI frameworks, or namespace migration.\n+- Documentation expansion beyond the conditional concise README sentence and required PR evidence.\n*** End Patch\n"
````

</details>

```
Added 5 file(s): C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549\issue-bodies\01-4.1-body.md, C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549\issue-bodies\02-4.2-body.md, C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549\issue-bodies\03-4.3-body.md, C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549\issue-bodies\04-4.4-body.md, C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549\issue-bodies\05-4.5-body.md
```


---

<sub>1m 55s</sub>

### `powershell`

**Validate drafts and initialize ledger**

<details>
<summary>Arguments</summary>

```json
{
  "command": "$ErrorActionPreference='Stop'; $log='C:\\Users\\edburns\\workareas\\dd-3069621-cargotracker-win32-x64-shepherd-control\\1-arrival-deadline-control-remove-before-merge\\prompts\\shepherd-task-20-20260927-1549'; $validator='C:\\Users\\edburns\\.copilot\\plugins\\shepherd-task\\scripts\\validate-stage20-drafts.ps1'; $validated=& $validator -BodyDirectory (Join-Path $log 'issue-bodies') -ExpectedCount 5 -LessonPropagation off; $validated | ForEach-Object { $_.FullName }; $ledgerPath=Join-Path $log 'creation-ledger.json'; $resultPath=Join-Path $log 'stage-20-result.json'; function Write-Atomic([string]$Path,[string]$Content){$tmp=\"$Path.tmp\"; [IO.File]::WriteAllText($tmp,$Content+[Environment]::NewLine,[Text.UTF8Encoding]::new($false)); Move-Item -Force -LiteralPath $tmp -Destination $Path}; Write-Atomic $ledgerPath '[]'; $result=[ordered]@{schemaVersion=1;status='in_progress';ledgerFile='creation-ledger.json';operationError=$null}; Write-Atomic $resultPath (ConvertTo-Json -InputObject $result -Depth 5); 'DRAFT_VALIDATION=PASSED'; Get-Content -Raw -LiteralPath $resultPath",
  "description": "Validate drafts and initialize ledger"
}
```

</details>

<details>
<summary>13 lines</summary>

```
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549\issue-bodies\01-4.1-body.md
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549\issue-bodies\02-4.2-body.md
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549\issue-bodies\03-4.3-body.md
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549\issue-bodies\04-4.4-body.md
C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549\issue-bodies\05-4.5-body.md
DRAFT_VALIDATION=PASSED
{
  "schemaVersion": 1,
  "status": "in_progress",
  "ledgerFile": "creation-ledger.json",
  "operationError": null
}
<shellId: 4 completed with exit code 0>
```

</details>


---

<sub>2m 4s</sub>

### Copilot

The five persisted bodies passed the required pre-mutation validator, and the creation ledger/result documents are initialized. I’m now performing the one-shot create → exact-body verify → child-link sequence in plan order, with failure reconciliation built in.

---

<sub>2m 20s</sub>

### `apply_patch`

<details>
<summary>Arguments</summary>

```json
"*** Begin Patch\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1549/run-stage20.ps1\n+$ErrorActionPreference = 'Stop'\n+Set-StrictMode -Version Latest\n+\n+$repo = 'edburns/dd-3069621-cargotracker-win32-x64'\n+$parentIssue = 1\n+$logDirectory = 'C:\\Users\\edburns\\workareas\\dd-3069621-cargotracker-win32-x64-shepherd-control\\1-arrival-deadline-control-remove-before-merge\\prompts\\shepherd-task-20-20260927-1549'\n+$ledgerPath = Join-Path $logDirectory 'creation-ledger.json'\n+$resultPath = Join-Path $logDirectory 'stage-20-result.json'\n+$preCreationPath = Join-Path $logDirectory 'pre-creation-children.json'\n+$finalChildrenPath = Join-Path $logDirectory 'final-children.json'\n+$bodyVerifier = 'C:\\Users\\edburns\\.copilot\\plugins\\shepherd-task\\scripts\\verify-github-issue-body.ps1'\n+$childLinkVerifier = 'C:\\Users\\edburns\\.copilot\\plugins\\shepherd-task\\scripts\\verify-stage20-child-links.ps1'\n+\n+$specifications = @(\n+    [pscustomobject]@{\n+        subsection = '4.1 — Issue 1: Add the application-layer deadline change operation'\n+        title = '4.1: Add the application-layer deadline change operation'\n+        bodyFile = 'issue-bodies/01-4.1-body.md'\n+    },\n+    [pscustomobject]@{\n+        subsection = '4.2 — Issue 2: Expose deadline changes through the booking facade'\n+        title = '4.2: Expose deadline changes through the booking facade'\n+        bodyFile = 'issue-bodies/02-4.2-body.md'\n+    },\n+    [pscustomobject]@{\n+        subsection = '4.3 — Issue 3: Implement the deadline editor backing model'\n+        title = '4.3: Implement the deadline editor backing model'\n+        bodyFile = 'issue-bodies/03-4.3-body.md'\n+    },\n+    [pscustomobject]@{\n+        subsection = '4.4 — Issue 4: Implement the PrimeFaces deadline dialog'\n+        title = '4.4: Implement the PrimeFaces deadline dialog'\n+        bodyFile = 'issue-bodies/04-4.4-body.md'\n+    },\n+    [pscustomobject]@{\n+        subsection = '4.5 — Issue 5: Integrate deadline editing into the Administration dashboard'\n+        title = '4.5: Integrate deadline editing into the Administration dashboard'\n+        bodyFile = 'issue-bodies/05-4.5-body.md'\n+    }\n+)\n+\n+function Write-AtomicText {\n+    param(\n+        [Parameter(Mandatory)][string]$Path,\n+        [Parameter(Mandatory)][string]$Content\n+    )\n+\n+    $temporaryPath = \"$Path.tmp\"\n+    [IO.File]::WriteAllText(\n+        $temporaryPath,\n+        $Content + [Environment]::NewLine,\n+        [Text.UTF8Encoding]::new($false)\n+    )\n+    Move-Item -Force -LiteralPath $temporaryPath -Destination $Path\n+}\n+\n+function Read-CreationLedger {\n+    $parsed = [IO.File]::ReadAllText($ledgerPath) |\n+        ConvertFrom-Json -NoEnumerate\n+    if ($parsed -isnot [System.Array]) {\n+        throw 'Creation ledger JSON root must be an array.'\n+    }\n+\n+    $ledger = [object[]]$parsed\n+    if (@($ledger | Where-Object { $_ -is [System.Array] }).Count -ne 0) {\n+        throw 'Creation ledger must not contain nested array entries.'\n+    }\n+    return $ledger\n+}\n+\n+function Write-CreationLedger {\n+    param([Parameter(Mandatory)][AllowEmptyCollection()][object[]]$Ledger)\n+\n+    $json = ConvertTo-Json -InputObject ([object[]]$Ledger) -Depth 10\n+    Write-AtomicText -Path $ledgerPath -Content $json\n+}\n+\n+function Update-LedgerFlag {\n+    param(\n+        [Parameter(Mandatory)][int]$Number,\n+        [Parameter(Mandatory)][ValidateSet('body_verified', 'linked')][string]$Field,\n+        [Parameter(Mandatory)][bool]$Value\n+    )\n+\n+    $ledger = @(Read-CreationLedger)\n+    $entry = $ledger | Where-Object { $_.number -eq $Number }\n+    if (@($entry).Count -ne 1) {\n+        throw \"Expected exactly one ledger entry for issue #$Number.\"\n+    }\n+    $entry.$Field = $Value\n+    Write-CreationLedger -Ledger $ledger\n+}\n+\n+function Get-NormalizedChildren {\n+    $childrenOutput = & gh api \"repos/$repo/issues/$parentIssue/sub_issues\" --paginate --slurp 2>&1\n+    $childrenExitCode = $LASTEXITCODE\n+    if ($childrenExitCode -ne 0) {\n+        throw \"Unable to query parent children: $($childrenOutput | Out-String)\"\n+    }\n+\n+    $normalizationOutput = ($childrenOutput | Out-String) |\n+        jq 'if length == 0 then [] elif all(.[]; type == \"array\") then add else . end'\n+    $normalizationExitCode = $LASTEXITCODE\n+    if ($normalizationExitCode -ne 0) {\n+        throw \"Unable to normalize parent children: $($normalizationOutput | Out-String)\"\n+    }\n+\n+    $normalizedJson = ($normalizationOutput | Out-String).Trim()\n+    $parsed = $normalizedJson | ConvertFrom-Json -NoEnumerate\n+    if ($parsed -isnot [System.Array]) {\n+        throw 'Normalized parent-child response root must be an array.'\n+    }\n+    return [pscustomobject]@{\n+        json = $normalizedJson\n+        children = [object[]]$parsed\n+    }\n+}\n+\n+function Write-StageResult {\n+    param(\n+        [Parameter(Mandatory)][ValidateSet('in_progress', 'complete', 'failed')][string]$Status,\n+        [AllowNull()][string]$OperationError\n+    )\n+\n+    $result = [ordered]@{\n+        schemaVersion = 1\n+        status = $Status\n+        ledgerFile = 'creation-ledger.json'\n+        operationError = $OperationError\n+    }\n+    Write-AtomicText -Path $resultPath -Content (\n+        ConvertTo-Json -InputObject $result -Depth 5\n+    )\n+}\n+\n+function Reconcile-Failure {\n+    param([Parameter(Mandatory)][string]$Failure)\n+\n+    try {\n+        $server = Get-NormalizedChildren\n+        $serverIds = @($server.children | ForEach-Object { [long]$_.id })\n+        $ledger = @(Read-CreationLedger)\n+        foreach ($entry in $ledger) {\n+            $entry.linked = $serverIds -contains [long]$entry.id\n+        }\n+        Write-CreationLedger -Ledger $ledger\n+    }\n+    catch {\n+        $Failure = \"$Failure Reconciliation error: $($_.Exception.Message)\"\n+    }\n+\n+    Write-StageResult -Status failed -OperationError $Failure\n+    Write-Output \"STAGE20_FAILED: $Failure\"\n+    $ledger = @(Read-CreationLedger)\n+    if ($ledger.Count -eq 0) {\n+        Write-Output 'No issues were created; no cleanup is required.'\n+        return\n+    }\n+    $ledger |\n+        Select-Object number, title, url, bodyFile, body_verified, linked |\n+        Format-Table -AutoSize |\n+        Out-String |\n+        Write-Output\n+    foreach ($entry in $ledger) {\n+        Write-Output \"gh issue delete $($entry.number) --repo `\"$repo`\" --yes\"\n+    }\n+    Write-Output 'The operation did not complete and no automatic rollback was performed. Delete every issue in the ledger before invoking this skill again.'\n+}\n+\n+$initialLedger = @(Read-CreationLedger)\n+if ($initialLedger.Count -ne 0) {\n+    throw 'Creation ledger is not empty; refusing to rerun this one-shot operation.'\n+}\n+\n+$failedOperation = $null\n+try {\n+    foreach ($specification in $specifications) {\n+        $absoluteBodyPath = Join-Path $logDirectory (\n+            $specification.bodyFile -replace '/', '\\'\n+        )\n+\n+        $createOutput = & gh api \"repos/$repo/issues\" `\n+            -X POST `\n+            -f \"title=$($specification.title)\" `\n+            -F \"body=@$absoluteBodyPath\" 2>&1\n+        $createExitCode = $LASTEXITCODE\n+        if ($createExitCode -ne 0) {\n+            throw \"Create failed for $($specification.subsection): $($createOutput | Out-String)\"\n+        }\n+        $createdIssue = ($createOutput | Out-String) | ConvertFrom-Json\n+\n+        $ledger = @(Read-CreationLedger)\n+        $ledger += [pscustomobject][ordered]@{\n+            implementationSubsection = $specification.subsection\n+            bodyFile = $specification.bodyFile\n+            id = [long]$createdIssue.id\n+            number = [int]$createdIssue.number\n+            title = [string]$createdIssue.title\n+            url = [string]$createdIssue.html_url\n+            body_verified = $false\n+            linked = $false\n+        }\n+        Write-CreationLedger -Ledger $ledger\n+\n+        try {\n+            $observedIssue = & $bodyVerifier `\n+                -Repository $repo `\n+                -IssueNumber ([int]$createdIssue.number) `\n+                -ExpectedBodyPath $absoluteBodyPath `\n+                -MaxAttempts 6 `\n+                -DelaySeconds 5 `\n+                -DiagnosticPath (\n+                    Join-Path $logDirectory (\n+                        \"issue-$($createdIssue.number)-body-verification-failure.json\"\n+                    )\n+                )\n+        }\n+        catch {\n+            throw \"Issue body verification failed for issue #$($createdIssue.number): $($_.Exception.Message)\"\n+        }\n+        Update-LedgerFlag -Number ([int]$createdIssue.number) -Field body_verified -Value $true\n+\n+        $linked = $false\n+        $linkError = ''\n+        for ($attempt = 1; $attempt -le 3 -and -not $linked; $attempt++) {\n+            $payload = @{sub_issue_id = [long]$createdIssue.id} |\n+                ConvertTo-Json -Compress\n+            $linkOutput = $payload |\n+                & gh api \"repos/$repo/issues/$parentIssue/sub_issues\" -X POST --input - 2>&1\n+            $linkExitCode = $LASTEXITCODE\n+            if ($linkExitCode -eq 0) {\n+                $linked = $true\n+            }\n+            else {\n+                $linkError = ($linkOutput | Out-String).Trim()\n+                if ($attempt -lt 3) {\n+                    Start-Sleep -Seconds 2\n+                }\n+            }\n+        }\n+        if (-not $linked) {\n+            throw \"Link failed for issue #$($createdIssue.number) after 3 attempts: $linkError\"\n+        }\n+        Update-LedgerFlag -Number ([int]$createdIssue.number) -Field linked -Value $true\n+        Write-Output \"CREATED_AND_LINKED #$($createdIssue.number) $($createdIssue.title)\"\n+    }\n+\n+    $final = Get-NormalizedChildren\n+    Write-AtomicText -Path $finalChildrenPath -Content $final.json\n+\n+    try {\n+        & $childLinkVerifier `\n+            -PreCreationChildrenPath $preCreationPath `\n+            -FinalChildrenPath $finalChildrenPath `\n+            -CreationLedgerPath $ledgerPath\n+    }\n+    catch {\n+        throw \"Child-link postcondition verification failed: $($_.Exception.Message)\"\n+    }\n+\n+    foreach ($entry in @(Read-CreationLedger)) {\n+        $absoluteBodyPath = Join-Path $logDirectory (\n+            $entry.bodyFile -replace '/', '\\'\n+        )\n+        try {\n+            $observedIssue = & $bodyVerifier `\n+                -Repository $repo `\n+                -IssueNumber ([int]$entry.number) `\n+                -ExpectedBodyPath $absoluteBodyPath `\n+                -MaxAttempts 6 `\n+                -DelaySeconds 5 `\n+                -DiagnosticPath (\n+                    Join-Path $logDirectory (\n+                        \"issue-$($entry.number)-final-body-verification-failure.json\"\n+                    )\n+                )\n+        }\n+        catch {\n+            throw \"Final body verification failed for issue #$($entry.number): $($_.Exception.Message)\"\n+        }\n+        if ($observedIssue.state -ne 'open') {\n+            throw \"Issue #$($entry.number) is not open.\"\n+        }\n+        if (@($observedIssue.assignees).Count -ne 0) {\n+            throw \"Issue #$($entry.number) is assigned but must remain unassigned.\"\n+        }\n+    }\n+\n+    Write-StageResult -Status complete -OperationError $null\n+    Write-Output 'STAGE20_COMPLETE'\n+    @(Read-CreationLedger) |\n+        Select-Object implementationSubsection, number, title, url |\n+        ConvertTo-Json -Depth 5\n+}\n+catch {\n+    $failedOperation = $_.Exception.Message\n+    Reconcile-Failure -Failure $failedOperation\n+    exit 1\n+}\n*** End Patch\n"
```

</details>

```
Added 1 file(s): C:\Users\edburns\workareas\dd-3069621-cargotracker-win32-x64-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260927-1549\run-stage20.ps1
```


---

<sub>2m 39s</sub>

### `powershell`

**Create verify and link child issues**

<details>
<summary>Arguments</summary>

```json
{
  "command": "& 'C:\\Users\\edburns\\workareas\\dd-3069621-cargotracker-win32-x64-shepherd-control\\1-arrival-deadline-control-remove-before-merge\\prompts\\shepherd-task-20-20260927-1549\\run-stage20.ps1'",
  "description": "Create verify and link child issues",
  "initial_wait": 180,
  "mode": "sync"
}
```

</details>

<details>
<summary>51 lines</summary>

```
CREATED_AND_LINKED #2 4.1: Add the application-layer deadline change operation
CREATED_AND_LINKED #3 4.2: Expose deadline changes through the booking facade
CREATED_AND_LINKED #4 4.3: Implement the deadline editor backing model
CREATED_AND_LINKED #5 4.4: Implement the PrimeFaces deadline dialog
CREATED_AND_LINKED #6 4.5: Integrate deadline editing into the Administration dashboard
{
  "baselineCount": 0,
  "ledgerCount": 5,
  "finalCount": 5,
  "newIssueIds": [
    5605755104,
    5605755334,
    5605755542,
    5605755756,
    5605755960
  ]
}
STAGE20_COMPLETE
[
  {
    "implementationSubsection": "4.1 — Issue 1: Add the application-layer deadline change operation",
    "number": 2,
    "title": "4.1: Add the application-layer deadline change operation",
    "url": "https://github.com/edburns/dd-3069621-cargotracker-win32-x64/issues/2"
  },
  {
    "implementationSubsection": "4.2 — Issue 2: Expose deadline changes through the booking facade",
    "number": 3,
    "title": "4.2: Expose deadline changes through the booking facade",
    "url": "https://github.com/edburns/dd-3069621-cargotracker-win32-x64/issues/3"
  },
  {
    "implementationSubsection": "4.3 — Issue 3: Implement the deadline editor backing model",
    "number": 4,
    "title": "4.3: Implement the deadline editor backing model",
    "url": "https://github.com/edburns/dd-3069621-cargotracker-win32-x64/issues/4"
  },
  {
    "implementationSubsection": "4.4 — Issue 4: Implement the PrimeFaces deadline dialog",
    "number": 5,
    "title": "4.4: Implement the PrimeFaces deadline dialog",
    "url": "https://github.com/edburns/dd-3069621-cargotracker-win32-x64/issues/5"
  },
  {
    "implementationSubsection": "4.5 — Issue 5: Integrate deadline editing into the Administration dashboard",
    "number": 6,
    "title": "4.5: Integrate deadline editing into the Administration dashboard",
    "url": "https://github.com/edburns/dd-3069621-cargotracker-win32-x64/issues/6"
  }
]
<shellId: 5 completed with exit code 0>
```

</details>


---

<sub>2m 47s</sub>

### `rg`

**shepherd-task-25-given-list|given-list**

"shepherd-task-25-given-list|given-list" (1-arrival-deadline-control-remove-before-merge)

```
No matches found.
```


---

<sub>2m 51s</sub>

### `glob`

****\*stage25***

"**\*stage25*" in ~\.copilot\plugins\shepherd-task

```
No files matched the pattern.
```


---

<sub>2m 55s</sub>

### Copilot

Created and verified five ordered, unassigned child issues under #1. All bodies exactly match persisted drafts, links/order passed the authoritative verifier, and `stage-20-result.json` is `complete`. Issues were created **without an issue type** because the repository is user-owned.

| Subsection | Issue | Title |
|---|---:|---|
| 4.1 | [#2](https://github.com/edburns/dd-3069621-cargotracker-win32-x64/issues/2) | Add the application-layer deadline change operation |
| 4.2 | [#3](https://github.com/edburns/dd-3069621-cargotracker-win32-x64/issues/3) | Expose deadline changes through the booking facade |
| 4.3 | [#4](https://github.com/edburns/dd-3069621-cargotracker-win32-x64/issues/4) | Implement the deadline editor backing model |
| 4.4 | [#5](https://github.com/edburns/dd-3069621-cargotracker-win32-x64/issues/5) | Implement the PrimeFaces deadline dialog |
| 4.5 | [#6](https://github.com/edburns/dd-3069621-cargotracker-win32-x64/issues/6) | Integrate deadline editing into the Administration dashboard |

**Ordered child list:** `2,3,4,5,6`

**Suggested next invocation:** Invoke `shepherd-task-25-given-list` with `CAMPAIGN_ID=ce692e79-febf-4b62-be97-8761f1b47240`, `REPO=edburns/dd-3069621-cargotracker-win32-x64`, `BASE_BRANCH=experiment/shepherd-control`, `PLAN_DIRECTORY=1-arrival-deadline-control-remove-before-merge`, and ordered issues `2,3,4,5,6`.

---

<sub>Generated by [GitHub Copilot CLI](https://github.com/features/copilot/cli)</sub>
