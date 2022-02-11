package com.bookSharingApp;

import com.bookSharingApp.model.Author;

public class Catalogue {
    public static void main(String[] args) {
        Book book = new Book(123456, "Java Learning", null, null);

        Author author = new Author();
        author.setName("James");
    }
}
