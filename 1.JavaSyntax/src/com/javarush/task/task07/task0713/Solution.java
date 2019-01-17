package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> int1 = new ArrayList<Integer>();
        ArrayList<Integer> int3 = new ArrayList<Integer>();
        ArrayList<Integer> int2 = new ArrayList<Integer>();
        ArrayList<Integer> int4 = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < 20; r++) {
            int1.add(Integer.parseInt(reader.readLine()));
        }

        for (int j = 0; j < int1.size(); j++) {
            Integer a = int1.get(j);
            int test = 0;
            if (j == -1) test = 1;
            else if (a % 3 == 0 && a % 2 == 0) {
                int2.add(a);
                int3.add(a);
            }
            else if (a % 3 == 0) int3.add(a);
            else if (a % 2 == 0) int2.add(a);
            else int4.add(a);
           }
        printList(int2);
        printList(int3);
        printList(int4);
    }

    public static void printList(List<Integer> int1) {
        for (int j = 0; j < int1.size(); j++) {
            System.out.println(int1.get(j));
        }
    }
}