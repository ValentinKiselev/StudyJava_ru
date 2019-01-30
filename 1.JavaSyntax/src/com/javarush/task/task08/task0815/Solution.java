package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> NS = new HashMap<String, String>();
        for(int i = 0; i < 10; i++){
            NS.put("s"+i, "n"+i);
        }
        return NS;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int k = 0;
        for (Map.Entry<String, String > pair : map.entrySet()) {
            if (pair.getValue() == name) k++;
            }
        return k;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int k = 0;
        for (Map.Entry<String, String > pair : map.entrySet()) {
            if (pair.getKey() == lastName) k++;
        }
        return k;
    }

    public static void main(String[] args) {

    }
}
