package com.ifmo.jjd.homework18;

import java.io.*;

/**
 * Created by User on 30.04.2021.
 */
public class XorApp {
    public static void main(String[] args) {
        File file = new File("lesson18.txt");
        String text = "dlfkk dflk sdlfk ldfgf";
        System.out.println("Исходная строка: " + text);
        byte key = 35;

        // Шифрование
        try (FileOutputStream fileOutput = new FileOutputStream(file);
             XorOutputStream xorOutput = new XorOutputStream(fileOutput, key)) {
            xorOutput.write(text.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Дешифрование
        try (FileInputStream fileInput = new FileInputStream(file);
             XorInputStream xorInput = new XorInputStream(fileInput, key);
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {
            byte[] buf = new byte[512];
            int readCount;
            while ((readCount = xorInput.read(buf)) != -1) {
                byteArray.write(buf, 0, readCount);
            }
            String fromFile = byteArray.toString();
            System.out.println("Дешифрованная строка: " + fromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
