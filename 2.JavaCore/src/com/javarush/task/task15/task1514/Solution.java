package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
       labels.put(1.1, "g");
       labels.put(1.2, "g");
       labels.put(1.3, "g");
       labels.put(1.4, "g");
       labels.put(1.5, "g");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
