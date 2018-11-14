package ru.tusur;

import org.junit.Before;
import org.junit.Test;
import ru.tusur.findElement.BySelector;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static junit.framework.TestCase.assertTrue;
import static ru.tusur.checkElement.CheckElement.checkElement;

public class DemoTests {
    private final String expectedElement = "<div id=\"wd-_topnews\" class=\"b-widget-data b-wrapper b-wrapper-\">";
    private String expectedScreenshot = "expectedElement\\screenshot\\expectedScreenshot.jpeg";

    @Before
    public void beforeTest() {
        open("https://yandex.ru/");
    }

    @Test
    public void fullTest() {
        checkElement(getWebDriver(), BySelector.byId("wd-_topnews"), expectedScreenshot, expectedElement,
                org.openqa.selenium.By.cssSelector("#wd-_topnews"));

    }

    @Test
    public void positiveTest() {
        assertTrue(checkElement(getWebDriver(), BySelector.byId("wd-_topnews"), expectedScreenshot, expectedElement,
                org.openqa.selenium.By.cssSelector("#wd-_topnews")));
    }
}
