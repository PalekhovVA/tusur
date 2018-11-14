package ru.tusur;

/**
 * Получение элемента в строковом представлении из эталонного HTML
 */
public class GetElement {
    /**
     * Получение элемента в строковом представлении
     *
     * @return
     */
    public String getElementHtmlCode(String page, String cssSelector) {
        int index = getIndexElement(page, cssSelector);
        int firstTag = getIndexFirstTag(page, index);
        int secondTag = getIndexLastTag(page, index);
        if (secondTag == page.length())
            return page.substring(firstTag, secondTag);
        else return page.substring(firstTag, secondTag + 1);
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
}
