package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String filename = buff.readLine();
        buff.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        while (bufferedReader.ready()){
                    StringBuilder stringBuilder = new StringBuilder(bufferedReader.readLine());
                    System.out.println(stringBuilder.reverse().toString());
        }
        bufferedReader.close();
        }
    }

