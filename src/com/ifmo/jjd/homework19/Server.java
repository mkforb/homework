package com.ifmo.jjd.homework19;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.UUID;

/**
 * Created by User on 28.04.2021.
 */
public class Server {
    private final int port;
    private HashSet<String> clients;

    public Server(int port) {
        this.port = port;
        clients = new HashSet<>();
    }

    public void start() {
        clients.clear();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен");
            while (true) {
                Socket newClient = serverSocket.accept();
                Connection connection = new Connection(newClient);
                SimpleMessage message = connection.readMessage();
                clients.add(message.getSender());
                System.out.println(message);
                connection.sendMessage(SimpleMessage.getMessage("Сервер", getResponse(message)));
            }
        } catch (IOException e) {
            System.out.println("Ошибка сервера");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщения");
        }
    }

    private String getResponse(SimpleMessage message) {
        switch (message.getText()) {
            case Commands.HELP:
                return "Доступные команды:" +
                        "\n/help - список доступных команд" +
                        "\n/count - количество подключений сервера" +
                        "\n/ping - время за которое сообщение доходит до сервера и возвращается обратно" +
                        "\n/exit - пользователь хочет выйти из программы" +
                        "\n/image <имя_файла> - отправить картинку";
            case Commands.COUNT:
                return "Количество подключений - " + clients.size();
            case Commands.PING:
            case Commands.EXIT:
                return "";
            case Commands.IMAGE:
                ImgMessage imgMessage = (ImgMessage) message;
                try {
                    ByteArrayInputStream stream = new ByteArrayInputStream(imgMessage.getBytes());
                    BufferedImage bufferedImage = ImageIO.read(stream);
                    String fileName = UUID.randomUUID() + "." + imgMessage.getExtension();
                    if (ImageIO.write(bufferedImage, imgMessage.getExtension(), new File(fileName))) {
                        return "Файл " + fileName + " сохранен";
                    } else {
                        return "Ошибка сохранения файла";
                    }
                } catch (IOException e) {
                    return "Ошибка сохранения файла";
                }
            default:
                return "Неизвестная команда";
        }
    }
}
