package org.eclipse.cargotracker.interfaces.booking.facade.internal;

import org.eclipse.cargotracker.application.BookingService;
import org.eclipse.cargotracker.domain.model.cargo.Itinerary;
import org.eclipse.cargotracker.domain.model.cargo.TrackingId;
import org.eclipse.cargotracker.domain.model.location.UnLocode;

import org.junit.Test;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class DefaultBookingServiceFacadeTest {

    @Test
    public void changeDeadlineConvertsTrackingIdAndDelegatesOriginalDateOnce() {
        BookingServiceSpy bookingService = new BookingServiceSpy();
        DefaultBookingServiceFacade facade = new DefaultBookingServiceFacade(
                bookingService);

        Date deadline = new Date(123456789L);
        facade.changeDeadline("ABC123", deadline);

        assertEquals(new TrackingId("ABC123"), bookingService.trackingId);
        assertSame(deadline, bookingService.deadline);
        assertEquals(1, bookingService.deadlineChanges);
    }

    private static class BookingServiceSpy implements BookingService {

        private TrackingId trackingId;
        private Date deadline;
        private int deadlineChanges;

        @Override
        public TrackingId bookNewCargo(UnLocode origin, UnLocode destination,
                                       Date arrivalDeadline) {
            return null;
        }

        @Override
        public List<Itinerary> requestPossibleRoutesForCargo(
                TrackingId trackingId) {
            return Collections.emptyList();
        }

        @Override
        public void assignCargoToRoute(Itinerary itinerary,
                                       TrackingId trackingId) {
        }

        @Override
        public void changeDestination(TrackingId trackingId,
                                     UnLocode unLocode) {
        }

        @Override
        public void changeDeadline(TrackingId trackingId, Date deadline) {
            this.trackingId = trackingId;
            this.deadline = deadline;
            deadlineChanges++;
        }
    }
}
