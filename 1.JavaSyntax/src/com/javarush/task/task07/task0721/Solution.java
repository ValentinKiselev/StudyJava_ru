package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        int[] mas = new int[20];

        for (int j = 0; j < 20; j++){
            mas[j] = Integer.parseInt(reader.readLine());
        }

       Arrays.sort(mas);

        System.out.print(mas[mas.length-1] + " " + mas[0]);
    }
}
