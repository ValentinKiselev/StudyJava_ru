package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] s1 = new String[10];
        s1[8] = null;
        s1[9] = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < s1.length-2; i++){
            s1[i] = reader.readLine();
        }
        for (int j = s1.length-1; j >= 0; j--){
            System.out.println(s1[j]);
        }
    }
}