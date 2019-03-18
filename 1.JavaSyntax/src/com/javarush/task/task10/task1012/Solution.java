package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

       int[] count = new int[33];
       for(int y = 0; y < count.length; y++){
           count[y] = 0;
       }

       for(int h = 0; h < abcArray.length; h++) {
           for (String s : list) {
               for(int il = 0; il < s.length(); il++) {
                   if (s.charAt(il) == abcArray[h]) count[h]++;
               }
           }
       System.out.println(abcArray[h] + " " + count[h]);
       }


    }

}
