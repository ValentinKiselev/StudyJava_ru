package com.javarush.task.task08.task0801;

import java.util.Arrays;
import java.util.Set;

/* 
HashSet из растений
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {

        HashSet<String> set = new HashSet<>(Arrays.asList());

        set.add("арбуз");
        set.add("банан");
        set.add("вишня");
        set.add("груша");
        set.add("дыня");
        set.add("ежевика");
        set.add("женьшень");
        set.add("земляника");
        set.add("ирис");
        set.add("картофель");

        for(String text: set){
            System.out.println(text);
        }

    }
}
