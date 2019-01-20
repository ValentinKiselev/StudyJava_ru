package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int M;
        ArrayList<String> lis = new ArrayList<String>();
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());

        for (int j = 0; j < N; j++){
            lis.add(reader.readLine());
        }

        for (int j = 0; j < M; j++){
            lis.add(lis.get(0));
            lis.remove(0);
            }

        for (int j = 0; j < N; j++){
            System.out.println(lis.get(j));
            }


    }
}
