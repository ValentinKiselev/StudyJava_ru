package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getTokens("level22.lesson13.task01", ".");
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        List<String> stringarray = new ArrayList<String>();

        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            stringarray.add(token);
        }
        String [] res = new String[stringarray.size()];
        res = (String[]) stringarray.toArray(res);
        return res;
    }
}
