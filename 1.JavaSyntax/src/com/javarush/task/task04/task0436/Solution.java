package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String as = bufferedReader.readLine();
        String bs = bufferedReader.readLine();
        int m = Integer.parseInt(as);
        int n = Integer.parseInt(bs);
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                System.out.print("8");
            }
        System.out.println("");
        }

    }
}
