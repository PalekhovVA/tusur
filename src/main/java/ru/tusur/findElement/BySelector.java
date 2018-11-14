package ru.tusur.findElement;

/**
 * Поиск элементов по селектору
 */
public class BySelector {

    public static String byId(String id) {
        return "id=\"" + id + "\"";
    }

    public static String byAttribyte(String selector, String attribute) {
        return attribute + "\"" + selector + "\"";
    }


}
