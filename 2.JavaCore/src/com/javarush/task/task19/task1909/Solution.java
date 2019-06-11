package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = buf.readLine();
        String filename2 = buf.readLine();
        buf.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(filename1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename2));

        while (fileReader.ready()){
            String s = fileReader.readLine();
            fileWriter.write(s.replaceAll("\\.", "!"));
            }

        fileReader.close();
        fileWriter.close();
    }
}