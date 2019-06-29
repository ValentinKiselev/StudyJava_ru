package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String filename = buff.readLine();
        buff.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

        String line = bufferedReader.readLine();

        while (line!=null) {
            String[] sb = line.split(" ");
            int count=0;
            for (String d : words) {
                for (String t : sb) if (t.equals(d)) count++;
            }
            if(count!=2){
                line = bufferedReader.readLine();
                continue;
            }
            System.out.println(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}


