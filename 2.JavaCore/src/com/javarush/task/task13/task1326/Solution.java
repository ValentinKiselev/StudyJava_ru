package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader In = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader Input = new BufferedReader(new InputStreamReader(new FileInputStream(In.readLine())));
        ArrayList<Integer> inlist = new ArrayList<Integer>();

        while (Input.ready()){
        int buff = Integer.parseInt(Input.readLine());
        if(buff % 2 == 0) inlist.add(buff);
        }
        Input.close();
        Collections.sort(inlist);

        for (int i = 0; i < inlist.size(); i++){
            System.out.println(inlist.get(i));
        }

        }
}
