package com.booksharingapp;

import com.booksharingapp.model.Owner;

import java.util.*;

public class Book {
    private long isbn;
    private String title;
    private Set<String> authors;
    private Set<String> keywords;
    private Set<Owner> owner;

    public Book(long isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.authors = new HashSet<>();
        this.keywords = new HashSet<>();
        this.owner = new HashSet<>();
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean addAuthor(String author) {
        return this.authors.add(author);
    }

    public boolean addKeyword(String keyword) {
        return this.keywords.add(keyword);
    }

    public boolean addOwner(Owner owner) {
        return this.owner.add(owner);
    }

    public Set<String> getAuthors() {
        return new HashSet<>(this.authors);
    }

    public Set<String> getKeywords() {
        return new HashSet<>(this.keywords);
    }

    public Set<Owner> getOwner() {
        return new HashSet<>(this.owner);
    }
}
