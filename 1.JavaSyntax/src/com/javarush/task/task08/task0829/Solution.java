package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // List of addresses

        HashMap<String, String> map = new HashMap<String, String>();

        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) break;
            String family = reader.readLine();
            if (family.isEmpty()) break;

            map.put(city, family);
        }
        String cs = reader.readLine();
        if (!cs.isEmpty()) {
            for (HashMap.Entry<String, String> s : map.entrySet()) {
                if(s.getKey().equals(cs)) System.out.println(s.getValue());
            }
        }
    }
}
