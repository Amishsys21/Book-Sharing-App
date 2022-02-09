package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World - This is Java Case Study - Book Sharing App");

        Map<Integer, Set<String>> bookMap = new HashMap<>();
        Users user = new Users("Dhruv","dhruv@gmail.com");

        String[] bookAuthor = {"Author 1", "Author 2"};
        String[] keywords = {"Keyword 1", "Keyword 2"};

        Books book = new Books(101, "Java Learning", bookAuthor, keywords, user);
        book.add();
        book.display();
        System.out.println("=================");
        book.addBook();

        bookMap = book.getBook();

        for(Map.Entry m: bookMap.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

        book.search(101,"Java");
    }
}
