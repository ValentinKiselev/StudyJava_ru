package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[5];
        for (int i = 0; i < 5; i++){
        num[i] = Integer.parseInt(reader.readLine());
        }
        int y = 0;
        for (int j = 5-1; j >= 1; j--){
            for(int ii = 0; ii < j; ii++) {
                if (num[ii] > num[ii + 1]){
                y = num[ii];
                num[ii] = num[ii + 1];
                num[ii + 1] = y;
                }
            }
        }
        for(int i = 0; i < 5; i++){
        System.out.println(num[i]);
        }
    }
}
