package ru.tusur.checkingImage;

import ru.tusur.SaveFile;
import ru.tusur.dto.ImageDto;
import ru.tusur.dto.PixelDto;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;

import static ru.tusur.checkingImage.PixelColor.getRedColor;
import static ru.tusur.properties.GetProperties.failedScreenshotFilePath;
/**
 * Попиксельное сравнение файла
 */
class ComparePixelFile {

    /**
     * Сравнение пикселей файла
     */
    boolean comparePixelDtoList(ImageDto expectedImageDto, ImageDto actualImageDto) throws Exception {
        int listSize;
        int badPixelCount = 0;
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
                badPixelCount++;
                actualImageDto.getPixelDtoList().add(PixelDto.builder()
                        .x(actualImageDto.getPixelDtoList().get(i).getX())
                        .y(actualImageDto.getPixelDtoList().get(i).getY())
                        .color(getRedColor())
                        .build());
            }
        }

        if (!result) {
            throw new AssertionError("Актуальный файл не совпадает с эталонным.\n" +
                    " Количество совпавших пикселей: " + createNotValidImage(actualImageDto, badPixelCount) + "%");
        }

        return result;
    }

    /**
     * Создание файла с не совпадающими пикселями
     */
    private float createNotValidImage(ImageDto imageDto, int badPixelSize) throws Exception {
        writeImageFile(imageDto.getPixelDtoList(), imageDto.getMaxX(), imageDto.getMaxY());
        return interestCalculation(badPixelSize, imageDto.getPixelDtoList().size());
    }

    /**
     * Сохранение файла в формате JPEG
     */
    private void writeImageFile(List<PixelDto> pixelDtoList, int maxX, int maxY) throws Exception {
            BufferedImage image = new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_RGB);
            for (PixelDto pixelDto : pixelDtoList) {
                image.setRGB(pixelDto.getX(), pixelDto.getY(), pixelDto.getColor().getRGB());
            }

        SaveFile.saveFileToJpeg(image, failedScreenshotFilePath, "TestFail_Screenshot" + new Date().getTime());
    }

    /**
     *
     */
    private float interestCalculation(float badPixelCount, float allPixelCount) {
        return (badPixelCount / allPixelCount) * 100;
    }
}
