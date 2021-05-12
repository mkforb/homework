package com.ifmo.jjd.secondexam.command;

import com.ifmo.jjd.secondexam.Settings;

public class Load extends AbstractCommand {
    public Load() {
        super(Settings.MENU_LOAD);
    }

    @Override
    public void execute() {
        System.out.println("Load game");
    }
}
