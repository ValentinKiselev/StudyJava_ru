package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        char[] chArrays = s.toCharArray();


        for(int l = 0; l < 40; l++){
            for (int i = l; i < s.length(); i++) {
                System.out.print(chArrays[i]);
            }
            System.out.println();
        }


    }

}

