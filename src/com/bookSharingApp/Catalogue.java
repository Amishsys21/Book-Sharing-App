package com.booksharingapp;

import com.booksharingapp.model.Owner;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Catalogue {
    private static Logger logger = Logger.getLogger(Catalogue.class.getName());
    private static Map<Long, Book> shelves = new HashMap<>();

    public static void main(String[] args) {
        Book book = new Book(123456, "Java Programming Book");
        Owner owner = new Owner("Dhruv", "dhruv@gmail.com");
        book.addAuthor("JavaBoy");
        book.addAuthor("JavaDog");
        book.addKeyword("Java");
        book.addKeyword("Programming");
        book.addOwner(owner);
        shelves.put(book.getIsbn(), book);

        book = new Book(876538, "Python Programming Book");
        owner = new Owner("Mayank", "mayank@gmail.com");
        book.addAuthor("PythonBoy");
        book.addAuthor("PythonSnake");
        book.addKeyword("Python");
        book.addKeyword("Programming");
        book.addKeyword("Book");
        book.addOwner(owner);

        shelves.put(book.getIsbn(), book);

        book = new Book(1432432, "C++ Programming Book");
        owner = new Owner("Kartik", "kartik@gmail.com");
        book.addAuthor("C++Boy");
        book.addAuthor("C++Cat");
        book.addKeyword("Cat");
        book.addKeyword("Programming");
        book.addKeyword("Book");
        book.addOwner(owner);

        shelves.put(book.getIsbn(), book);

        List<String> searchByTitleResult = searchByTitle("Java Programming Book", shelves);
        displayResult(searchByTitleResult);

        List<String> searchByAuthorResult = searchByAuthor("PythonBoy", shelves);
        displayResult(searchByAuthorResult);

        List<String> searchByKeywordResult = searchByKeyword("Cat", shelves);
        displayResult(searchByKeywordResult);
    }

    public static List<String> searchByTitle(String title, Map<Long, Book> shelves) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<Long, Book> entry: shelves.entrySet()) {
            if (entry.getValue().getTitle().equalsIgnoreCase(title)) {
                logger.log(Level.INFO,"Book Found");
                result.add(String.valueOf(entry.getKey()));
                result.add(entry.getValue().getTitle());
                result.add(entry.getValue().getAuthors().toString());
                result.add(entry.getValue().getKeywords().toString());
                return result;
            }
        }
        return null;
    }

    public static List<String> searchByAuthor(String author, Map<Long, Book> shelves) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<Long, Book> entry: shelves.entrySet()) {
            if (entry.getValue().getAuthors().contains(author)) {
                logger.log(Level.INFO,"Book Found");
                result.add(String.valueOf(entry.getKey()));
                result.add(entry.getValue().getTitle());
                result.add(entry.getValue().getAuthors().toString());
                result.add(entry.getValue().getKeywords().toString());
                return result;
            }
        }
        return null;
    }

    public static List<String> searchByKeyword(String keyword, Map<Long, Book> shelves) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<Long, Book> entry: shelves.entrySet()) {
            if (entry.getValue().getKeywords().contains(keyword)) {
                logger.log(Level.INFO,"Book Found");
                result.add(String.valueOf(entry.getKey()));
                result.add(entry.getValue().getTitle());
                result.add(entry.getValue().getAuthors().toString());
                result.add(entry.getValue().getKeywords().toString());
                return result;
            }
        }
        return null;
    }

    public static void displayResult(List<String> resultList) {
        for (String result: resultList) {
            logger.log(Level.INFO, result);
        }
    }
}
