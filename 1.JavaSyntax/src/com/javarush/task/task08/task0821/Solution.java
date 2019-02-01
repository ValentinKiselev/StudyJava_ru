package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Sim", "Sims");
        map.put("Sim", "Sims");
        map.put("Simv", "Sims");
        map.put("Simvv", "Sifms");
        map.put("Simvf", "Sifms");
        map.put("Simfv", "Sims");
        map.put("Simve", "Simfs");
        map.put("Simsf", "Simsf");
        map.put("Simvfs", "Sifms");
        map.put("Simqv", "Sfims");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
