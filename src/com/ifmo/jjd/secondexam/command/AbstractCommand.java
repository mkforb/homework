package com.ifmo.jjd.secondexam.command;

import com.ifmo.jjd.secondexam.Game;

public abstract class AbstractCommand implements Command {
    private final String text;
    protected final Game game;

    public AbstractCommand(String text, Game game) {
        this.text = text;
        this.game = game;
    }

    @Override
    public String getText() {
        return text;
    }
}
