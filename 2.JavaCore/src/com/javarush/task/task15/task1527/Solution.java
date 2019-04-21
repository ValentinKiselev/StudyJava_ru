package com.javarush.task.task15.task1527;

import java.awt.geom.Arc2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = null;
        try {
            url = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        char[] res = url.toCharArray();

        int begin_ind_char = 0;

        for (int i = 0; i < res.length; i++) {
            if (res[i] == '?') begin_ind_char = i + 1;
        }
        String url_par = url.substring(begin_ind_char);

        String[] params = url_par.split("&");

        Map<String, String> map = new LinkedHashMap<String, String>();

        for (String param : params) {

            String name = param.split("=")[0];

            if (param.contains("=")) {
                String value = param.split("=")[1];
                map.put(name, value);
            } else {
                map.put(name, null);
            }
        }

        for (Map.Entry<String, String> pair : map.entrySet()) {
            String name = pair.getKey();
            System.out.print(name + " ");
        }
        System.out.println("");

        for (Map.Entry<String, String> pair2 : map.entrySet()) {

            String name2 = pair2.getKey();
            String val2 = pair2.getValue();

            if (name2.contains("obj")) {

                try {
                    alert(Double.parseDouble(val2));
                } catch (NumberFormatException a) {
                    alert(val2);
                }
            }
        }

        }




        public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
