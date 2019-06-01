package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        Map<Character, Integer> treemap = new TreeMap<>();
        FileInputStream fileReader = new FileInputStream(args[0]);
        try {
            if (fileReader.available() > 0) {
                byte[] buf = new byte[fileReader.available()];
                fileReader.read(buf);
                for (int i = 0; i < buf.length; i++) {
                    char key = (char) buf[i];
                    treemap.put(key, treemap.getOrDefault(key, 0) + 1);
                }
            }
        }
        finally{
        if (fileReader != null) fileReader.close();
        }

        //catch (FileNotFoundException m) {
        //
       //    }
        for (Map.Entry map : treemap.entrySet()) {
        System.out.println(map.getKey()+" "+map.getValue());
        }
    }
}
