package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String s = buff.readLine();

        FileInputStream fileInputStream = null;

        try{
                while (true){
                fileInputStream = new FileInputStream(s);
                s = buff.readLine();
                    fileInputStream.close();
        }
           }
        catch (FileNotFoundException k){
            System.out.println(s);

        }

    }
}
