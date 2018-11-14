package ru.tusur.checkingImage;

import ru.tusur.dto.ImageDto;
import ru.tusur.dto.PixelDto;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static ru.tusur.checkingImage.PixelColor.getRedColor;

/**
 * Попиксельное сравнение файла
 */
class ComparePixelFile {
    private final String filePath = "failTestResult/screenshots/";

    /**
     * Сравнение пикселей файла
     */
    boolean comparePixelDtoList(ImageDto expectedImageDto, ImageDto actualImageDto) throws Exception {
        int listSize;
        boolean result = true;
        if (actualImageDto.getPixelDtoList().size() == expectedImageDto.getPixelDtoList().size()) {
            listSize = actualImageDto.getPixelDtoList().size();
        } else {
            throw new Exception("Не корректная длина листов");
        }

        for (int i = 0; i < listSize; i++) {
            if (!expectedImageDto.getPixelDtoList().get(i).getColor()
                    .equals(actualImageDto.getPixelDtoList().get(i).getColor())) {
                result = false;
                actualImageDto.getPixelDtoList().add(PixelDto.builder()
                        .x(actualImageDto.getPixelDtoList().get(i).getX())
                        .y(actualImageDto.getPixelDtoList().get(i).getY())
                        .color(getRedColor())
                        .build());
            }
        }

        if (!result) {
            createNotValidImage(actualImageDto);
        }

        return result;
    }

    /**
     * Создание файла с не совпадающими пикселями
     */
    private boolean createNotValidImage(ImageDto imageDto) {
        return writeImageFile(imageDto.getPixelDtoList(),
                imageDto.getMaxX(), imageDto.getMaxY());
    }

    /**
     * Сохранение файла в формате JPEG
     *
     * @param pixelDtoList
     * @param maxX
     * @param maxY
     * @return
     */
    private boolean writeImageFile(List<PixelDto> pixelDtoList, int maxX, int maxY) {
        try {
            BufferedImage image = new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_RGB);
            for (PixelDto pixelDto : pixelDtoList) {
                image.setRGB(pixelDto.getX(), pixelDto.getY(), pixelDto.getColor().getRGB());
            }
            ImageIO.write(image, "jpg", new File(filePath
                    + "testFailed" + new Date().getTime() + ".jpg"));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
