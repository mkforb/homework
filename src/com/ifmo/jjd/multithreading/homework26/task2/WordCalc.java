package com.ifmo.jjd.multithreading.homework26.task2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 23.05.2021.
 */
public class WordCalc {
    private final HashMap<String, Integer> map = new HashMap<>();

    public synchronized void putWords(String[] words) {
        for (String word : words) {
            int i = map.getOrDefault(word, 0) + 1;
            map.put(word, i);
        }
        notify();
    }

    public synchronized HashMap<String, Integer> getMap(ArrayList<PutThread> putThreads) {
        while(!isCalculated(putThreads)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    private boolean isCalculated(ArrayList<PutThread> putThreads) {
        for (PutThread putThread : putThreads) {
            if (!putThread.isCalculated()) {
                return false;
            }
        }
        return true;
    }
}
