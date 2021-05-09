package com.ifmo.jjd.second.command;

public class Load extends AbstractCommand {
    public Load() {
        super("Load game");
    }

    @Override
    public void execute() {
        System.out.println("Load game");
    }
}
