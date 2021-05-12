package com.ifmo.jjd.secondexam;

import com.ifmo.jjd.secondexam.command.Exit;
import com.ifmo.jjd.secondexam.command.Load;
import com.ifmo.jjd.secondexam.command.Start;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private final Scanner scanner;
    private final Map<String, Step> actions = new HashMap<>();
    private boolean exit = false;

    public Game() {
        scanner = new Scanner(System.in);
        actions.put("Лисенок", new Step("Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. Это утро не было исключением. Лисёнок пришёл на их обычное место встречи, но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга. \" Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\" - подумал Лисёнок. Как поступить Лисенку?", "Вернуться домой", "Отправиться на поиски"));
        actions.put("Вернуться домой", new Step("Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи раньше и увидел там рой злобных пчел. Он поспешил предупредить об этом Лисёнка, но они разминулись. Наконец-то друзья нашли друг друга! Игра завершилась успехом"));
        actions.put("Отправиться на поиски", new Step("Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему. Но вдруг кто нибудь видел Бельчонка... Лисёнок не знал, что ему делать. Помогите ему.", "Попытаться разузнать о Бельчонке у лесных жителей", "Искать Бельчонка в одиночку"));
        actions.put("Попытаться разузнать о Бельчонке у лесных жителей", new Step("Пока Лисёнок принимал решение, лесные жители разошлись кто куда. Остались только Сова и Волк. Но у Совы бывают проблемы с памятью, а Волк может сильно разозлиться из-за расспросов. Кого выбрать?", "Расспросить Сову", "Расспросить Волка"));
        actions.put("Искать Бельчонка в одиночку", new Step("Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. Теперь его самого нужно искать. Игра завершилась неудачей"));
        actions.put("Расспросить Сову", new Step("Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, бежавшего вглубь леса. Все лесные жители знают, что в глубине леса опасно, если Бельчонок там, ему срочно нужна помощь.", "Поверить Сове и отправиться вглубь леса", "Сове не стоит верить -> Искать Бельчонка в одиночку"));
        actions.put("Расспросить Волка", new Step("Волк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, что маленькому лисенку не стоит бродить по лесу одному. И как теперь поступить?", "Вернуться домой", "Искать Бельчонка в одиночку"));


    }

    public void mainMenu() {
        while (!exit) {
            Menu menu = new Menu();
            menu.addCommand(new Start(this));
            menu.addCommand(new Load());
            menu.addCommand(new Exit(this));
            menu.print();
            int num = scanner.nextInt();
            menu.execute(num-1);
        }
    }

    public void start() {
        String stepName = "Лисенок";
        while (true) {
            Step step = getStep(stepName);
            if (step == null) {
                System.out.println("Не найден шаг: " + stepName);
                break;
            }
            System.out.println(step.getDescription());
            List<String> options = step.getOptions();
            if (options.isEmpty()) break;
            printOptions(options);
            int num = scanner.nextInt();
            if (num < 1 || num > step.getOptions().size()) {
                System.out.println("Неверная команда");
            } else {
                stepName = step.getOptions().get(num - 1);
                if (stepName.equals(Settings.MENU_EXIT)) break;
            }
        }
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    private Step getStep(String name) {
        return actions.get(name);
    }

    private void printOptions(List<String> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i+1) + ". " + options.get(i));
        }
    }
}
