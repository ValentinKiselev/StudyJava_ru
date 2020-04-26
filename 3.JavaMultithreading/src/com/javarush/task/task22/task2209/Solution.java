package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(filename);
        bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()){
            stringBuilder.append(bufferedReader.readLine());
            stringBuilder.append(" ");
        }
        String[] words = stringBuilder.toString().split(" ");

        StringBuilder result = getLine(words);

        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        if (words == null || words.length == 0) return new StringBuilder();

        if ("".equals(words[0]) || words.length == 1) return new StringBuilder(words[0]);

        StringBuilder res = new StringBuilder();
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < words.length; i ++)
            if (!words[i].equals("")) list.add(words[i]);
                    while (!isOK(list)) Collections.shuffle(list);

        for (String s : list)
            res.append(s+ " ");
            res.deleteCharAt(res.length()-1);
        return res;
    }

    public static boolean isOK(ArrayList<String> list)
    {
        for (int i = 0; i < list.size()-1; i++)
        {
            String first = list.get(i);
            String second = list.get(i+1);
            first = first.toLowerCase();
            second =second.toLowerCase();
            if (first.charAt(first.length()-1)!=second.charAt(0))
                return false;
        }
        return true;
    }
}