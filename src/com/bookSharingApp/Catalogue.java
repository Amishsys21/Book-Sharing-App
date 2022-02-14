package com.bookSharingApp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Catalogue {
    private static Map<Long, Book> shelves = new HashMap<>();
    private static Set<Book> listOfBooks = new HashSet<>();

    public static void main(String[] args) {
        Book book = new Book(123456, "Java Programming Book");
        book.addAuthor("JavaBoy");
        book.addAuthor("JavaDog");
        book.addKeyword("Java");
        book.addKeyword("Programming");
        shelves.put(book.getIsbn(), book);
        listOfBooks.add(book);

        book = new Book(876538, "Python Programming Book");
        shelves.put(book.getIsbn(), book);
        listOfBooks.add(book);

        book.addAuthor("PythonBoy");
        book.addAuthor("PythonSnake");
        book.addKeyword("Python");
        book.addKeyword("Programming");
        book.addKeyword("Book");

        book = new Book(1432432, "C++ Programming Book");
        shelves.put(book.getIsbn(), book);
        listOfBooks.add(book);

        book.addAuthor("C++Boy");
        book.addAuthor("C++Cat");
        book.addKeyword("Cat");
        book.addKeyword("Programming");
        book.addKeyword("Book");

        System.out.println("Books: ");
        for (Book b: listOfBooks) {
            System.out.println(b.getIsbn() + " - " + b.getTitle() + " - " + b.getAuthor() + " - " + b.getKeyword());
        }

        System.out.println("================================");

        for (Map.Entry<Long, Book> entry: shelves.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue().getIsbn());
        }

        searchByTitle("Java Programming Book", shelves);
        searchByAuthor("JavaBoy", shelves);
        searchByKeyword("Java", shelves);
    }

    public static void searchByTitle(String title, Map<Long, Book> shelves) {
        for (Map.Entry<Long, Book> entry: shelves.entrySet()) {
            if (entry.getValue().getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book Found");
                System.out.println(entry.getKey() + " => " + entry.getValue().getTitle() + ", " + entry.getValue().getAuthor() + ", " + entry.getValue().getKeyword());
            }
        }
    }

    public static void searchByAuthor(String author, Map<Long, Book> shelves) {
        for (Map.Entry<Long, Book> entry: shelves.entrySet()) {
            if (entry.getValue().getAuthor().contains(author)) {
                System.out.println("Book Found");
                System.out.println(entry.getKey() + " => " + entry.getValue().getTitle() + ", " + entry.getValue().getAuthor() + ", " + entry.getValue().getKeyword());
            }
        }
    }

    public static void searchByKeyword(String keyword, Map<Long, Book> shelves) {
        for (Map.Entry<Long, Book> entry: shelves.entrySet()) {
            if (entry.getValue().getKeyword().contains(keyword)) {
                System.out.println("Book Found");
                System.out.println(entry.getKey() + " => " + entry.getValue().getTitle() + ", " + entry.getValue().getAuthor() + ", " + entry.getValue().getKeyword());
            }
        }
    }
}
