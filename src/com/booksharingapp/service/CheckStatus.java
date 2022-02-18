package com.booksharingapp.service;

import com.booksharingapp.Book;
import com.booksharingapp.model.Borrower;
import com.booksharingapp.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckStatus {
    private Logger logger = Logger.getLogger(CheckStatus.class.getName());
    private String title;
    private Map<Long, Book> bookStatus;

    public CheckStatus(String title) {
        this.title = title;
        this.bookStatus = new HashMap<>();
    }

    // search book to check status and store in the bookStatus data structure
    public void checkStatus(Map<Long, Book> shelves, Map<String, Borrower> rentedBookUser, Map<String, Queue<User>> waitingQueueUser) {
        shelves.forEach((key, value) -> {
            if (value.getTitle().toLowerCase().contains(title.toLowerCase())) {
                if (value.getStatus().equalsIgnoreCase("available")) {
                    logger.log(Level.INFO,"Book is available for issue");
                } else {
                    bookStatus.put(key, value);
                    logger.log(Level.INFO, "Book already issued");
                    displayCurrentBorrower(rentedBookUser);
                    displayWaitingQueue(waitingQueueUser);
                }
            }
        });
    }

    // display function -> to display waiting queue for the book
    private void displayWaitingQueue(Map<String, Queue<User>> waitingQueueUser) {
        logger.log(Level.INFO,"Waiting Queue: ");
        waitingQueueUser.forEach((key, value) -> {
            if (key.equalsIgnoreCase(title)) {
                value.forEach(val -> logger.log(Level.INFO,() -> val.getName() + " - " + val.getEmail()));
            }
        });
    }

    // display function -> to show current book borrower
    private void displayCurrentBorrower(Map<String, Borrower> rentedBookUser) {
        logger.log(Level.INFO,"Current book borrower: ");
        rentedBookUser.forEach((key, value) -> value.getRentedBooks().forEach((k, val)->{
            if (val.getTitle().equalsIgnoreCase(title)) {
                logger.log(Level.INFO,() -> value.getName() + " - " + value.getEmail());
            }
        }));
        logger.log(Level.INFO,"===================");
    }
}
