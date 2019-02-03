package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] sh = s.toCharArray();
        if(sh[0] != ' ') sh[0] = Character.toUpperCase(sh[0]);
            for(int i = 0; i < sh.length-1; i++){
                if(sh[i] == ' '& sh[i+1] != ' ') sh[i+1] = Character.toUpperCase(sh[i+1]);
            }
            System.out.println(sh);
        }
}
