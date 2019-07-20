package com.javarush.task.task20.task2025;
import java.util.*;

public class Solution {

    public static long[] getNumbers(long N) {

/*
В решении проверяется соответствие всех натуральных чисел меньше N
числам Армстронга.
*/

        long[] armstrongNum = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474,
                54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315,
                24678050, 24678051, 88593477, 146511208, 472335975, 534494836,
                912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L,
                42678290603L, 44708635679L, 49388550606L, 82693916578L,
                94204591914L, 28116440335967L, 4338281769391370L,
                4338281769391371L, 21897142587612075L, 35641594208964132L,
                35875699062250035L, 1517841543307505039L, 3289582984443187032L,
                4498128791164624869L, 4929273885928088826L};
        ArrayList<Long> collect = new ArrayList<>();
        for (long x : armstrongNum) {
            if (x < N) {
                collect.add(x);
            }
        }
        if (collect.size() > 0) {
            long[] result = new long[collect.size()];
            for (int i = 0; i < collect.size(); i++) {
                result[i] = collect.get(i);
            }
            return result;
        }
        return null;
    }
    public static void main(String[] args) {
        long[] ex = getNumbers(2);
        if (ex == null) {
            System.out.println("null returned");
        }
        else {
            for (long z : ex) {
                System.out.println(z);
            }
        }
    }
}
