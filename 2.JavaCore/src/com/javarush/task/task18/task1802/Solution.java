package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String filename = buff.readLine();
            buff.close();
            ArrayList<Integer> bytearray = new ArrayList<Integer>();
            FileInputStream inputStream = new FileInputStream(filename);
            while (inputStream.available() > 0){
                bytearray.add(inputStream.read());
            }
            inputStream.close();
            System.out.println(Collections.min(bytearray));

    }
}
