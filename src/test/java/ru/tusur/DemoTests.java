package ru.tusur;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ru.tusur.checkElement.CheckElement.checkElement;

public class DemoTests {
    private final String expectedElement = "<div id=\"wd-_topnews\" class=\"b-widget-data b-wrapper b-wrapper-\">";
    private final String expectedScreenshot = "expectedElement\\screenshot\\expectedScreenshot.jpeg";
    private WebDriver webDriver;

    @Before
    public void beforeTest() {
        open("https://yandex.ru/");
        webDriver = getWebDriver();
    }

    @Test
    public void fullTest() {
        checkElement(webDriver, expectedScreenshot, expectedElement,
                org.openqa.selenium.By.id("wd-_topnews"));
    }
}
