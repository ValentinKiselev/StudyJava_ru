package com.javarush.task.task18.task1809;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = buff.readLine();
        String filename2 = buff.readLine();
        buff.close();
        FileInputStream inputStream1 = new FileInputStream(filename1);
        FileOutputStream outputStream1 = new FileOutputStream(filename2);

        byte[] buff1 = new byte[inputStream1.available()];
        inputStream1.read(buff1);


            for (int i = buff1.length - 1; i >= 0; i--) {
                outputStream1.write(buff1[i]);
             }

        inputStream1.close();
        outputStream1.close();

    }
}
