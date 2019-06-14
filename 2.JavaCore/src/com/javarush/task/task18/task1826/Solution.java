package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {

    public byte buffer[];
    public String fileText;
    public StringBuilder sb = new StringBuilder();


    public void cript(int v){
        byte[]tempbuf = new byte[buffer.length];
        for(int i = 0; i < buffer.length; i++){
            tempbuf[i] = (byte) (buffer[i]+v);
            sb.append((char)tempbuf[i]);
        }
        fileText = sb.toString();
    }

    public static void main(String[] args) throws IOException {

        String par1 = args[0];
        String par2 = args[1];
        String par3 = args[2];

        Solution sol = new Solution();

        FileInputStream fileInputStream = new FileInputStream(par2);
        try {
            sol.buffer = new byte[fileInputStream.available()];
            fileInputStream.read(sol.buffer);
        }
        finally {
        if(fileInputStream!=null) fileInputStream.close();
        }

        if (par1.equals("-e")) sol.cript(1);
        if (par1.equals("-d")) sol.cript(-1);


        FileOutputStream fileOutputStream = new FileOutputStream(par3);
        try {
            fileOutputStream.write(sol.fileText.getBytes());
        } finally {
            if (fileOutputStream != null) fileOutputStream.close();
        }
    }
}
