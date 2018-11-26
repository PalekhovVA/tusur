package ru.tusur;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ru.tusur.converting.ConversionFile.byteArrayToFile;
import static ru.tusur.properties.GetProperties.actualScreenshotFilePath;

public class GetScreenshot {

    public List<File> getElementScreenshotList(WebDriver webDriver, List<By> findByElementList) {
        List<File> resultList = new ArrayList<>();
        findByElementList.forEach(by -> {
            try {
                resultList.add(getElementScreenshot(webDriver, by));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return resultList;
    }

    public File getElementScreenshot(WebDriver webDriver, By by) throws Exception {
        return getElementScreenshot(webDriver, by, "test");
    }

    public File getElementScreenshot(WebDriver webDriver, By by, String fileName) throws Exception {
        String screenshotFileName = fileName + "_" + new Date().getTime() + ".jpeg";
        byte[] screenshotByte = webDriver.findElement(by).getScreenshotAs(OutputType.BYTES);
        File file = new File(actualScreenshotFilePath + screenshotFileName);
        byteArrayToFile(file, screenshotByte);
        return file;
    }
}
