package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] m1 = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; j < m1.length; j++){
            m1[j] = Integer.parseInt(reader.readLine());
        }
        for (int j = m1.length-1; j >= 0; j--){
            System.out.println(m1[j]);
        }
    }
}

