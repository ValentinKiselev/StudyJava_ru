package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = buf.readLine();
        String filename2 = buf.readLine();
        buf.close();
        FileReader fileReader = new FileReader(filename1);
        FileWriter fileWriter = new FileWriter(filename2);
        int numbyt = 0;
        while (fileReader.ready()){
            int byt = fileReader.read();
            numbyt++;
            if(numbyt % 2 == 0) fileWriter.write(byt);
        }

        fileReader.close();
        fileWriter.close();
    }
}
