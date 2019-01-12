package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String number = bufferedReader.readLine();
        int Nnumber =  Integer.parseInt(number);
        if(Nnumber < 1 || Nnumber > 7){
            System.out.println("такого дня недели не существует");
        }
        if(Nnumber == 1){
            System.out.println("понедельник");
        }
        if(Nnumber == 2){
            System.out.println("вторник");
        }
        if(Nnumber == 3){
            System.out.println("среда");
        }
        if(Nnumber == 4){
            System.out.println("четверг");
        }
        if(Nnumber == 5){
            System.out.println("пятница");
        }
        if(Nnumber == 6){
            System.out.println("суббота");
        }
        if(Nnumber == 7){
            System.out.println("воскресенье");
        }
    }
}