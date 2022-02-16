package com.booksharingapp;

import com.booksharingapp.model.Borrower;
import com.booksharingapp.model.User;
import com.booksharingapp.service.CheckStatus;
import com.booksharingapp.service.Search;
import com.booksharingapp.service.WaitingQueue;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Catalogue {
    private static Logger logger = Logger.getLogger(Catalogue.class.getName());
    private static Map<Long, Book> shelves = new HashMap<>();
    private static Map<String, Queue<User>> waitingQueueUser = new HashMap<>();
    private static Map<String, Borrower> rentedBookUser = new HashMap<>();

    public static void main(String[] args) {
        // add book
        Book book = new Book(123456, "Java Programming Book");
        User user = new User("Dhruv", "dhruv@gmail.com");
        book.addAuthor("JavaBoy");
        book.addAuthor("JavaDog");
        book.addKeyword("Java");
        book.addKeyword("Programming");
        book.addOwner(user);
        shelves.put(book.getIsbn(), book);

        book = new Book(323232, "Java Book");
        user = new User("Harshit", "harshit@gmail.com");
        book.addAuthor("JavaBoy");
        book.addAuthor("JavaDog");
        book.addKeyword("Java");
        book.addKeyword("Programming");
        book.addOwner(user);
        book.setStatus("Rented");
        shelves.put(book.getIsbn(), book);
        Borrower borrower = new Borrower("Catty", "catty@gmail.com");
        borrower.rentBook(book.getIsbn(), book);
        rentedBookUser.put(borrower.getName(), borrower);

        book = new Book(876538, "Python Programming Book");
        user = new User("Mayank", "mayank@gmail.com");
        book.addAuthor("PythonBoy");
        book.addAuthor("PythonSnake");
        book.addKeyword("Python");
        book.addKeyword("Programming");
        book.addKeyword("Book");
        book.addOwner(user);
        book.setStatus("Rented");
        shelves.put(book.getIsbn(), book);
        borrower.rentBook(book.getIsbn(), book);
        rentedBookUser.put(borrower.getName(), borrower);

        book = new Book(1432432, "C++ Programming Book");
        user = new User("Kartik", "kartik@gmail.com");
        book.addAuthor("C++Boy");
        book.addAuthor("C++Cat");
        book.addKeyword("Cat");
        book.addKeyword("Programming");
        book.addKeyword("Book");
        book.addOwner(user);
        book.setStatus("Rented");
        shelves.put(book.getIsbn(), book);
        borrower = new Borrower("Mathew", "Mathew@gmail.com");
        borrower.rentBook(book.getIsbn(), book);
        rentedBookUser.put(borrower.getName(), borrower);

        // display all books
        displayAllBooks(shelves);

        // display all rented books
        displayAllRentedBook(rentedBookUser);

        // search book
        Search search = new Search();

        // search by title
        search.searchByTitle("Java", shelves);
        search.display();

        // search by author
        search.searchByAuthor("PythonBoy", shelves);
        search.display();

        // search by keyword
        search.searchByKeyword("Book", shelves);
        search.display();

        // waiting queue
        WaitingQueue waitingQueue = new WaitingQueue("Java Book");
        waitingQueue.addUserToQueue(user);
        user = new User("Dan", "dan@gmail.com");
        waitingQueue.addUserToQueue(user);
        waitingQueueUser.put(waitingQueue.getTitle(), waitingQueue.getWaitQueue());


        waitingQueue = new WaitingQueue("Python Programming Book");
        user = new User("Gill", "gill@gmail.com");
        waitingQueue.addUserToQueue(user);
        user = new User("chill", "chill@gmail.com");
        waitingQueue.addUserToQueue(user);
        waitingQueueUser.put(waitingQueue.getTitle(), waitingQueue.getWaitQueue());

        waitingQueue = new WaitingQueue("C++ Programming Book");
        user = new User("May", "may@gmail.com");
        waitingQueue.addUserToQueue(user);
        user = new User("Amy", "amy@gmail.com");
        waitingQueue.addUserToQueue(user);
        user = new User("Yam", "yam@gmail.com");
        waitingQueue.addUserToQueue(user);
        waitingQueueUser.put(waitingQueue.getTitle(), waitingQueue.getWaitQueue());

        // display borrowers list
        displayBorrowersList(waitingQueueUser);

        // to check status of particular book
        CheckStatus cs = new CheckStatus("C++ Programming Book");
        cs.checkStatus(shelves);
        cs.statusOption(rentedBookUser, waitingQueueUser);
    }

    // display function -> to display all books
    private static void displayAllBooks(Map<Long, Book> shelves) {
        shelves.forEach((key, value) -> {
            logger.log(Level.INFO, () -> "Book ISBN: " + key);
            logger.log(Level.INFO, () -> "Book Name: " + value.getTitle());
            logger.log(Level.INFO, () -> "Book Authors: " + value.getAuthors());
            value.getOwner().forEach(val -> {
                logger.log(Level.INFO, () -> "Book Owner's Name: " + val.getName());
                logger.log(Level.INFO, () -> "Book Owner's Email: " + val.getEmail());
            });
            logger.log(Level.INFO, () -> "Status: " + value.getStatus());
            logger.log(Level.INFO, "================================");
        });
    }

    // display function -> to display all rented books
    private static void displayAllRentedBook(Map<String, Borrower> rentedBookUser) {
        rentedBookUser.forEach((key, value) -> {
            logger.log(Level.INFO, key);
            logger.log(Level.INFO, () -> value.getName() + ", " + value.getEmail());
            value.displayAllBooks();
        });
    }

    // display function -> to display borrowers list
    private static void displayBorrowersList(Map<String, Queue<User>> waitingQueueUser) {
        waitingQueueUser.forEach((key, value) -> {
            logger.log(Level.INFO, key);
            logger.log(Level.INFO, "Name - Email");
            value.forEach(val -> logger.log(Level.INFO, () -> val.getName() + " - " + val.getEmail()));
            logger.log(Level.INFO, "==========================");
        });
    }
}