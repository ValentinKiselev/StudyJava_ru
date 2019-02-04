package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<String> gf = new ArrayList<String>();
        gf.add(0,"January");
        if (s.equals(gf.get(0))) System.out.println(s+" is the 1 month");
        gf.add(1,"February");
        if (s.equals(gf.get(1))) System.out.println(s+" is the 2 month");
        gf.add(2,"March");
        if (s.equals(gf.get(2))) System.out.println(s+" is the 3 month");
        gf.add(3,"April");
        if (s.equals(gf.get(3))) System.out.println(s+" is the 4 month");
        gf.add(4,"May");
        if (s.equals(gf.get(4))) System.out.println(s+" is the 5 month");
        gf.add(5,"June");
        if (s.equals(gf.get(5))) System.out.println(s+" is the 6 month");
        gf.add(6,"July");
        if (s.equals(gf.get(6))) System.out.println(s+" is the 7 month");
        gf.add(7,"August");
        if (s.equals(gf.get(7))) System.out.println(s+" is the 8 month");
        gf.add(8, "September");
        if (s.equals(gf.get(8))) System.out.println(s+" is the 9 month");
        gf.add(9, "October");
        if (s.equals(gf.get(9))) System.out.println(s+" is the 10 month");
        gf.add(10, "November");
        if (s.equals(gf.get(10))) System.out.println(s+" is the 11 month");
        gf.add(11, "December");
        if (s.equals(gf.get(11))) System.out.println(s+" is the 12 month");

        }
}
