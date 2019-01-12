package com.javarush.task.task04.task0424;

/* 
Три числа
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

        if (a-b==0) System.out.println(3);
        if (b-c==0) System.out.println(1);
        if (c-a==0) System.out.println(2);
        if (a != b && b != c && a!=c);

    }
}
