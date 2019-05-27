package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = buff.readLine();
        String filename2 = buff.readLine();
        String filename3 = buff.readLine();
        buff.close();

        FileInputStream in1 = new FileInputStream(filename2);
        FileInputStream in2 = new FileInputStream(filename3);
        FileOutputStream ott1 = new FileOutputStream(filename1);

        try {

            byte[] b1 = new byte[in1.available()];
            int count = in1.read(b1);


            byte[] b2 = new byte[in2.available()];
            int count2 = in2.read(b2);


            ott1.write(b1, 0, count);
            ott1.write(b2, 0, count2);
        }
        finally {

            if(in1 !=null) in1.close();
            if(in2 !=null) in2.close();
            if(ott1 !=null) ott1.close();

        }






    }
}
