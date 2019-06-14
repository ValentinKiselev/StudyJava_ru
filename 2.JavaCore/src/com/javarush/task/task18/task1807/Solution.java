package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String filename = buff.readLine();
        buff.close();
        FileInputStream inputStream = new FileInputStream(filename);
        int count = 0;
        while (inputStream.available()>0){
        if(inputStream.read() == 44) count++;
        }
        inputStream.close();
        System.out.print(count);
    }
}
