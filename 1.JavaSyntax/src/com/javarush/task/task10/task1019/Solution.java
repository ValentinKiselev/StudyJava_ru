package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        HashMap<String, Integer> result = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int id;
        String name;

        while (true) {
            try {

                id = Integer.parseInt(reader.readLine());
                name = reader.readLine();

               }
            catch (NumberFormatException e){
            break;
            }
            if (name.isEmpty()){
                result.put(" ", id);
                break;
            }
            result.put(name, id);
        }
        for(Map.Entry<String, Integer> pair: result.entrySet()){
            System.out.println(pair.getValue()+ " " + pair.getKey());
        }

        //System.out.println("Id=" + id + " Name=" + name);
    }
}
