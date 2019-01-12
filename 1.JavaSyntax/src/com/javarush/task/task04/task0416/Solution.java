package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String times = bufferedReader.readLine();
        double time =  Double.parseDouble(times);
        if ((time%5 >= 0.) && (time%5 < 3.))
            System.out.println("зелёный");
        else{}
        if ((time%5 >= 3.) && (time%5 < 4.))
            System.out.println("жёлтый");
        else{}
        if ((time%5 >= 4.) && (time%5 < 5.))
            System.out.println("красный");
        else{}
        //System.out.println(time%5);

    }
}