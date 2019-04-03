package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s = in.readLine();
    in.close();
    FileInputStream buff = new FileInputStream(s);
    while(buff.available() > 0) {
        int bytestring = buff.read();
        char st = (char) bytestring;
        System.out.print(st);
    }
    buff.close();
    }
}