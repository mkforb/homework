package com.ifmo.jjd.second;

import com.ifmo.jjd.second.command.Command;
import com.ifmo.jjd.second.command.Exit;
import com.ifmo.jjd.second.command.Load;
import com.ifmo.jjd.second.command.Start;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Menu menu;
    private Scanner scanner;
    private Map<String, String> actions = new HashMap<>();

    public Game() {
        scanner = new Scanner(System.in);
        actions.put("Лисенок", "");
    }

    public void start() {
        while (true) {
            menu = new Menu();
            menu.addCommand(1, new Start());
            menu.addCommand(2, new Load());
            menu.addCommand(3, new Exit());
            menu.print();
            int num = scanner.nextInt();
            menu.execute(num);
        }
    }
}
