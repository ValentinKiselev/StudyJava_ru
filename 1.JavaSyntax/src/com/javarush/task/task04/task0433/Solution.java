package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int j = 0;
        while(j<10) {
            int i = 0;
            while (i < 10) {
                System.out.print("S");
                i++;
            }
            System.out.println("");
            j++;
        }
    }
}
