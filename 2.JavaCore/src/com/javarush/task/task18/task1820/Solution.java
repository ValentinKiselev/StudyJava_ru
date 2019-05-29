package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = buff.readLine();
        String filename2 = buff.readLine();
        buff.close();

        FileInputStream in1 = new FileInputStream(filename1);
        FileOutputStream ot1 = new FileOutputStream(filename2);

        try {
            ArrayList<String> list = new ArrayList<String>();

            byte[] buf1 = new byte[in1.available()];
            in1.read(buf1);

            String temp = new String(buf1);

            for (String k : temp.split(" ")) {
                float x = Float.parseFloat(k);
                list.add(Math.round(x) + " ");
            }

            for(String j: list){
                ot1.write(j.getBytes());
            }
        }

        finally {
            if(in1!=null) in1.close();
            if(ot1!=null) ot1.close();
        }
    }
}
