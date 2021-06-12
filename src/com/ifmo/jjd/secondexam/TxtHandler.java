package com.ifmo.jjd.secondexam;

import java.io.*;

/**
 * Created by User on 12.06.2021.
 */
public class TxtHandler {
    private final File file;

    public TxtHandler(File file) {
        this.file = file;
    }

    public byte[] readFromFile() {
        byte[] result = null;
        try (FileInputStream fileInput = new FileInputStream(file);
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {
            byte[] buf = new byte[512];
            int readCount;
            while ((readCount = fileInput.read(buf)) != -1) {
                byteArray.write(buf, 0, readCount);
            }
            result = byteArray.toByteArray();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла");
        }
        return result;
    }
}
