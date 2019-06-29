package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
        String line;
        while ((line = bufferedReader.readLine())!= null){
            for (String pair : line.split("\\s")){
                Pattern pt = Pattern.compile("(\\d+)|(\\d+)");
                Matcher mt = pt.matcher(pair);
                if (mt.find()){
                    bufferedWriter.write(pair + " ");
                   }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
