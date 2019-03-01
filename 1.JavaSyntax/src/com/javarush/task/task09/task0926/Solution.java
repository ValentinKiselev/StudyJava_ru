package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        int[] a1 = {1,2,3,4,5};
        int[] a2 = {1,2};
        int[] a3 = {1,2,3,4};
        int[] a4 = {1,2,3,4,5,6,7};
        int[] a5 = {};
        ArrayList<int[]> am = new ArrayList<>();
        am.add(a1);
        am.add(a2);
        am.add(a3);
        am.add(a4);
        am.add(a5);
        return am;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
