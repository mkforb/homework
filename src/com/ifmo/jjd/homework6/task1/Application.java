package com.ifmo.jjd.homework6.task1;

public class Application {
    public static void main(String[] args) {
        Author authorASPushkin = new Author("Александр Сергеевич", "Пушкин");
        Book bookOnegin = new Book("Евгений Онегин", 1, 150, 2018);
        bookOnegin.addAuthor(authorASPushkin);
        BookStorage storage1 = new BookStorage(1);
        storage1.addBook(bookOnegin);

        Author authorLNTolstoy = new Author("Лев Николаевич", "Толстой");
        Book bookAnnaKarenina = new Book("Анна Каренина", 1, 250, 2017);
        bookAnnaKarenina.addAuthor(authorLNTolstoy);
        storage1.addBook(bookAnnaKarenina);

        System.out.println(storage1);
    }
}
