package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; j < 10; j++) {
            strings.add(reader.readLine());
        }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int m1 = 0;
            int m2 = 0;

                for(int l = 0; l < strings.size()-1; l++){
                   if (strings.get(l).length() < min) {
                    min = strings.get(l).length();
                    m1 = l;
                }
                if (strings.get(l).length() > max) {
                    max = strings.get(l).length();
                    m2 = l;
                }

            }


            if (m1 <= m2) System.out.println(strings.get(m1));
            else if (m2 < m1) System.out.println(strings.get(m2));


        }
    }

