package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String as = bufferedReader.readLine();
        String N = bufferedReader.readLine();
        int bn =  Integer.parseInt(N);
        int i = 0;
        while(i<bn){
        System.out.println(as);
        i++;}
    }
}
