package ru.tusur;

import org.openqa.selenium.By;

/**
 * Получение элемента в строковом представлении из эталонного HTML
 */
public class GetElement {
    /**
     * Получение элемента в строковом представлении
     */
    public String getElementHtmlCode(String page, String cssSelector) {
        int index = getIndexElement(page, cssSelector);
        int firstTag = getIndexFirstTag(page, index);
        int secondTag = getIndexLastTag(page, index);
        if (secondTag == page.length())
            return page.substring(firstTag, secondTag);
        else return page.substring(firstTag, secondTag + 1);
    }

    /**
     * Получение CSS селектора
     */
    public String getCssSelector(By by) throws AssertionError {
        String prefix = getPrefix(by.toString());
        String selector = by.toString();
        switch (prefix) {
            case "By.id":
                return getSelector(selector);

            case "By.cssSelector":
                return ""; //todo добавить распознование селекторов
        }

        throw new AssertionError("Не верный тип селектора");
    }

    private int getIndexElement(String text, String cssSelector) {
        return text.indexOf(cssSelector);
    }

    private int getIndexFirstTag(String text, int index) {
        return text.lastIndexOf("<", index);
    }

    private int getIndexLastTag(String text, int index) {
        return text.indexOf(">", index);
    }

    private String getSelector(String text) {
        int index = text.indexOf(":");
        return text.substring(index + 1).trim();
    }

    private String getPrefix(String text) {
        int index = text.indexOf(":");
        return text.substring(0, index);
    }
}
