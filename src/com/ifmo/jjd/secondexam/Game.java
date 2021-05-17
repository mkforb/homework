package com.ifmo.jjd.secondexam;

import com.ifmo.jjd.secondexam.command.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private final Command commandStart = new Start(this);
    private final Command commandSave = new Save(this);
    private final Command commandLoad = new Load(this);
    private final Command commandExit = new Exit(this);
    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, Step> actions = new HashMap<>();
    private boolean exit = false;
    private boolean gameStarted = false;
    private String stepNameToSave;

    public Game() {
        actions.put("Лисенок", new Step("Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. Это утро не было исключением. Лисёнок пришёл на их обычное место встречи, но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга. \" Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\" - подумал Лисёнок. Как поступить Лисенку?", "Вернуться домой", "Отправиться на поиски"));
        actions.put("Вернуться домой", new Step("Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи раньше и увидел там рой злобных пчел. Он поспешил предупредить об этом Лисёнка, но они разминулись. Наконец-то друзья нашли друг друга! Игра завершилась успехом"));
        actions.put("Отправиться на поиски", new Step("Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему. Но вдруг кто нибудь видел Бельчонка... Лисёнок не знал, что ему делать. Помогите ему.", "Попытаться разузнать о Бельчонке у лесных жителей", "Искать Бельчонка в одиночку"));
        actions.put("Попытаться разузнать о Бельчонке у лесных жителей", new Step("Пока Лисёнок принимал решение, лесные жители разошлись кто куда. Остались только Сова и Волк. Но у Совы бывают проблемы с памятью, а Волк может сильно разозлиться из-за расспросов. Кого выбрать?", "Расспросить Сову", "Расспросить Волка"));
        actions.put("Искать Бельчонка в одиночку", new Step("Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. Теперь его самого нужно искать. Игра завершилась неудачей"));
        actions.put("Расспросить Сову", new Step("Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, бежавшего вглубь леса. Все лесные жители знают, что в глубине леса опасно, если Бельчонок там, ему срочно нужна помощь.", "Поверить Сове и отправиться вглубь леса", "Сове не стоит верить -> Искать Бельчонка в одиночку"));
        actions.put("Расспросить Волка", new Step("Волк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, что маленькому лисенку не стоит бродить по лесу одному. И как теперь поступить?", "Волк прав -> Вернуться домой", "Искать Бельчонка в одиночку"));
        actions.put("Поверить Сове и отправиться вглубь леса", new Step("В глубине леса Лисёнок встретил Медвежонка. Ленивый Медвежонок был готов рассказать все, что знает, если Лисёнок принесёт ему мёда.", "Нет, потрачено слишком много времени, нужно идти дальше -> Искать Бельчонка в одиночку", "Нужно воспользоваться шансом и раздобыть мёд"));
        actions.put("Нужно воспользоваться шансом и раздобыть мёд", new Step("Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. Лисёнок всегда боялся пчёл, но и не найти друга он тоже боялся.", "Подождать, вдруг пчёлы улетят", "Нужно попытаться выкрасть мёд немедленно"));
        actions.put("Подождать, вдруг пчёлы улетят", new Step("Лисёнок подождал немного, и пчёлы разлетелись. Лисёнок без проблем набрал мёда. Вдруг он понял, что очень голоден. Что же делать?", "Поесть немного и передохнуть", "Скорее отнести мёд Медвежонку"));
        actions.put("Нужно попытаться выкрасть мёд немедленно", new Step("Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна помощь. Игра завершилась неудачей"));
        actions.put("Поесть немного и передохнуть", new Step("Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. Лисёнку нужна помощь, он не сможет продолжить поиски. Игра завершилась неудачей"));
        actions.put("Скорее отнести мёд Медвежонку", new Step("Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен, что Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, что Белки не попадают в неприятности, и что Совам нельзя верить, он также уговаривал Лисёнка вернуться домой.", "Медвежонок ничего не знает, нужно продолжить поиски -> Искать Бельчонка в одиночку", "Может быть он прав и Лисёнок просто паникует -> Вернуться домой"));
    }

    public void mainMenu() {
        while (!exit) {
            Menu menu = new Menu();
            menu.addCommand(commandStart);
            if (gameStarted) {
                menu.addCommand(commandSave);
            }
            if (new File(Settings.FILE_NAME).exists()) {
                menu.addCommand(commandLoad);
            }
            menu.addCommand(commandExit);
            menu.print();
            while (true) {
                try {
                    int num = Integer.parseInt(scanner.nextLine());
                    Command command = menu.getCommand(num);
                    if (command != null) {
                        command.execute();
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Введите корректное значение");
                }
            }
        }
    }

    public void start() {
        start(null);
    }

    public void start(String stepNameStart) {
        gameStarted = true;
        String stepName = stepNameStart == null ? Settings.STEP_1 : stepNameStart;
        while (true) {
            Step step = getStep(stepName);
            if (step == null) {
                System.out.println("Не найден шаг: " + stepName);
                break;
            }
            gameStarted = !step.isFinish();
            System.out.println(step.getDescription());
            List<String> options = step.getOptions();
            if (options.isEmpty()) break;
            printOptions(options);
            String option;
            while (true) {
                try {
                    int num = Integer.parseInt(scanner.nextLine());
                    option = step.getOptions().get(num - 1);
                    if (option != null) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Введите корректное значение");
                }
            }
            String[] str = option.split(Settings.OPTION_SEP);
            stepName = str.length == 2 ? str[1] : str[0];
            if (stepName.equals(Settings.MENU_EXIT)) break;
            stepNameToSave = stepName;
        }
    }

    public void save() {
        BinHandler binHandler = new BinHandler(new File(Settings.FILE_NAME));
        if (binHandler.writeToFile(stepNameToSave)) {
            System.out.println("Игра сохранена (шаг " + stepNameToSave + ")");
        }
    }

    public void load() {
        BinHandler binHandler = new BinHandler(new File(Settings.FILE_NAME));
        String stepName = binHandler.readFromFile();
        if (stepName != null) {
            System.out.println("Игра загружена (шаг " + stepName + ")");
            start(stepName);
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
            String[] str = options.get(i).split(Settings.OPTION_SEP);
            System.out.println((i+1) + ". " + str[0]);
        }
    }
}
