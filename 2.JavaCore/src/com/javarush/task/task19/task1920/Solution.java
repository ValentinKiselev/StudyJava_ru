package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
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

        double maxValue = Integer.MIN_VALUE;

        for(double value: map.values()) {
            if(value > maxValue) maxValue = value;
        }

        for(Map.Entry<String, Double> elmap: map.entrySet()){
            if(elmap.getValue().equals(maxValue)) System.out.println(elmap.getKey());
        }
    }
}

