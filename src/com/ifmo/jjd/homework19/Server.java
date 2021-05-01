package com.ifmo.jjd.homework19;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by User on 28.04.2021.
 */
public class Server {
    private final int port;
    private int conCount;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        conCount = 0;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен");
            while (true) {
                Socket newClient = serverSocket.accept();
                conCount++;
                Connection connection = new Connection(newClient);
                SimpleMessage message = connection.readMessage();
                System.out.println(message);
                connection.sendMessage(SimpleMessage.getMessage("Сервер", getResponse(message.getText())));
            }
        } catch (IOException e) {
            System.out.println("Ошибка сервера");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщения");
        }
    }

    private String getResponse(String req) {
        switch (req) {
            case "/help":
                return "Доступные команды:" +
                        "\n/help - список доступных команд" +
                        "\n/count - количество подключений сервера" +
                        "\n/ping - время за которое сообщение доходит до сервера и возвращается обратно" +
                        "\n/exit - пользователь хочет выйти из программы";
            case "/count":
                return "Количество соединений - " + conCount;
            case "/ping":
                return "";
            default:
                return "Неизвестная команда";
        }
    }
}
