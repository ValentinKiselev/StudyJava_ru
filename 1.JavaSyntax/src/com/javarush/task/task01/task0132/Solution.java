package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int n1 = number/100;
        int n2 = number - n1*100;
        int n3 = n2/10;
        int n4 = n2 - n3*10;
        int n5 = n1 + n3 + n4;
        return n5;
    }
}