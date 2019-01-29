package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> hsi = new HashSet<Integer>();
        for (int i = 1; i < 21; i++) {
        hsi.add(i);
        }
        return hsi;
        }

    public static HashSet<Integer> removeAllNumbersGreaterThan10(HashSet<Integer> set) {

        Iterator<Integer> nIter = set.iterator();

        while (nIter.hasNext()) {
            Integer nN = nIter.next();
            if(nN > 10){
                nIter.remove();
            }
        }

        return set;

    }

    public static void main(String[] args) {

    }
}
