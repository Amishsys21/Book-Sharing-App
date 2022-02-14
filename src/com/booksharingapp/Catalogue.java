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

        book = new Book(323232, "Java Book");
        owner = new Owner("Harshit", "harshit@gmail.com");
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

        Map<Long, List<String>> searchTitleResult = searchTitle("Java Book", shelves);
        displayResult(searchTitleResult);

        Map<Long, List<String>> searchAuthorResult = searchAuthor("C++Boy", shelves);
        displayResult(searchAuthorResult);

        Map<Long, List<String>> searchKeywordResult = searchKeyword("Book", shelves);
        displayResult(searchKeywordResult);
    }

    private static void displayResult(Map<Long, List<String>> searchResult) {
        searchResult.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    private static Map<Long, List<String>> searchTitle(String title, Map<Long, Book> shelves) {
        logger.log(Level.INFO, "============ Map ==============");
        Map<Long, List<String>> mapResult = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (Map.Entry<Long, Book> entry: shelves.entrySet()) {
            if (entry.getValue().getTitle().equalsIgnoreCase(title)) {
                result.add(String.valueOf(entry.getKey()));
                result.add(entry.getValue().getTitle());
                result.add(entry.getValue().getAuthors().toString());
                result.add(entry.getValue().getKeywords().toString());
                mapResult.put(entry.getKey(), result);
                return mapResult;
            }
        }
        return null;
    }

    private static Map<Long, List<String>> searchAuthor(String author, Map<Long, Book> shelves) {
        logger.log(Level.INFO, "============ Map ==============");
        Map<Long, List<String>> mapResult = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (Map.Entry<Long, Book> entry: shelves.entrySet()) {
            if (entry.getValue().getAuthors().contains(author)) {
                result.add(String.valueOf(entry.getKey()));
                result.add(entry.getValue().getTitle());
                result.add(entry.getValue().getAuthors().toString());
                result.add(entry.getValue().getKeywords().toString());
                mapResult.put(entry.getKey(), result);
                return mapResult;
            }
        }
        return null;
    }

    private static Map<Long, List<String>> searchKeyword(String keyword, Map<Long, Book> shelves) {
        logger.log(Level.INFO, "============ Map ==============");
        Map<Long, List<String>> mapResult = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (Map.Entry<Long, Book> entry: shelves.entrySet()) {
            if (entry.getValue().getKeywords().contains(keyword)) {
                result.add(String.valueOf(entry.getKey()));
                result.add(entry.getValue().getTitle());
                result.add(entry.getValue().getAuthors().toString());
                result.add(entry.getValue().getKeywords().toString());
                mapResult.put(entry.getKey(), result);
                return mapResult;
            }
        }
        return null;
    }
}