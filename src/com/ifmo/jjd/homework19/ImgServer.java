package com.ifmo.jjd.homework19;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by User on 05.05.2021.
 */
public class ImgServer {
    private final int port;

    public ImgServer(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен");
            while (true) {
                Socket newClient = serverSocket.accept();
                Connection connection = new Connection(newClient);
                byte[] bytes = connection.readImage();
                connection.close();
                ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
                BufferedImage bufferedImage = ImageIO.read(stream);
                boolean res = ImageIO.write(bufferedImage, "png", new File("serverImg.jpg"));
                if (res) {
                    System.out.println("Файл сохранен");
                } else {
                    System.out.println("Ошибка");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка сервера");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщения");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
