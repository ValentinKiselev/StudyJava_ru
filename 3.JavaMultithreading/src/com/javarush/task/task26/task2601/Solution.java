package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int lenght = array.length;
        int median = lenght % 2 != 0 ? array[lenght / 2] : (int)((array[lenght / 2] + array[lenght / 2 - 1]) / 2);
        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - median) - Math.abs(o2 - median);
            }
        };

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        Collections.sort(list, comp);
        Integer[] rez = list.toArray(new Integer[list.size()]);
        return rez;
    };
}