package com.booksharingapp.model;

import com.booksharingapp.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Borrower {
    private Logger logger = Logger.getLogger(Borrower.class.getName());
    private String name;
    private String email;
    private Map<Long, Book> rentedBooks;

    public Borrower(String name, String email) {
        this.name = name;
        this.email = email;
        this.rentedBooks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // function to rent book
    public void rentBook(Long isbn, Book book) {
        book.setStatus("Rented");
        rentedBooks.put(isbn, book);
    }

    // function to display all the rented books
    public void displayAllBooks() {
        rentedBooks.forEach((key, value) -> {
            logger.log(Level.INFO, ()-> "Book ISBN: " + key);
            logger.log(Level.INFO,() -> "Book Name: " + value.getTitle());
            logger.log(Level.INFO,() -> "Book Authors: " + value.getAuthors());
            value.getUser().forEach(val -> {
                logger.log(Level.INFO,() -> "Book Owner's Name: " + val.getName());
                logger.log(Level.INFO,() -> "Book Owner's Email: " + val.getEmail());
            });
            logger.log(Level.INFO,() -> "Book Status: " + value.getStatus());
        });
    }

    // function to return book
    public void returnBook(String title) {
        for (Map.Entry<Long, Book> entry: rentedBooks.entrySet()) {
            if (entry.getValue().getTitle().equalsIgnoreCase(title)) {
                entry.getValue().setStatus("Available");
                rentedBooks.remove(entry.getKey());
            }
        }
    }

    // to return the map of rented book
    public Map<Long, Book> getRentedBooks() {
        return rentedBooks;
    }
}
