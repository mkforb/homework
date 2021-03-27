package com.ifmo.jjd.homework6.task1;

import java.util.Objects;

public class BookStorage {
    private int number;
    private Book[] books;

    public BookStorage(int number) {
        setNumber(number);
        books = new Book[20];
    }

    public void addBook(Book book) {
        Objects.requireNonNull(book);
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
            }
        }
        System.out.println("В хранилище нет места");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("number < 1");
        }
        this.number = number;
    }

    public Book[] getBooks() {
        return books;
    }
}
