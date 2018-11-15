package ru.tusur;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class GetScreenshotTest {
    private GetScreenshot getScreenshot = new GetScreenshot();

    @Test
    public void getElementScreenshotTest() throws Exception {
        open("https://yandex.ru/");
        getScreenshot.getElementScreenshot(getWebDriver(), By.cssSelector("#wd-_topnews"));
    }

}