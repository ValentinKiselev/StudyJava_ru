package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = buff.readLine();
        String filename2 = buff.readLine();
        String filename3 = buff.readLine();
        buff.close();
        FileInputStream inputStream1 = new FileInputStream(filename1);
        FileOutputStream outputStream1 = new FileOutputStream(filename2);
        FileOutputStream outputStream2 = new FileOutputStream(filename3);
        int bytecount = inputStream1.available();
        int bytecount1 = 0;
        if(bytecount % 2 == 0) bytecount1 = bytecount/2;
        else if(bytecount % 2 != 0) bytecount1 = bytecount/2+1;
        int bytecount2 = bytecount - bytecount1;
        byte[] buff1 = new byte[bytecount1];
        byte[] buff2 = new byte[bytecount2];
        while (inputStream1.available()>0)
        {
            int count = inputStream1.read(buff1);
            outputStream1.write(buff1, 0, count);
            int count1 = inputStream1.read(buff2);
            outputStream2.write(buff2, 0, count1);
        }
        inputStream1.close();
        outputStream1.close();
        outputStream2.close();

    }
}
