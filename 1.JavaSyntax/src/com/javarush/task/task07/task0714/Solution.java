package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; j < 5; j++){
            strings.add(reader.readLine());
        }
        strings.remove(2);
        System.out.println(strings.get(3));
        System.out.println(strings.get(2));
        System.out.println(strings.get(1));
        System.out.println(strings.get(0));
        //cicle?
    }
}


