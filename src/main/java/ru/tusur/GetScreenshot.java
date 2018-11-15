package ru.tusur;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Date;

import static ru.tusur.converting.ConversionFile.byteArrayToFile;

public class GetScreenshot {
    private static final String screenshotFilePath = "actualElement/screenshots/";

    public File getElementScreenshot(WebDriver webDriver, By by) {
        try {

            String screenshotFileName = "test1" + "_" + new Date().getTime() + ".jpeg";

            byte[] screenshotByte = webDriver.findElement(by).getScreenshotAs(OutputType.BYTES);
            File file = new File(screenshotFilePath + screenshotFileName);
            byteArrayToFile(file, screenshotByte);

            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
