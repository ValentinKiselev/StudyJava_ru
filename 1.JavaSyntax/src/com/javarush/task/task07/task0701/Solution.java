package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        int[] m1 = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < m1.length; i++){
            m1[i] = Integer.parseInt(reader.readLine());
        }
        return m1;
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++){
        if(array[i] > max) max = array[i];
        }
        return max;
    }
}
