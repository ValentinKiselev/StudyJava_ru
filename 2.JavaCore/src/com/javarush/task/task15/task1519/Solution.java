package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String a = reader.readLine();
            if (a.contains("exit")) break;
            try {
            if (a.contains(".")) print(Double.parseDouble(a));
            else if (Integer.parseInt(a) <= 0 || Integer.parseInt(a) >= 128) print(Integer.parseInt(a));
            else if (Short.parseShort(a) > 0 && Short.parseShort(a) < 128) print(Short.parseShort(a));
            }
             catch (NumberFormatException w){
                print(a);
            }

        }
        }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
