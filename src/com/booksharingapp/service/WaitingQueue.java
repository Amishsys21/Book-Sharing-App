package com.booksharingapp.service;

import com.booksharingapp.model.User;

import java.util.*;

public class WaitingQueue {
    private String title;
    private Queue<User> waitQueue;

    public WaitingQueue(String title) {
        this.title = title;
        this.waitQueue = new LinkedList<>();
    }

    public String getTitle() {
        return title;
    }

    // function to add user to the queue
    public void addUserToQueue(User user) {
        waitQueue.add(user);
    }

    // function to get queue size
    public int getQueueSize() {
        return waitQueue.size();
    }

    // function to get waiting queue
    public Queue<User> getWaitQueue() {
        return waitQueue;
    }

    // function to remove user from the queue
    public void removeUserFromQueue(User user) {
        waitQueue.remove(user);
    }
}
