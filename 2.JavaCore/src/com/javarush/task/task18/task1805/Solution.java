package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String filename = buff.readLine();
        buff.close();
        ArrayList<Integer> bytearray = new ArrayList<Integer>();
        FileInputStream inputStream = new FileInputStream(filename);
        Integer count = 0;
        HashMap<Integer, Integer> keyandValue = new HashMap<Integer, Integer>();

        while (inputStream.available() > 0){
            bytearray.add(inputStream.read());
        }
        inputStream.close();
        for(int i = 0; i<bytearray.size();i++){
            count = 0;
            for(int b = 0; b<bytearray.size();b++) {
                if (bytearray.get(i).equals(bytearray.get(b))) count++;
            }
            keyandValue.put(bytearray.get(i), count);
        }

        Set<Integer> valueset = keyandValue.keySet();
        List<Integer> sortvalues = new ArrayList<>(valueset);
        Collections.sort(sortvalues);
        for(Object n: sortvalues) {
            System.out.print(n+" ");
        }
    }
}
