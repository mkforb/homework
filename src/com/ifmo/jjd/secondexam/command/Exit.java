package com.ifmo.jjd.secondexam.command;

import com.ifmo.jjd.secondexam.Game;
import com.ifmo.jjd.secondexam.Settings;

public class Exit extends AbstractCommand {
    private final Game game;

    public Exit(Game game) {
        super(Settings.MENU_EXIT);
        this.game = game;
    }

    @Override
    public void execute() {
        game.setExit(true);
    }
}
