package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> mapcat = new HashMap<>();
        Cat cat1 = new Cat("Kus");
        mapcat.put(cat1.name, cat1);
        Cat cat12 = new Cat("Kus1");
        mapcat.put(cat12.name, cat12);
        Cat cat13 = new Cat("Kus2");
        mapcat.put(cat13.name, cat13);
        Cat cat14 = new Cat("Kus3");
        mapcat.put(cat14.name, cat14);
        Cat cat15 = new Cat("Kus4");
        mapcat.put(cat15.name, cat15);
        Cat cat16 = new Cat("Kus5");
        mapcat.put(cat16.name, cat16);
        Cat cat17 = new Cat("Kus6");
        mapcat.put(cat17.name, cat17);
        Cat cat18 = new Cat("Kus7");
        mapcat.put(cat18.name, cat18);
        Cat cat19 = new Cat("Kus8");
        mapcat.put(cat19.name, cat19);
        Cat cat21 = new Cat("Kus9");
        mapcat.put(cat21.name, cat21);
        return mapcat;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> catset = new HashSet<>();
        for(Cat value: map.values()){
        catset.add(value);
        }
        return catset;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
