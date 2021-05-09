package com.ifmo.jjd.second.command;

public class Start extends AbstractCommand {
    public Start() {
        super("Start game");
    }

    @Override
    public void execute() {
        System.out.println("Start game");
    }
}
