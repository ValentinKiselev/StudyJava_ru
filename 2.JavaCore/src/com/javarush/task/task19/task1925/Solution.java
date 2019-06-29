package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        String str;
        StringBuilder stringBuilder = new StringBuilder();

        while (reader.ready()) {
            stringBuilder.append(reader.readLine());
            stringBuilder.append(" ");
        }
        str = stringBuilder.toString();
        int count = 0;

        String[] arr = str.split("\\s");

        for (String s : arr) {
            if (s.length() > 6) {
                if (count != 0) {
                    writer.write(",");
                }
                writer.write(s);
                count++;
            }
        }
        reader.close();
        writer.close();
    }
}


