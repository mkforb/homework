package com.ifmo.jjd.secondexam.command;

import com.ifmo.jjd.secondexam.Game;
import com.ifmo.jjd.secondexam.Settings;

public class Load extends AbstractCommand {
    public Load(Game game) {
        super(Settings.MENU_LOAD, game);
    }

    @Override
    public void execute() {
        game.load();
    }
}
