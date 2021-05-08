package com.ifmo.jjd.homework19;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;

/**
 * Created by User on 28.04.2021.
 */
public class Client {
    private final String ip;
    private final int port;
    private final Scanner scanner;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Введите имя");
        String userName = scanner.nextLine();
        String text;
        while (true) {
            System.out.println("Введите команду");
            text = scanner.nextLine();
            if (text.equals(Commands.HELP) || text.equals(Commands.COUNT) || text.equals(Commands.PING) || text.equals(Commands.EXIT)) {
                sendAndPrintMessage(SimpleMessage.getMessage(userName, text));
                if (text.equals(Commands.EXIT)) break;
            } else if (text.toLowerCase().startsWith(Commands.IMAGE)) {
                String commandName = text.toLowerCase().split(" ")[0];
                String fileName = text.toLowerCase().split(" ")[1];
                ImgMessage imgMessage = new ImgMessage(userName, commandName, readFromFile(fileName));
                imgMessage.setExtension(getFileExtension(fileName));
                sendAndPrintMessage(imgMessage);
            } else {
                System.out.println("Неизвестная команда");
            }
        }
    }

    private void sendAndPrintMessage(SimpleMessage message) {
        try (Connection connection = new Connection(new Socket(ip, port))) {
            connection.sendMessage(message);
            SimpleMessage fromServer = connection.readMessage();
            String resp;
            if (message.getText().equals(Commands.PING)) {
                resp = ChronoUnit.MICROS.between(message.getDateTime(), LocalDateTime.now()) + " мкрс";
            } else {
                resp = fromServer.getText();
            }
            System.out.println(resp);
        } catch (IOException e) {
            System.out.println("Ошибка отправки-получения сообщения");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщения");
        } catch (Exception e) {
            System.out.println("Ошибка соединения");
        }
    }

    private byte[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, getFileExtension(file.getName()), stream);
            return stream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getFileExtension(String fileName) {
        return Optional.of(fileName)
                .filter(s -> s.contains("."))
                .map(s -> s.substring(fileName.lastIndexOf(".") + 1))
                .orElse("png");
    }
}
