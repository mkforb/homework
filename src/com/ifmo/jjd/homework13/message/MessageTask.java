package com.ifmo.jjd.homework13.message;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
        for (Message.MessagePriority messagePriority : Message.MessagePriority.values()) {
            int count = 0;
            for (Message message : messageList) {
                if (message.getPriority() == messagePriority) count++;
            }
            System.out.println(messagePriority.name() + " - " + count);
        }
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Message> messageHashSet = new HashSet<>(messageList);
        System.out.println(messageHashSet.size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        LinkedHashSet<Message> messageLinkedHashSet = new LinkedHashSet<>(messageList);
        return new ArrayList<>(messageLinkedHashSet);
    }

    public static List<Message> copyEach(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: создать коллекцию и передать в нее ссылки на каждое сообщение с заданным приоритетом
        //  метод должен вернуть новую коллекцию
        ArrayList<Message> newList = new ArrayList<>();
        for (Message message : messageList) {
            if (message.getPriority().equals(priority)) newList.add(message);
        }
        return newList;
    }

    public static List<Message> copyOther(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: создать коллекцию и передать в нее ссылки на все сообщения, кроме тех, которые имеют заданный приоритет
        //  метод должен вернуть новую коллекцию
        ArrayList<Message> newList = new ArrayList<>();
        for (Message message : messageList) {
            if (!message.getPriority().equals(priority)) newList.add(message);
        }
        return newList;
    }

    public static void main(String[] args) {
        List<Message> messages = Message.MessageGenerator.generate(34);
        System.out.println(messages);
        // вызов методов
        countEachPriority(messages);
        countEachCode(messages);
        uniqueMessageCount(messages);
        System.out.println(uniqueMessagesInOriginalOrder(messages));
        System.out.println(copyEach(messages, Message.MessagePriority.LOW));
        System.out.println(copyOther(messages, Message.MessagePriority.LOW));
    }
}