package com.bookSharingApp;

import java.util.*;

public class Book {
    private long isbn;
    private String title;
    private Set<String> author;
    private Set<String> keyword;

    public Book(long isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.author = new HashSet<String>();
        this.keyword = new HashSet<String>();
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean addAuthor(String author) {
        return this.author.add(author);
    }

    public boolean addKeyword(String keyword) {
        return this.keyword.add(keyword);
    }

    public Set<String> getAuthor() {
        return new HashSet<>(this.author);
    }

    public Set<String> getKeyword() {
        return new HashSet<>(this.keyword);
    }
}
