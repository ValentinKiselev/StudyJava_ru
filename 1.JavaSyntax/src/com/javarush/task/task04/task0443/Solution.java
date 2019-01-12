package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String name = bufferedReader.readLine();
        String y = bufferedReader.readLine();
        String m = bufferedReader.readLine();
        String d = bufferedReader.readLine();
        int yn = Integer.parseInt(y);
        int mn = Integer.parseInt(m);
        int dn = Integer.parseInt(d);
        System.out.println("Меня зовут " + name + ".");
        System.out.println("Я родился " + dn + "." + mn + "." + yn);
    }
}
