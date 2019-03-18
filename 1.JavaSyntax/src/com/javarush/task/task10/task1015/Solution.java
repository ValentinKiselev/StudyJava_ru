package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {

        ArrayList<String>[] arrayListsmassive = new ArrayList[2];
        ArrayList<String> g = new ArrayList<>();
        g.add("d");
        ArrayList<String> gg = new ArrayList<>();
        gg.add("dd");
        arrayListsmassive[0] = g;
        arrayListsmassive[1] = gg;

        return arrayListsmassive;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}