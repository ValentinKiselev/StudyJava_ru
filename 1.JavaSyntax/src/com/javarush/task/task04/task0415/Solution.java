package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String as = bufferedReader.readLine();
        String bs = bufferedReader.readLine();
        String cs = bufferedReader.readLine();
        int a =  Integer.parseInt(as);
        int b =  Integer.parseInt(bs);
        int c =  Integer.parseInt(cs);

        if ((a+b>c) && (a+c>b) && (b+c>a))
            System.out.println("Треугольник существует.");
        else
            System.out.println("Треугольник не существует.");


    }
}