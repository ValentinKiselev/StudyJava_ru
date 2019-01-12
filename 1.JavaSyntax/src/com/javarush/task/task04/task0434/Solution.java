package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int j = 1;
        int k = 1;
        while(j<11) {
            int i = 0;
            k = j;
            while (i * k < 10 * k) {
                i++;
                System.out.print(i*k + " ");
            }
            System.out.println("");
            j++;
        }

    }
}
