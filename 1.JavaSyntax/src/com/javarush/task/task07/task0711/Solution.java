package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; j < 5; j++){
            strings.add(reader.readLine());
        }


        for(int j = 0; j < 13; j++) {
            int i = strings.size();
            String s = strings.get(4);
            strings.remove(4);
            strings.add(0, s);
        }
        for(int y = 0; y < strings.size(); y++){
            System.out.println(strings.get(y));
        }
    }
}
