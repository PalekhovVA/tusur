package ru.tusur.converting;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.tusur.GetElement;
import ru.tusur.SaveFile;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ConversionFileImplTest {
    private final String expectedElement = "<input class=\"string required\" name=\"parts_params[search][q]\" placeholder=\"Поиск\" required=\"required\" aria-required=\"true\" type=\"text\" id=\"search_q\" />";
    private GetElement parseFile = new GetElement();

    @Test
    public void q() throws Exception {
        /* todo: 1. получение скриншотов элементов по их селекторам (Для эталонна сделать отдельный класс.
                   Туда передавать лист элементов. На выходе папка с скриншотами)
                2. Получение скриншотов элементов в тесте
                3. Сравнение этих скриншотов попиксельно.
                4. В результат - процент совпадения. Если 100 то все ок. Если нет выдавать картинку с красными пикселями.

            todo Сравнение строковых элементов. ОР -> элемент в html формате. АР -> элемент полученый со страницы в html
            все упоковать в отдельный проект. Сделать демо проект.
        */

        open("https://tusur.ru/");
        WebDriver driver = getWebDriver();
        driver.manage().timeouts();
//        driver.manage().ime();
        SaveFile.saveFileToHtml(driver.getPageSource(), "test02");
//        System.out.println(driver.getPageSource());
//        driver.findElement(BySelector.cssSelector("#search_q"));
//     File file = driver.findElement(BySelector.cssSelector("#search_q")).getScreenshotAs(OutputType.FILE);
//        getElementScreenshot(getWebDriver(), BySelector.cssSelector(".img-responsive"));


//        prepareString(expectedElement, parseFile.getElementHtmlCode(driver.getPageSource(), ru.tusur.findElement.BySelector.byId("search_q")));

//        assertEquals(expectedElement,
//            parseFile.getElementHtmlCode(driver.getPageSource(), ru.tusur.findElement.BySelector.byId("search_q")));
    }

    public String prepareString(String expectedString, String actualString) {
        String[] expectedStringArray = expectedString.split("");
        String[] actualStringArray = actualString.split("");
        String result = "";
        if (expectedString.length() < actualString.length()) {
            for (int i = 0; i < actualString.length(); i++) {
                if (!(expectedStringArray[i].equals(actualStringArray[i]))) {
                    result = result.concat(actualStringArray[i]);
                }
            }
            return result;
        }
        return actualString;
    }
}

/*        open("https://tusur.ru/");
        WebDriver driver = getWebDriver();
            driver.manage().timeouts();
            driver.manage().ime();
            SaveFile.saveFileToHtml(driver.getPageSource(), "test02");
            System.out.println(driver.getPageSource());
            driver.findElement(BySelector.cssSelector("#search_q"));
            */