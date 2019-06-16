package com.javarush.task.task19.task1914;


/*
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream printStream = System.out;

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));

        testString.printSomething();

        String text = bytes.toString();
        System.setOut(printStream);
        //System.out.println(text);
        String s[] = text.split(" ");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[2]);
        String d = s[1];
        String r = s[3];


        String sresult = "";
        if (d.equals("+"))sresult = String.valueOf(a + b);
        else if (d.equals("-"))sresult = String.valueOf(a - b);
        else if (d.equals("*"))sresult = String.valueOf(a * b);


        System.out.println(a+" "+d+" "+b+" "+r+" "+sresult);
        //System.out.println(text.substring(0,text.length()-2)+""+sresult);
        //System.out.println(sresult);
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


