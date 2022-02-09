package com.company;

import java.util.*;

// key --------------> value
// ISBN -------------> ["Book Title", ["Author1", "Author2"], ["KeyWord1", "KeyWord2"], ["OwnerName", "OwnerEmail"]]
// ISBN -------------> ["Book Title", "Author1", "Author2", "KeyWord1", "KeyWord2", "OwnerName", "OwnerEmail"]

public class Books {
    private int bookISBN;
    private String bookTitle;
    private String[] bookAuthor;
    private String[] keywords;
    Set<String> bookObj = new HashSet<>();
    Map<Integer, Set<String>> book = new HashMap<>();
    Users users;

    public Books(int bookISBN, String bookTitle, String[] bookAuthor, String[] keywords, Users user) {
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.keywords = keywords;
        users = user;
    }

    public void add() {
        bookObj.add(bookTitle);
        bookObj.addAll(Arrays.asList(bookAuthor));
        bookObj.addAll(Arrays.asList(keywords));
        bookObj.add(users.getUserName());
        bookObj.add(users.getUserEmail());
    }

    public void addBook() {
        book.put(bookISBN, bookObj);
    }

    public void display() {
        System.out.println(bookObj);
    }

    public Map<Integer, Set<String>> getBook() {
        return book;
    }

    public void search(int isbn, String searchText) {
        boolean result = book.entrySet().stream()
                .filter(e -> e.getKey().equals(isbn))
                .map(Map.Entry::getValue)
                .flatMap(Set::stream)
                .anyMatch(s -> s.contains(searchText));
        System.out.println(result);
    }
}
