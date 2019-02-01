package com.javarush.task.task08.task0819;

import javax.swing.text.html.HTMLDocument;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        Iterator<Cat> icats = cats.iterator();
        Cat cat = icats.next();
        icats.remove();
        printCats(cats);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> catss = new HashSet<Cat>();
        catss.add(new Cat());
        catss.add(new Cat());
        catss.add(new Cat());
        return catss;
    }

    public static void printCats(Set<Cat> cats) {

            for(Cat cat: cats) {
                System.out.println(cats);
            }

    }

    public static class Cat{

    }
}
