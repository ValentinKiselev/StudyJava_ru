package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static String getQuery(Map<String, String> params) {

        StringBuilder res = new StringBuilder();

        if (params == null || params.isEmpty())
            return res.toString();

        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getKey() == null || pair.getValue() == null)
                continue;
            res.append(pair.getKey()).append(" = '").append(pair.getValue()).append("' and ");
        }

        if (res.length() > 5)
            res.delete(res.length() - 5, res.length());

        return res.toString();
    }
}
