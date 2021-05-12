package com.ifmo.jjd.secondexam.command;

import com.ifmo.jjd.secondexam.Settings;

public class Save extends AbstractCommand {
    public Save() {
        super(Settings.MENU_SAVE);
    }

    @Override
    public void execute() {
        System.out.println("Save game");
    }
}
