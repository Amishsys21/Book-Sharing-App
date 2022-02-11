package com.company;

import java.util.*;

public class Book {
    private long isbn;
    private String title;
    Set<String> author = new HashSet<>();
    Set<String> keyword = new HashSet<>();

    public Book(long isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public void setAuthor() {
        author.add("Author 1");
        author.add("Author 2");
    }

    public void setKeyword() {
        keyword.add("Keyword 1");
        keyword.add("Keyword 2");
    }

    public void display() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Keyword: " + keyword);
    }
}
