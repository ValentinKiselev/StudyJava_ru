package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string){

    try {
    String[] subStr = string.split(" ");
    return subStr[1] + " " + subStr[2] + " " + subStr[3] + " " + subStr[4];
    }
    catch (Exception e){
    throw new TooShortStringException();
    }
    }
    public static class TooShortStringException extends RuntimeException {
    }
}
