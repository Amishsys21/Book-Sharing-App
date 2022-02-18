package com.booksharingapp.service;

import com.booksharingapp.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Search {
    private Logger logger = Logger.getLogger(Search.class.getName());
    private Map<Long, Book> searchResult;

    public Search() {
        searchResult = new HashMap<>();
    }

    // function to search using title
    public void searchByTitle(String title, Map<Long, Book> shelves) {
        searchResult.clear();
        shelves.forEach((key, value) -> {
            if (value.getTitle().toLowerCase().contains(title.toLowerCase())) {
                searchResult.put(key, value);
            }
        });
    }

    // function to search using author
    public void searchByAuthor(String author, Map<Long, Book> shelves) {
        searchResult.clear();
        shelves.forEach((key, value) -> {
            if (value.getAuthors().contains(author)) {
                searchResult.put(key, value);
            }
        });
    }

    // function to search using keywords
    public void searchByKeyword(String keyword, Map<Long, Book> shelves) {
        searchResult.clear();
        shelves.forEach((key, value) -> {
            if (value.getKeywords().contains(keyword)) {
                searchResult.put(key, value);
            }
        });
    }

    // function to display the search result
    public void display() {
        logger.log(Level.INFO,"============================");
        searchResult.forEach((key, value) -> {
            logger.log(Level.INFO,() -> "Book ISBN: " + key);
            logger.log(Level.INFO,() -> "Book Name: " + value.getTitle());
            logger.log(Level.INFO,() -> "Book Authors: " + value.getAuthors());
            value.getUser().forEach(val -> {
                logger.log(Level.INFO,() -> "Book Owner's Name: " + val.getName());
                logger.log(Level.INFO,() -> "Book Owner's Email: " + val.getEmail());
            });
            logger.log(Level.INFO,() -> "Book Status: " + value.getStatus());
        });
    }
}
