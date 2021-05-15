package com.ifmo.jjd.secondexam;

import java.io.*;

public class BinHandler {
    private final File file;

    public BinHandler(File file) {
        this.file = file;
    }

    public <T> boolean writeToFile(T object) {
        boolean result = false;
        try (FileOutputStream fileOutput = new FileOutputStream(file);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
            objectOutput.writeObject(object);
            result = true;
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
        return result;
    }

    public <T> T readFromFile() {
        Object o = null;
        try (FileInputStream fileInput = new FileInputStream(file);
                ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            o = objectInput.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("IOException или ClassNotFoundException");
        }
        return (T) o;
    }
}