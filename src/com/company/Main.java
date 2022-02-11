package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Book book = new Book(123456, "Java Programming Book");
        book.setAuthor();
        book.setKeyword();
        book.display();
    }
}
