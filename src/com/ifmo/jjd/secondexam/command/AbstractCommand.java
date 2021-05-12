package com.ifmo.jjd.secondexam.command;

public abstract class AbstractCommand implements Command {
    private final String text;

    public AbstractCommand(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
