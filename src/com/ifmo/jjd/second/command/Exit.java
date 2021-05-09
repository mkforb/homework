package com.ifmo.jjd.second.command;

public class Exit extends AbstractCommand {
    public Exit() {
        super("Exit");
    }

    @Override
    public void execute() {
        System.out.println("Exit game");
    }
}
