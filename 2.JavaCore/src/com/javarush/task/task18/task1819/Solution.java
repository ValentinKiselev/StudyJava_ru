package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = buff.readLine();
        String filename2 = buff.readLine();
        buff.close();

        FileInputStream in1 = new FileInputStream(filename1);
        byte [] b1 = new byte[in1.available()];
        int count = in1.read(b1);
        in1.close();

        FileInputStream in2 = new FileInputStream(filename2);
        byte [] b2 = new byte[in2.available()];
        int count2 = in2.read(b2);
        in2.close();

        FileOutputStream ot1 = new FileOutputStream(filename1);
        ot1.write(b2, 0, count2);
        ot1.write(b1, 0, count);
        ot1.close();




    }
}
