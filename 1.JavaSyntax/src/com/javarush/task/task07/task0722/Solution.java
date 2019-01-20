package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> lis = new ArrayList<String>();

        for(int r = 0; r > -1; r++) {
            String h = reader.readLine();
            if (h.equals("end"))
                break;
            else
                lis.add(h);
                System.out.println(lis.get(r));
        }

    }
}