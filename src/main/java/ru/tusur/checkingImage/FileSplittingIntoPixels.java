package ru.tusur.checkingImage;

import ru.tusur.dto.ImageDto;
import ru.tusur.dto.PixelDto;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Разбиение файла на пиксеои
 */
class FileSplittingIntoPixels {

    ImageDto splittingImageIntoPixels(File file) {
        try {
            List<PixelDto> pixelDtoList = new ArrayList<>();
            BufferedImage img = ImageIO.read(file);
            int minX = img.getMinX();
            int minY = img.getMinY();
            int maxX = img.getWidth();
            int maxY = img.getHeight();

            for (int x = minX; x < maxX; x++) {
                for (int y = minY; y < maxY; y++) {
                    pixelDtoList.add(PixelDto.builder()
                            .x(x)
                            .y(y)
                            .color(PixelColor.getPixelColor(img, x, y))
                            .build());
                }
            }

            return ImageDto.builder()
                    .maxX(maxX)
                    .maxY(maxY)
                    .pixelDtoList(pixelDtoList)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
