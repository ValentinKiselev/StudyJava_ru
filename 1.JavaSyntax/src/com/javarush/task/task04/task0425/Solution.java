package com.javarush.task.task04.task0425;

/* 
Цель установлена!
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
        if (a>0&&b>0) System.out.println(1);
        if (a<0&&b>0) System.out.println(2);
        if (a<0&&b<0) System.out.println(3);
        if (a>0&&b<0) System.out.println(4);
    }
}
