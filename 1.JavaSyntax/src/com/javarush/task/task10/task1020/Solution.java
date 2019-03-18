package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array) {
        for(int k = array.length-1; k > 0; k--) {
            for(int l = 0; l < k; l++){
                if(array[l] > array[l+1]) {
                    int bufn = array[l];
                    array[l] = array[l+1];
                    array[l+1] = bufn;
                }
                }
            }
    }
}
