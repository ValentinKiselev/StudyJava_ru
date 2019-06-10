package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName;
        fileName = reader.readLine();

        FileReader fileReader = new FileReader(fileName);

        int resultAll = 0;

        char[] buf = new char[fileName.length()];

        while (fileReader.ready()) {
            int useless = fileReader.read(buf);
            StringBuilder builder = new StringBuilder();
            builder.append(buf);
            String text = builder.toString();
            String[] arraySplit = text.split("\\W");


            for (int i = 0; i < arraySplit.length; i++) {
                Pattern p = Pattern.compile("^world$");

                Matcher matcher;
                matcher = p.matcher(arraySplit[i]);

                if (matcher.matches()) resultAll++;

            }

        }
        System.out.println(resultAll);
        reader.close();
        fileReader.close();
    }
}


