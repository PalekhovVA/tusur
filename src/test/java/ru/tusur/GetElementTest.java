package ru.tusur;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class GetElementTest {
    private final String page = "<id=\"string1\" attribute1>qwerty<id=\"string2\" attribute1 attribute2>";
    private GetElement getElement = new GetElement();

    @Test
    public void getElementHtml() {

        assertEquals("<id=\"string2\" attribute1 attribute2>",
                getElement.getElementHtmlCode(page, "id=\"string2\""));
    }

    @Test
    public void getCssSelectorTest() {
        assertEquals("testId", getElement.getCssSelector(By.id("testId")));
    }
}