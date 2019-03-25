package com.javarush.task.task12.task1210;

/* 
Три метода и максимум
*/

public class Solution {
    static int max;
    static long max1;
    static double max2;

    public static void main(String[] args) {

    }

    public static int max(int t, int h){
        if(t > h) {
            max = t;
        }
        else if(h > t){
            max = h;
        }
        return max;
    }
    public static long max(long t, long h){
        if(t > h) {
            max1 = t;
        }
        else if(h > t){
            max1 = h;
        }
        return max1;
    }
    public static double max(double t, double h){
        if(t > h) {
            max2 = t;
        }
        else if(h > t){
            max2 = h;
        }
        return max2;
    }
}
