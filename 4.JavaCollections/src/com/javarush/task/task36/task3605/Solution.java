package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeSet<String> treeSet = new TreeSet<>();
        StringWriter stringWriter = new StringWriter();

        while (reader.ready()) {
            stringWriter.write(reader.readLine());
        }

        String ourstring = stringWriter.toString();

        ourstring = ourstring.replaceAll("[\\p{Punct}, \\p{Space}]", "");
        ourstring = ourstring.toLowerCase();

        char[] chars = ourstring.toCharArray();

        for (char ch : chars) {
            treeSet.add(String.valueOf(ch));
        }

        StringBuilder builder = new StringBuilder();

        if (treeSet.size() < 5) {
            for (String strel: treeSet) {
                builder.append(strel);
            }
            System.out.println(builder);
        }
        else {
            for (int i = 0; i < 5; i++) {
                builder.append(treeSet.pollFirst());
            }
            System.out.println(builder);
        }
    }
}
