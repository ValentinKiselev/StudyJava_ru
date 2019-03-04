package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s == null) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<Integer> ind_num = new ArrayList<>();
        ArrayList<Integer> ind_word = new ArrayList<>();

        for(int i = 0; i < array.length; i++){
            if(isNumber(array[i])) ind_num.add(i);
            if(!isNumber(array[i])) ind_word.add(i);
        }

        for(int p = ind_word.size()-1; p > 0; p--) {
            for (int m = 0; m < p; m++) {
                if(isGreaterThan(array[ind_word.get(m)], array[ind_word.get(m+1)]))
                {
                    String bufs = array[ind_word.get(m)];
                    array[ind_word.get(m)] = array[ind_word.get(m+1)];
                    array[ind_word.get(m+1)] = bufs;
                }
            }
        }

        for(int k = ind_num.size()-1; k > 0; k--) {
            for(int l = 0; l < k; l++){
               if(Integer.parseInt(array[ind_num.get(l)]) < Integer.parseInt(array[ind_num.get(l+1)]))
               {
               String bufn = array[ind_num.get(l+1)];
               array[ind_num.get(l+1)] = array[ind_num.get(l)];
               array[ind_num.get(l)] = bufn;
               }
            }
        }

    }
    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
