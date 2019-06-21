package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        TreeMap<String, Double> map = new TreeMap<String, Double>();
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        while (file.ready()){
            String buff = file.readLine();
            String[] buffarr = buff.split(" ");
            String name = buffarr[0];
            Double sum = Double.parseDouble(buffarr[1]);
                if(map.containsKey(name)){
                    Double res = map.get(name) + sum;
                    map.replace(name, res);
                }
                else {
                    map.put(name, sum);
                }
        }
        file.close();
        for(Map.Entry<String, Double> elmap: map.entrySet()){
            System.out.println(elmap.getKey() + " " +elmap.getValue());
        }
    }
}
