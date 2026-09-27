package org.eclipse.cargotracker.interfaces.booking.web;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.primefaces.PrimeFaces;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ChangeArrivalDeadlineDateDialogTest {

    private PrimeFaces previousPrimeFaces;
    private FakePrimeFaces primeFaces;

    @Before
    public void setUp() {
        previousPrimeFaces = PrimeFaces.current();
        primeFaces = new FakePrimeFaces();
        PrimeFaces.setCurrent(primeFaces);
    }

    @After
    public void tearDown() {
        PrimeFaces.setCurrent(previousPrimeFaces);
    }

    @Test
    public void opensDeadlineDialogWithTrackingIdAndRequiredOptions() {
        new ChangeArrivalDeadlineDateDialog().showDialog("DEF789");

        assertEquals("/admin/dialogs/changeArrivalDeadlineDate.xhtml", primeFaces.path);
        assertEquals(1, primeFaces.params.size());
        assertEquals("DEF789", primeFaces.params.get("trackingId").get(0));
        assertEquals(Boolean.TRUE, primeFaces.options.get("modal"));
        assertEquals(Boolean.TRUE, primeFaces.options.get("draggable"));
        assertEquals(Boolean.FALSE, primeFaces.options.get("resizable"));
        assertEquals(Integer.valueOf(410), primeFaces.options.get("contentWidth"));
        assertEquals(Integer.valueOf(280), primeFaces.options.get("contentHeight"));
    }

    @Test
    public void cancelClosesWithoutOpeningOrChangingCargo() {
        new ChangeArrivalDeadlineDateDialog().cancel();

        assertEquals("", primeFaces.closeResult);
        assertNull(primeFaces.path);
    }

    @Test
    public void updateProcessesFormContainingDeadlineInput() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document document;
        try (InputStream view = getClass().getResourceAsStream(
                "/admin/dialogs/changeArrivalDeadlineDate.xhtml")) {
            assertNotNull(view);
            document = factory.newDocumentBuilder().parse(view);
        }
        NodeList commandButtons = document.getElementsByTagNameNS("http://primefaces.org/ui", "commandButton");
        Element updateButton = null;
        for (int i = 0; i < commandButtons.getLength(); i++) {
            Element button = (Element) commandButtons.item(i);
            if ("Update".equals(button.getAttribute("value"))) {
                updateButton = button;
                break;
            }
        }

        assertNotNull(updateButton);
        assertEquals("#{changeArrivalDeadlineDate.changeArrivalDeadline()}", updateButton.getAttribute("action"));
        assertEquals("@form", updateButton.getAttribute("process"));
        assertEquals("@form", updateButton.getAttribute("update"));
    }

    private static class FakePrimeFaces extends PrimeFaces {
        private String path;
        private Map<String, Object> options;
        private Map<String, List<String>> params;
        private Object closeResult;

        @Override
        public Dialog dialog() {
            return new Dialog() {
                @Override
                public void openDynamic(String path, Map<String, Object> options, Map<String, List<String>> params) {
                    FakePrimeFaces.this.path = path;
                    FakePrimeFaces.this.options = options;
                    FakePrimeFaces.this.params = params;
                }

                @Override
                public void closeDynamic(Object result) {
                    closeResult = result;
                }
            };
        }
    }
}
