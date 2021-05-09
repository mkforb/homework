package com.ifmo.jjd.second.command;

public abstract class AbstractCommand implements Command {
    private String text;

    public AbstractCommand(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
