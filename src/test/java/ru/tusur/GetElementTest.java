package ru.tusur;

import org.junit.Test;
import ru.tusur.findElement.BySelector;

import static org.junit.Assert.assertEquals;

public class GetElementTest {
    private final String page = "<id=\"string1\" attribute1>qwerty<id=\"string2\" attribute1 attribute2>";
    private GetElement getElement = new GetElement();

    @Test
    public void getElementHtml() throws Exception {

        assertEquals("<id=\"string2\" attribute1 attribute2>",
                getElement.getElementHtmlCode(page, "id=\"string2\""));
    }

    @Test
    public void getElementTest() {
        assertEquals("<id=\"string2\" attribute1 attribute2>",
                getElement.getElementHtmlCode(page, BySelector.byId("string2")));
    }
}