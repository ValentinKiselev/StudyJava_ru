package com.javarush.task.task12.task1209;

/* 
Три метода и минимум
*/

public class Solution {
    static int min;
    static long min1;
    static double min2;

    public static void main(String[] args) {

    }

    public static int min(int t, int h){
        if(t < h) {
           min = t;
        }
        else if(h < t){
           min = h;
        }
        return min;
    }
    public static long min(long t, long h){
        if(t < h) {
            min1 = t;
        }
        else if(h < t){
            min1 = h;
        }
        return min1;
    }
    public static double min(double t, double h){
        if(t < h) {
            min2 = t;
        }
        else if(h < t){
            min2 = h;
        }
        return min2;
    }
}
