package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int sum = 0;
        while (true){
           String as = bufferedReader.readLine();
           int a = Integer.parseInt(as);
           sum = sum + a;
            if (a == -1)
            break;
        }
        System.out.println(sum);
        }

    }

