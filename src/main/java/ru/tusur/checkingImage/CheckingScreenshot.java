package ru.tusur.checkingImage;

import ru.tusur.dto.ImageDto;

import java.io.File;

/**
 * Попиксельное сравнение двух файлов
 */
public class CheckingScreenshot {
    private ComparePixelFile comparePixelFile = new ComparePixelFile();
    private FileSplittingIntoPixels fileSplittingIntoPixels = new FileSplittingIntoPixels();

    public boolean checkingFile(File expectedFile, File actualFile) {
        try {
            ImageDto expectedFileImageDto = fileSplittingIntoPixels.splittingImageIntoPixels(expectedFile);
            ImageDto actualFileImageDto = fileSplittingIntoPixels.splittingImageIntoPixels(actualFile);
            return comparePixelFile.comparePixelDtoList(expectedFileImageDto, actualFileImageDto);
        } catch (Exception e) {
            e.printStackTrace();
            return false; //todo!
        }

    }

}
