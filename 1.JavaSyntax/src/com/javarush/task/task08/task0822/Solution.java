package com.javarush.task.task08.task0822;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int min = Collections.min(array);
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String ns = bufferedReader.readLine();
        int N = Integer.parseInt(ns);
        ArrayList<Integer> list1 = new ArrayList<Integer>(N);

        int[] num = new int[10];

        for(int i = 0; i < N; i++){
            String bufs = bufferedReader.readLine();
            num[i] = Integer.parseInt(bufs);
            list1.add(num[i]);
        }

        return list1;
    }
}
