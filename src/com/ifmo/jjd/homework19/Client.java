package com.ifmo.jjd.homework19;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
            System.out.println("Введите сообщение");
            text = scanner.nextLine();
            if (text.equals("/exit")) break;
            if (text.toLowerCase().startsWith("/send-image")) {
                String[] params = text.toLowerCase().split(" ");
                sendImage(params[1]);
            } else {
                sendAndPrintMessage(SimpleMessage.getMessage(userName, text));
            }
        }
    }

    private void sendAndPrintMessage(SimpleMessage message) {
        try (Connection connection = new Connection(new Socket(ip, port))) {
            connection.sendMessage(message);
            SimpleMessage fromServer = connection.readMessage();
            String resp;
            if ("/ping".equals(message.getText())) {
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

    private void sendImage(String fileName) {
        try (Connection connection = new Connection(new Socket(ip, port))) {
            BufferedImage bufferedImage = ImageIO.read(new File(fileName));
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", stream);
            connection.sendImage(stream.toByteArray());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
