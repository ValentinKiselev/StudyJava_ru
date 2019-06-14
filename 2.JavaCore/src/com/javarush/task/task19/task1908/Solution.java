package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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
            String[] sa = s.split(" ");
                for(int i = 0; i < sa.length; i++){
                    try{
                        int w = Integer.parseInt(sa[i]);
                        fileWriter.write(sa[i]+" ");
                    }
                    catch (NumberFormatException e){

                    }
                }
        }

        fileReader.close();
        fileWriter.close();
    }
}
