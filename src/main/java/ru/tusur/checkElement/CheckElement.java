package ru.tusur.checkElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.tusur.GetElement;
import ru.tusur.GetScreenshot;
import ru.tusur.checkingImage.CheckingScreenshot;

import java.io.File;

public class CheckElement {
    private static final GetElement getElement = new GetElement();
    private static final GetScreenshot getScreenshot = new GetScreenshot();
    private static final CheckingScreenshot checkingScreenshot = new CheckingScreenshot();

    /**
     * Проверка элемента попиксельно и по html
     */
    public static boolean checkElement(WebDriver webDriver, String expectedScreenshotFilePath,
                                       String expectedHtmlElement, By by) {
        try {
            String actualElement = getElement.getElementHtmlCode(webDriver.getPageSource(), getElement.getCssSelector(by));
            File actualScreenshotFile = getScreenshot.getElementScreenshot(webDriver, by);
            File expectedScreenshotFile = new File(expectedScreenshotFilePath);

            boolean checkingElement = actualElement.equals(expectedHtmlElement)
                    && checkingScreenshot.checkingFile(expectedScreenshotFile, actualScreenshotFile);

            if (checkingElement) {
                return true;
            } else
                throw new AssertionError("Элементы не совпадают");
        } catch (Exception e) {
            throw new AssertionError("Получено исключение: \n" + e);
        }
    }
}
