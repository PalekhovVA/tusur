package ru.tusur;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {

    public static void saveFileToHtml(String text, String fileName) throws Exception {
        saveFile(text, fileName, "html");
    }

    public static void saveFileToTxt(String text, String fileName) throws Exception {
        saveFile(text, fileName, "txt");
    }

    public static void saveFileToJpeg(BufferedImage bufferedImage, String filePath, String fileName) throws IOException {
        ImageIO.write(bufferedImage, "JPEG", new File(filePath + fileName + ".jpeg"));
    }

    private static void saveFile(String text, String fileName, String fileFormat) throws Exception {
        try {
            FileWriter writer = new FileWriter(fileName + "." + fileFormat, false);
            writer.write(text);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
