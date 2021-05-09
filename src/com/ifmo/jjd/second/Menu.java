package com.ifmo.jjd.second;

import com.ifmo.jjd.second.command.Command;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<Integer, Command> commands = new HashMap<>();

    public void addCommand(int num, Command command) {
        commands.put(num, command);
    }

    public void execute(int num) {
        Command command = commands.get(num);
        if (command == null) {
            System.out.println("Неизвестная команда");
            return;
        }
        command.execute();
    }

    public void print() {
        for (Map.Entry<Integer, Command> entry : commands.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getText());
        }
    }
}
