package org.eclipse.cargotracker.interfaces.booking.web;

import org.eclipse.cargotracker.interfaces.booking.facade.BookingServiceFacade;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.CargoRoute;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.Location;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.RouteCandidate;
import org.primefaces.PrimeFaces;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ChangeArrivalDeadlineDateTest {

    private ChangeArrivalDeadlineDate editor;
    private FakeFacade facade;
    private PrimeFaces previousPrimeFaces;
    private FakePrimeFaces primeFaces;

    @Before
    public void setUp() throws Exception {
        previousPrimeFaces = PrimeFaces.current();
        primeFaces = new FakePrimeFaces();
        PrimeFaces.setCurrent(primeFaces);
        editor = new ChangeArrivalDeadlineDate();
        facade = new FakeFacade();
        Field field = ChangeArrivalDeadlineDate.class.getDeclaredField("bookingServiceFacade");
        field.setAccessible(true);
        field.set(editor, facade);
        editor.setTrackingId("DEF789");
    }

    @After
    public void tearDown() {
        PrimeFaces.setCurrent(previousPrimeFaces);
    }

    @Test
    public void loadsDisplayedDateForTrackingId() throws Exception {
        Date deadline = new SimpleDateFormat("MM/dd/yyyy").parse("03/15/2014");
        facade.cargo = cargo(deadline);

        editor.load();

        assertEquals("DEF789", facade.loadedTrackingId);
        assertSame(facade.cargo, editor.getCargo());
        assertEquals("03/15/2014", new SimpleDateFormat("MM/dd/yyyy").format(editor.getArrivalDeadlineDate()));
    }

    @Test
    public void malformedDeadlineFailsLoad() throws Exception {
        facade.cargo = new CargoRoute("DEF789", "USCHI", "FIHEL", new Date(), false, false, "", "") {
            @Override
            public String getArrivalDeadlineDate() {
                return "not-a-date";
            }
        };

        try {
            editor.load();
            fail("Expected a parsing failure");
        } catch (IllegalStateException expected) {
            assertTrue(expected.getMessage().contains("deadline"));
        }
        assertSame(facade.cargo, editor.getCargo());
        assertNull(editor.getArrivalDeadlineDate());
    }

    @Test
    public void nonCanonicalDeadlineFailsLoad() throws Exception {
        facade.cargo = new CargoRoute("DEF789", "USCHI", "FIHEL", new Date(), false, false, "", "") {
            @Override
            public String getArrivalDeadlineDate() {
                return "3/15/2014";
            }
        };

        try {
            editor.load();
            fail("Expected a malformed date failure");
        } catch (IllegalStateException expected) {
            assertTrue(expected.getMessage().contains("deadline"));
        }
        assertNull(editor.getArrivalDeadlineDate());
    }

    @Test
    public void nullDateNeverReachesFacade() {
        try {
            editor.changeArrivalDeadline();
            fail("Expected a validation failure");
        } catch (IllegalArgumentException expected) {
            assertTrue(expected.getMessage().contains("date"));
        }
        assertNull(facade.changedTrackingId);
        assertNull(primeFaces.closeResult);
    }

    @Test
    public void successfulUpdateDelegatesBeforeClosing() throws Exception {
        Date selected = new SimpleDateFormat("MM/dd/yyyy").parse("04/22/2014");
        editor.setArrivalDeadlineDate(selected);

        editor.changeArrivalDeadline();

        assertEquals("DEF789", facade.changedTrackingId);
        assertSame(selected, facade.changedDate);
        assertEquals("DONE", primeFaces.closeResult);
    }

    @Test
    public void facadeFailurePropagatesAfterDelegatingSelectedDate() throws Exception {
        Date selected = new SimpleDateFormat("MM/dd/yyyy").parse("04/22/2014");
        editor.setArrivalDeadlineDate(selected);
        facade.failure = new IllegalStateException("update failed");

        try {
            editor.changeArrivalDeadline();
            fail("Expected facade failure");
        } catch (IllegalStateException expected) {
            assertSame(facade.failure, expected);
        }
        assertEquals("DEF789", facade.changedTrackingId);
        assertSame(selected, facade.changedDate);
        assertNull(primeFaces.closeResult);
    }

    private static CargoRoute cargo(Date date) {
        return new CargoRoute("DEF789", "USCHI", "FIHEL", date, false, false, "", "");
    }

    private static class FakePrimeFaces extends PrimeFaces {
        private Object closeResult;

        @Override
        public Dialog dialog() {
            return new Dialog() {
                @Override
                public void closeDynamic(Object result) {
                    closeResult = result;
                }
            };
        }
    }

    private static class FakeFacade implements BookingServiceFacade {
        private CargoRoute cargo;
        private String loadedTrackingId;
        private String changedTrackingId;
        private Date changedDate;
        private RuntimeException failure;

        @Override
        public CargoRoute loadCargoForRouting(String trackingId) {
            loadedTrackingId = trackingId;
            return cargo;
        }

        @Override
        public void changeDeadline(String trackingId, Date arrivalDeadline) {
            changedTrackingId = trackingId;
            changedDate = arrivalDeadline;
            if (failure != null) {
                throw failure;
            }
        }

        @Override
        public String bookNewCargo(String origin, String destination, Date arrivalDeadline) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void assignCargoToRoute(String trackingId, RouteCandidate route) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void changeDestination(String trackingId, String destinationUnLocode) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<RouteCandidate> requestPossibleRoutesForCargo(String trackingId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<Location> listShippingLocations() {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<CargoRoute> listAllCargos() {
            throw new UnsupportedOperationException();
        }
    }
}
