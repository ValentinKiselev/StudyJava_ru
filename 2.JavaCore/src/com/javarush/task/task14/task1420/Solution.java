package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer a = 0, b = 0;

        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());

        if(a <= 0 || b<=0) throw new Exception();

    while (a!=0 && b !=0){
        if(a > b){
            a = a%b;
        }
        else{
            b = b%a;
        }
    }
    System.out.println(a+b);
    }
}
