package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World - This is Java Case Study - Book Sharing App");

        Set<String> ts1 = new TreeSet<>();
        ts1.add("A");
        ts1.add("B");
        ts1.add("C");

        Set<Set> newSet = new HashSet<>();
        newSet.add(ts1);

        for (Set set  : newSet) {
            System.out.println(set);
        }

        Map<Integer, Set> map = new HashMap<>();
        map.put(1, ts1);

        for(Map.Entry m:map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

        Map<Integer, String> newMap = new HashMap<>();
//        newMap.put(1, "H");
//        newMap.put(1, "c");
//        newMap.put(1, "b");

//        newMap.set(1,"A");
//        newMap.set(1,"B");



        for (Map.Entry m: newMap.entrySet()) {
            System.out.println(m.getKey() + " - " + m.getValue());
        }
    }
}
