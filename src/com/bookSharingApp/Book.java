package com.bookSharingApp;

import com.bookSharingApp.model.Author;
import com.bookSharingApp.model.Keyword;
import com.bookSharingApp.model.Owner;

import java.util.List;

public class Book {
    private long isbn;
    private String title;
    private List<Author> author;
    private List<Keyword> keyword;
    private Owner owner;

    public Book(long isbn, String title, List<Author> author, List<Keyword> keyword) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.keyword = keyword;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void addAuthor(List<Author> author) {
        this.author = author;
    }

    public List<Keyword> getKeyword() {
        return keyword;
    }

    public void setKeyword(List<Keyword> keyword) {
        this.keyword = keyword;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
