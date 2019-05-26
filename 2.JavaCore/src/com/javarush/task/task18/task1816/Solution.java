package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        //if(args.length < 0) {
            FileReader readerfile = new FileReader(args[0]);

            int charbute;
            int count = 0;
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            //char [] alphabet_el = alphabet.toCharArray();

            while ((charbute = readerfile.read()) != -1) {
                    char char0 = (char) charbute;
                    if(Character.isLetter(char0)){
                       if(alphabet.contains(Character.toString(char0)) || alphabet.toUpperCase().contains(Character.toString(char0))){
                           count++;
                       }
                    }
            }
            System.out.println(count);
            readerfile.close();
        //}
    }
}
