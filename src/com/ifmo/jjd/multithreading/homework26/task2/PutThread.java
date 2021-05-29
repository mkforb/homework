package com.ifmo.jjd.multithreading.homework26.task2;

import java.util.List;

/**
 * Created by User on 23.05.2021.
 */
public class PutThread implements Runnable {
    private final WordCalc wordCalc;
    private final List<String> strings;
    private boolean calculated = false;

    public PutThread(WordCalc wordCalc, List<String> strings) {
        this.wordCalc = wordCalc;
        this.strings = strings;
    }

    public boolean isCalculated() {
        return calculated;
    }

    @Override
    public void run() {
        System.out.println(strings);
        for (String string : strings) {
            wordCalc.putWords(string.toLowerCase().split(" "));
        }
        calculated = true;
    }
}
