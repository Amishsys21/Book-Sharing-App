package com.booksharingapp.service;

import com.booksharingapp.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Notification {
    private static Logger logger = Logger.getLogger(Notification.class.getName());
    private String title;
    private String from;
    private String to;
    private String subject;
    private String message;
    private Map<Long, Book> notifyBook;

    public Notification(String title, String from, String to, String subject, String message) {
        this.title = title;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
        notifyBook = new HashMap<>();
    }

    public void checkAvailability(Map<Long, Book> shelves) {
        shelves.forEach((key, value) -> {
            if (value.getTitle().toLowerCase().contains(title.toLowerCase())) {
                if (value.getStatus().equalsIgnoreCase("available")) {
                    logger.log(Level.INFO,"Book is available for issue");
                    notifyBook.put(key, value);
                    sendEmail();
                } else {
                    logger.log(Level.INFO, "Book already issued");
                }
            }
        });
    }

    public void sendEmail() {
        logger.log(Level.INFO,() -> "From: " + from);
        logger.log(Level.INFO,() -> "To: " + to);
        logger.log(Level.INFO,() -> "Subject: " + subject);
        logger.log(Level.INFO,() -> "Message: " + message);

        // book details
        logger.log(Level.INFO,"Book Details: ");
        notifyBook.forEach((key, value) -> {
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
