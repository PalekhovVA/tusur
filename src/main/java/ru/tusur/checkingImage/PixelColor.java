package ru.tusur.checkingImage;

import java.awt.*;
import java.awt.image.BufferedImage;

class PixelColor {

    static Color getRedColor() {
        return new Color(200, 0, 0);
    }

    static Color getPixelColor(BufferedImage bi, int x, int y) {
        Object colorData = bi.getRaster().getDataElements(x, y, null);//данные о пикселе
        int argb = bi.getColorModel().getRGB(colorData);//преобразование данных в цветовое значение
        return new Color(argb, true);
    }

}
