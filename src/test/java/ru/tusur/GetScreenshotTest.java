package ru.tusur;

import org.junit.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class GetScreenshotTest {
    private GetScreenshot getScreenshot = new GetScreenshot();

    @Test
    public void getElementScreenshotTest() throws Exception {
        open("https://yandex.ru/");
        getScreenshot.getElementScreenshot(getWebDriver(), By.cssSelector("#wd-_topnews"));
    }

    @Test
    public void getElementScreenshotListTest() {
        open("https://yandex.ru/");
        ArrayList list = new ArrayList();
        list.add(By.id("wd-_topnews"));
        list.add(By.cssSelector("#wd-wrapper-_services"));
        getScreenshot.getElementScreenshotList(getWebDriver(), list);
    }

}