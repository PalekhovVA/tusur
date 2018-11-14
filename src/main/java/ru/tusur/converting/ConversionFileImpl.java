package ru.tusur.converting;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class ConversionFileImpl {

    public static byte[] fileToByteArray(File file) throws Exception {
        return FileUtils.readFileToByteArray(file);
    }

    public static void byteArrayToFile(File file, byte[] bytes) throws Exception {
        FileUtils.writeByteArrayToFile(file, bytes);
    }
}
