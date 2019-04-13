package com.javarush.task.task14.task1419;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.net.MalformedURLException;
/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();
        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
        System.out.println(exceptions.size());
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String s = "sdva";
            Integer i = Integer.parseInt(s);
        } catch (NumberFormatException r) {
            exceptions.add(r);
        }

        try {
            Thread i = new Thread();
            i.sleep(777);

        } catch (InterruptedException fi) {
            exceptions.add(fi);
        }
        try {
            String i = null;
            System.out.println(i);
        } catch (UnsupportedOperationException six) {
            exceptions.add(six);
        }
        catch (NullPointerException se) {
            exceptions.add(se);
        }

        try {
            new Solution().clone();

        } catch (CloneNotSupportedException sq) {
            exceptions.add(sq);
            try {
                FileInputStream f = new FileInputStream("d:/g.txt");

            } catch (FileNotFoundException nn) {
                exceptions.add(nn);
            }
            try {
                int[] nNegArray = new int[-5];
            } catch (NegativeArraySizeException r) {
                exceptions.add(r);
            }
            try {
                Object a[] = new String[4];
                a[0] = new Character('*');
            } catch (ArrayStoreException r) {
                exceptions.add(r);
            }
            try {
                String s = null;
                Object i = new Integer(0);
                s = (String) i;
            } catch (ClassCastException r) {
                exceptions.add(r);
            }
            try {
                String s = "asffvdbnern";
                System.out.println(s.length());
                char cy = s.charAt(0);
                cy = s.charAt(40);
                System.out.println(cy);
            } catch (StringIndexOutOfBoundsException r) {
                exceptions.add(r);
            }
            try {
                throw new IllegalStateException("Fzfd");
            } catch (IllegalStateException r) {
                exceptions.add(r);
            }
            try {
                URL url = new URL("");
            } catch (MalformedURLException r) {
                exceptions.add(r);
            }

        }

    }
}

