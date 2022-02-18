package com.booksharingapp;

import com.booksharingapp.model.User;

import java.util.*;

public class Book {
    private long isbn;
    private String title;
    private Set<String> authors;
    private Set<String> keywords;
    private Set<User> user;
    private String status;

    public Book(long isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.authors = new HashSet<>();
        this.keywords = new HashSet<>();
        this.user = new HashSet<>();
        this.status = "Available";
    }

    // setter function
    public void setStatus(String status) {
        this.status = status;
    }

    public void addAuthor(String author) {
        authors.add(author);
    }

    public void addKeyword(String keyword) {
        keywords.add(keyword);
    }

    public void addUser(User user) {
        this.user.add(user);
    }

    // getter functions
    public String getStatus() {
        return status;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public Set<User> getUser() {
        return user;
    }
}