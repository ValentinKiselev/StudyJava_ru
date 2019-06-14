package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Set<String> filenames = new TreeSet();
        Scanner buff = new Scanner(System.in);
        String s = buff.nextLine();
        String[] file = s.split(".part");
        File resultfile = new File(file[0]);

        FileOutputStream outputStream = new FileOutputStream(resultfile);

            while (true){
                if(s.equals("end")) break;
                filenames.add(s);
                s = buff.nextLine();
                }

        buff.close();
        for(String ss: filenames){
        FileInputStream buff2 = new FileInputStream(ss);
        byte[] buffer = new byte[buff2.available()];
        buff2.read(buffer);
        outputStream.write(buffer);
        buff2.close();
        }
        outputStream.close();
    }
}
