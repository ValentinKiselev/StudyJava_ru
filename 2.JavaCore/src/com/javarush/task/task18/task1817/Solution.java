package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream readerfile = new FileInputStream(args[0]);

        byte[] sumbyte = new byte[readerfile.available()];
        readerfile.read(sumbyte);

        int sumbyteCount = sumbyte.length;
        int spacebyteCount = 0;
        readerfile.close();

        for(int i = 0; i < sumbyteCount-1; i++){
            char charfile = (char)sumbyte[i];
            if(Character.isWhitespace(charfile)){
            spacebyteCount++;
            }
        }
        double res = (double) spacebyteCount/sumbyteCount*100;
        System.out.format("%.2f", res);

    }
}
