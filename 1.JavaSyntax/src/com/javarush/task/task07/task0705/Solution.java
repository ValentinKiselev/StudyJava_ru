package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] m1 = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; j < m1.length; j++){
            m1[j] = Integer.parseInt(reader.readLine());
        }
        int[] m2 = new int[10];
        int[] m3 = new int[10];
        System.arraycopy(m1,0, m2, 0,10);
        System.arraycopy(m1,10, m3, 0,10);
        for (int j = 0; j < m3.length; j++){
            System.out.println(m3[j]);
        }
    }
}
