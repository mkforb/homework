package com.ifmo.jjd.secondexam;

import com.ifmo.jjd.secondexam.command.Command;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void execute(int num) {
        if (num < 0 || num > commands.size() - 1) {
            System.out.println("Неверная команда");
            return;
        }
        Command command = commands.get(num);
        command.execute();
    }

    public void print() {
        for (int i = 0; i < commands.size(); i++) {
            System.out.println((i+1) + ". " + commands.get(i).getText());
        }
        System.out.println("Введите номер:");
    }
}
