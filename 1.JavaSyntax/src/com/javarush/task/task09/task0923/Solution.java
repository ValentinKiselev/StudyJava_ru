package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //while (true) {
                String s = reader.readLine();
                char[] CharArray = s.toCharArray();

                ArrayList<Character> vowel = new ArrayList<Character>();
                ArrayList<Character> consonant = new ArrayList<Character>();

                for (int i = 0; i < s.length(); i++) {
                 if (isVowel(CharArray[i]) == true && CharArray[i] != ' ') {
                     vowel.add(CharArray[i]);
                     vowel.add(' ');
                 }
                 if (isVowel(CharArray[i]) == false && CharArray[i] != ' ') {
                     consonant.add(CharArray[i]);
                     consonant.add(' ');
                 }

                }
                for (int j = 0; j < vowel.size()-1; j++) {
                    System.out.print(vowel.get(j));
                    //System.out.print(" ");
                }
                System.out.println(" ");
                for (int h = 0; h < consonant.size()-1; h++) {
                    System.out.print(consonant.get(h));
                    //System.out.print(" ");
                }
                System.out.print(" ");
            //}

        //}
        //catch (Exception e){

        //}
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}