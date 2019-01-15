package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] s1 = new String[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < s1.length; i++){
            s1[i] = reader.readLine();
        }
        int[] m1 = new int[10];
        for (int i = 0; i < m1.length; i++){
            m1[i] = s1[i].length();
        }
        for (int i = 0; i < m1.length; i++)
            System.out.println(m1[i]);

    }
}
