package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-d");
    Date d = datef.parse(reader.readLine());
    SimpleDateFormat datefn = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
    System.out.println(datefn.format(d).toUpperCase());
    }
}
