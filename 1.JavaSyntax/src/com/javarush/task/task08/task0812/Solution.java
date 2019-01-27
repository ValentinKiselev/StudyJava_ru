package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> lis = new ArrayList<Integer>();

        for(int i = 0; i < 10; i++) {
           lis.add(Integer.parseInt(reader.readLine()));
        }
        int count = 1;
        int max = 1;

        for (int i = 0; i < lis.size()-1; i++){

            if (lis.get(i).equals(lis.get(i+1))){
            count++;
            if (count > max) {
                max = count;
            }
            else;
            }
            else count = 1;
            }

        System.out.println(max);
    }

    }
