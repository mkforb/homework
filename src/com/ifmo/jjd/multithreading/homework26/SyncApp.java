package com.ifmo.jjd.multithreading.homework26;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 21.05.2021.
 */
public class SyncApp {
    public static void main(String[] args) {
        // Транзакции
        Account acc1 = new Account(400);
        Account acc2 = new Account(900);
        Thread thread1 = new Thread(new Transaction1(acc1, acc2, 50));
        thread1.start();
        Thread thread2 = new Thread(new Transaction2(acc2, acc1, 120));
        thread2.start();

        // Посчитать слова
        List<String> list = new ArrayList<>();
        // Прочитать слова из файла
        try {
            list = Files.readAllLines(Path.of("homework26.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<PutThread> threads = new ArrayList<>();
        WordCalc wordCalc = new WordCalc();
        int cores = Runtime.getRuntime().availableProcessors();
        int cnt = list.size() / cores;
        if (list.size() % cores > 0) {
            cnt++;
        }
        for (int i = 0; i < cores; i++) {
            int start = i * cnt;
            if (start >= list.size()) {
                break;
            }
            int end = (i + 1) * cnt;
            if (end > list.size()) {
                end = list.size();
            }
            List<String> subList = list.subList(start, end);
            if (subList.size() > 0) {
                threads.add(new PutThread(wordCalc, subList));
            }
        }
        threads.forEach(putThread -> new Thread(putThread).start());
        new Thread(new GetThread(wordCalc, threads)).start();
    }
}
