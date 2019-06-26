package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        List<String> list = new ArrayList<>();
        list = reader.lines().collect(Collectors.toList());
        bufferedReader.close();
        reader.close();
        Pattern p = Pattern.compile("\\d+");

        Matcher matcher;

        for (int i=0;i<list.size();i++){
            String [] strings = list.get(i).split("\\s");
            for (int j=0;j<strings.length;j++){

                matcher = p.matcher(strings[j]);
                while (matcher.find()){
                    if (matcher.matches()){
                        for  ( Map.Entry<Integer,String> m : map.entrySet()){
                            if (Integer.parseInt(strings[j])==m.getKey()){
                                strings[j]= m.getValue();
                                break;
                            }
                        }
                    }
                }
            }
            String lines = "";
            for (int z= 0;z<strings.length;z++){
                lines+=strings[z]+" ";
            }
            list.set(i,lines);
        }
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}