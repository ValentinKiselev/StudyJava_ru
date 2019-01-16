package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; j < 5; j++){
        strings.add(reader.readLine());
        }

        String n = strings.get(0);
        int min = n.length();
        for(int i = 0; i < strings.size(); i++){
            String s = strings.get(i);
            int j = s.length();
            if (j <= min) min = j;
        }
        for(int h = 0; h < strings.size(); h++){
            String s = strings.get(h);
            if(s.length() == min) System.out.println(strings.get(h));
            else{}
        }

    }
}
