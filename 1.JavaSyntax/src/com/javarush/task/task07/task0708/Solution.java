package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int j = 0; j < 5; j++){
            strings.add(reader.readLine());
        }

       int max = 0;
       for(int i = 0; i< strings.size(); i++){
       String s = strings.get(i);
       int j = s.length();
       if (j > max) max = j;
       }
       for(int i = 0; i< strings.size(); i++){
       String s = strings.get(i);
       if(s.length() == max) System.out.println(strings.get(i));
       else{}
       }


    }
}
