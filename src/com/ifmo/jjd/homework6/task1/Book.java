package com.ifmo.jjd.homework6.task1;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private String title;
    private Author[] authors;
    private int pageCount;
    private int publishYear;

    public Book(String title, int authorsCount, int pageCount, int publishYear) {
        setTitle(title);
        authors = new Author[authorsCount];
        setPageCount(pageCount);
        setPublishYear(publishYear);
    }

    public void addAuthor(Author author) {
        Objects.requireNonNull(author, "author не может быть null");
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                authors[i] = author;
                return;
            }
        }
        System.out.println("Авторы уже все известны");
    }

    public void addAuthor(Author... authors) {
        for (Author author : authors) {
            addAuthor(author);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.length() < 3) {
            throw new IllegalArgumentException("title < 3");
        }
        this.title = title;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if (pageCount < 1) {
            throw new IllegalArgumentException("pageCount < 1");
        }
        this.pageCount = pageCount;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        if (publishYear < 0) {
            // Разве что книга издана до нашей эры
            throw new IllegalArgumentException("publishYear < 0");
        }
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", pageCount=" + pageCount +
                ", publishYear=" + publishYear +
                '}';
    }
}
