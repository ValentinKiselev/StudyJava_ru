package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int m = 10;
        int n = 10;
        for (int i = 1; i < m+1; i++){
            for (int j = 0; j < i; j++) {
                System.out.print("8");
            }
            System.out.println("");
        }

    }
}
