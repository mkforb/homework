package com.ifmo.jjd.secondexam.command;

import com.ifmo.jjd.secondexam.Game;
import com.ifmo.jjd.secondexam.Settings;

public class Start extends AbstractCommand {
    public Start(Game game) {
        super(Settings.MENU_START, game);
    }

    @Override
    public void execute() {
        game.start();
    }
}
