package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Books {
    public int bookISBN;
    public String bookTitle;
    Set<String> keyword = new HashSet<>();
    Set<String> author = new HashSet<>();
    Set<String> owner = new HashSet<>();
    Map<Integer, Set> book = new HashMap();
}
