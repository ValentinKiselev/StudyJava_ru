package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lis = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; j < 10; j++){
            lis.add(reader.readLine());
        }

        for(int i = 1; i < lis.size(); i++){
        if (lis.get(i-1).length() > lis.get(i).length()){System.out.println(i);}
        else{}

        }

    }
}

