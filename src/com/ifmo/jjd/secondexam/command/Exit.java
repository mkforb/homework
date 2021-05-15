package com.ifmo.jjd.secondexam.command;

import com.ifmo.jjd.secondexam.Game;
import com.ifmo.jjd.secondexam.Settings;

public class Exit extends AbstractCommand {
    public Exit(Game game) {
        super(Settings.MENU_EXIT, game);
    }

    @Override
    public void execute() {
        game.setExit(true);
    }
}
