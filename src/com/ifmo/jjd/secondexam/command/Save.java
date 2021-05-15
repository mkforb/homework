package com.ifmo.jjd.secondexam.command;

import com.ifmo.jjd.secondexam.Game;
import com.ifmo.jjd.secondexam.Settings;

public class Save extends AbstractCommand {
    public Save(Game game) {
        super(Settings.MENU_SAVE, game);
    }

    @Override
    public void execute() {
        game.save();
    }
}
