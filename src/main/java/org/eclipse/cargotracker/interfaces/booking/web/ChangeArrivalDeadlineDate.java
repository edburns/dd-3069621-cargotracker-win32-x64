package org.eclipse.cargotracker.interfaces.booking.web;

import org.eclipse.cargotracker.interfaces.booking.facade.BookingServiceFacade;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.CargoRoute;
import org.primefaces.PrimeFaces;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@Named
@ViewScoped
public class ChangeArrivalDeadlineDate implements Serializable {

    private static final long serialVersionUID = 1L;

    private String trackingId;
    private CargoRoute cargo;
    private Date arrivalDeadlineDate;

    @Inject
    private BookingServiceFacade bookingServiceFacade;

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public CargoRoute getCargo() {
        return cargo;
    }

    public Date getArrivalDeadlineDate() {
        return arrivalDeadlineDate;
    }

    public void setArrivalDeadlineDate(Date arrivalDeadlineDate) {
        this.arrivalDeadlineDate = arrivalDeadlineDate;
    }

    public void load() {
        arrivalDeadlineDate = null;
        cargo = bookingServiceFacade.loadCargoForRouting(trackingId);
        String displayedDate = cargo.getArrivalDeadlineDate();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        format.setLenient(false);
        ParsePosition position = new ParsePosition(0);
        Date parsedDate = displayedDate == null ? null : format.parse(displayedDate, position);
        if (parsedDate == null || position.getIndex() != displayedDate.length()
                || !displayedDate.equals(format.format(parsedDate))) {
            throw new IllegalStateException("Invalid arrival deadline date for cargo " + trackingId + ": " + displayedDate);
        }
        arrivalDeadlineDate = parsedDate;
    }

    public void changeArrivalDeadline() {
        if (arrivalDeadlineDate == null) {
            throw new IllegalArgumentException("Arrival deadline date is required");
        }
        bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate);
        PrimeFaces.current().dialog().closeDynamic("DONE");
    }
}
