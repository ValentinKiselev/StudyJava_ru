package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {

        if (s == null)
            return 0;

        int stringLength = 0;

        Set<Character> uniqueString = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (!uniqueString.contains(Character.valueOf(s.charAt(i))))
                uniqueString.add(Character.valueOf(s.charAt(i)));
            else {
                if (stringLength < uniqueString.size())
                    stringLength = uniqueString.size();
                uniqueString.clear();
                i--;
            }
        }
        if (stringLength < uniqueString.size())
            stringLength = uniqueString.size();
        return stringLength;
    }
}
