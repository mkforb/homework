package com.ifmo.jjd.second.command;

public class Save extends AbstractCommand {
    public Save() {
        super("Save game");
    }

    @Override
    public void execute() {
        System.out.println("Save game");
    }
}
