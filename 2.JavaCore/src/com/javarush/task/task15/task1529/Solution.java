package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
       reset();
    }

    public static CanFly result;

    public static void reset() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String obj = null;
        try {
            obj = reader.readLine();

        if (obj.equals("helicopter"))result = new Helicopter();
        else if (obj.equals("plane")) {
            int buff = 0;

            buff = Integer.parseInt(reader.readLine());
            result = new Plane(buff);
            reader.close();
        }
            } catch (Exception e) {

            }


    }
}
