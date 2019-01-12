package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String as = bufferedReader.readLine();
        int a =  Integer.parseInt(as);
        if (a%2 == 0 && 9-a >= 0 && a >=1) System.out.println("четное однозначное число");
        if (a%2 != 0 && 9-a >= 0 && a >=1) System.out.println("нечетное однозначное число");
        if (a%2 == 0 && 99-a >= 0 && 99-a < 90) System.out.println("четное двузначное число");
        if (a%2 != 0 && 99-a >= 0 && 99-a < 90) System.out.println("нечетное двузначное число");
        if (a%2 == 0 && 999-a >= 0 && 999-a < 900 && a < 1000) System.out.println("четное трехзначное число");
        if (a%2 != 0 && 999-a >= 0 && 999-a < 900 && a < 1000) System.out.println("нечетное трехзначное число");
        if (a < 1 && a > 999){}
    }
}
