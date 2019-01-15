package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] m1 = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; j < m1.length; j++){
            m1[j] = Integer.parseInt(reader.readLine());
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int j = 0; j < m1.length; j++){
            if (j == 0 || j % 2 == 0) sum1 = sum1 + m1[j];
            else sum2 = sum2 +m1[j];
        }
        if (sum1 > sum2) System.out.println("В домах с четными номерами проживает больше жителей.");
        if (sum1 < sum2) System.out.println( "В домах с нечетными номерами проживает больше жителей.");
        if (sum1 == sum2) {};
    }
}
