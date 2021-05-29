package com.ifmo.jjd.multithreading.homework26.task2;

import java.util.*;

/**
 * Created by User on 23.05.2021.
 */
public class GetThread implements Runnable {
    private final WordCalc wordCalc;
    private final ArrayList<PutThread> putThreads;

    public GetThread(WordCalc wordCalc, ArrayList<PutThread> putThreads) {
        this.wordCalc = wordCalc;
        this.putThreads = putThreads;
    }

    @Override
    public void run() {
        HashMap<String, Integer> map = wordCalc.getMap(putThreads);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        TreeSet<Map.Entry<String, Integer>> treeSet = new TreeSet<>((o1, o2) -> {
            int i = Integer.compare(o2.getValue(), o1.getValue());
            if (i != 0) return i;
            return o1.getKey().compareTo(o2.getKey());
        });
        treeSet.addAll(entries);
        int i = 0;
        for (Map.Entry<String, Integer> entry : treeSet) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
            i++;
            if (i == 10) return;
        }
    }


}
