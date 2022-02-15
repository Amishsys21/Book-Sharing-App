package com.booksharingapp.service;

import com.booksharingapp.model.Owner;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WaitingQueue {
    private static Logger logger = Logger.getLogger(WaitingQueue.class.getName());
    private String title;
    private Queue<Owner> waitingQueue;

    public WaitingQueue(String title) {
        this.title = title;
        this.waitingQueue = new LinkedList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addBorrower(Owner owner) {
        waitingQueue.add(owner);
    }

    public int getQueueSize() {
        return waitingQueue.size();
    }

    public void displayQueue() {
        logger.log(Level.INFO, "Current elements in the queue: ");
        waitingQueue.forEach(value -> logger.log(Level.INFO, () -> value.getName() + " " + value.getEmail()));
    }

    public Queue<Owner> getWaitingQueue() {
        return waitingQueue;
    }
}
