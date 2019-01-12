package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String as = bufferedReader.readLine();
        String bs = bufferedReader.readLine();
        String cs = bufferedReader.readLine();
        int a = Integer.parseInt(as);
        int b = Integer.parseInt(bs);
        int c = Integer.parseInt(cs);

        if (a>b && a<c) System.out.println(a);
        if (a<b && a>c) System.out.println(a);
        if (b>a && b<c) System.out.println(b);
        if (b<a && b>c) System.out.println(b);
        if (c>a && c<b) System.out.println(c);
        if (c<a && c>b) System.out.println(c);

        if (a==b && a==c) System.out.println(a);
        else if (a==b) System.out.println(a);
        else if (a==c) System.out.println(c);
        else if (b==c) System.out.println(b);

    }
}
