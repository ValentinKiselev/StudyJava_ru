package com.javarush.task.task04.task0412;
//package com.javarush.task.task03.task0318;
/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String number = bufferedReader.readLine();
        int Nnumber =  Integer.parseInt(number);
        if(Nnumber > 0){
        Nnumber = Nnumber*2;
        System.out.println(Nnumber);
        }
        if(Nnumber < 0){
            //Nnumber = Nnumber + 1;
            System.out.println(Nnumber + 1);
        }
        if(Nnumber == 0){
            System.out.println(0);
        }


    }

}