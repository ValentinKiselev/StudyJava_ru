package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = buff.readLine();
        buff.close();

        FileInputStream in2 = new FileInputStream(filename1);
        byte [] b2 = new byte[in2.available()];
        in2.read(b2);

        String temp = new String(b2);

        String[] temp1 = temp.split("\n");

            for(String n: temp1){
                String temp2 = n.substring(0, n.indexOf(" "));
                if(temp2.equals(args[0])) System.out.println(n);
            }
        in2.close();
    }
}
