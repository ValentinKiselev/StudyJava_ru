package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
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
        int a = Integer.parseInt(as);
        int b = Integer.parseInt(bs);
        int c = Integer.parseInt(cs);

        if ((a > 0 && b < 0 && c < 0) || (b > 0 && a < 0 && c < 0) || (c > 0 && a < 0 && b < 0))
        System.out.println("количество отрицательных чисел: 2");
        System.out.println("количество положительных чисел: 1");

        if ((a > 0 && b > 0 && c < 0) || (a > 0 && c > 0 && b < 0) || (b > 0 && c > 0 && a < 0))
        System.out.println("количество отрицательных чисел: 1");
        System.out.println("количество положительных чисел: 2");

        if (a > 0 && b > 0 && c > 0)
        System.out.println("количество положительных чисел: 3");
        System.out.println("количество отрицательных чисел: 0");

        if (a < 0 && b < 0 && c < 0)
        System.out.println("количество отрицательных чисел: 3");
        System.out.println("количество положительных чисел: 0");

        if ((a == 0) && (b > 0 && c < 0) || (b < 0 && c > 0))
        System.out.println("количество отрицательных чисел: 1");
        System.out.println("количество положительных чисел: 1");

        if ((a == 0) && b > 0 && c > 0)
        System.out.println("количество отрицательных чисел: 0");
        System.out.println("количество положительных чисел: 2");

        if ((a == 0) && b < 0 && c < 0)
        System.out.println("количество отрицательных чисел: 2");
        System.out.println("количество положительных чисел: 0");

        if ((b == 0) && (a > 0 && c < 0) || (a < 0 && c > 0))
        System.out.println("количество отрицательных чисел: 1");
        System.out.println("количество положительных чисел: 1");

        if ((b == 0) && a > 0 && c > 0)
        System.out.println("количество отрицательных чисел: 0");
        System.out.println("количество положительных чисел: 2");

        if ((b == 0) && a < 0 && c < 0)
        System.out.println("количество отрицательных чисел: 2");
        System.out.println("количество положительных чисел: 0");

        if ((c == 0) && (b > 0 && a < 0) || (b < 0 && a > 0))
        System.out.println("количество отрицательных чисел: 1");
        System.out.println("количество положительных чисел: 1");

        if ((c == 0) && b > 0 && a > 0)
        System.out.println("количество отрицательных чисел: 0");

        if ((c == 0) && b < 0 && a < 0)
        System.out.println("количество отрицательных чисел: 2");
        System.out.println("количество положительных чисел: 0");

        if ((a == 0 && b == 0) || (a == 0 && c == 0) || (b == 0 && c == 0)){
            if (a>0){
            System.out.println("количество отрицательных чисел: 0");
            System.out.println("количество положительных чисел: 1");}
            if (a<0){
            System.out.println("количество отрицательных чисел: 1");
            System.out.println("количество положительных чисел: 0");}
            if (b>0) {
            System.out.println("количество отрицательных чисел: 0");
            System.out.println("количество положительных чисел: 1");}
            if (b<0){
            System.out.println("количество отрицательных чисел: 1");
            System.out.println("количество положительных чисел: 0");}
            if (c>0){
            System.out.println("количество отрицательных чисел: 0");
            System.out.println("количество положительных чисел: 1");}
            if (c<0){
            System.out.println("количество отрицательных чисел: 1");
            System.out.println("количество положительных чисел: 0");}
        }

        if ((a == 0) && a > 0 || b > 0 || c > 0)
        System.out.println("количество отрицательных чисел: 0");
        System.out.println("количество положительных чисел: 1");

        if (a == 0 && b == 0 && c == 0)
        System.out.println("количество отрицательных чисел: 0");
        System.out.println("количество положительных чисел: 0");
    }
}
