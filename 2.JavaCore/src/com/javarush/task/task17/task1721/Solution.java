package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static String fileName1;
    public static String fileName2;

    public static void main(String[] args) throws CorruptedDataException{
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        try{
            fileName1 = buff.readLine();
            fileName2 = buff.readLine();
            buff.close();

        }
        catch (IOException h){

        }
        readFiles(fileName1, allLines);
        readFiles(fileName2, forRemoveLines);

        Solution n = new Solution();

        try{
            n.joinData();
        }
        catch (CorruptedDataException l){
            l.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {
        /*boolean triger = false;
        int SizearrayLines = allLines.size();
        int step = 0;
        int count = 0;

        for(String allLines_i: allLines){
            for(String forRemoveLines_i: forRemoveLines){
                if(allLines.get(step).equals(forRemoveLines_i)) count++;

            }
            step++;
            if(count == SizearrayLines) triger = true;
        }

        if(triger) allLines.removeAll(forRemoveLines);

        if(!triger){
            allLines.removeAll(allLines);
            throw new CorruptedDataException();
        }
        */
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else{
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
    public static void readFiles(String string, List<String> list){
        try{
        Scanner scanner = new Scanner(new File(string));
        while(scanner.hasNextLine()){
            list.add(scanner.nextLine());
        }
        }
        catch (FileNotFoundException h){
            h.printStackTrace();
        }
    }
}
