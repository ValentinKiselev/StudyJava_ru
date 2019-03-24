package com.javarush.task.task11.task1123;

public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {

            return new Pair<Integer, Integer>(null, null);
        }
        int[] databuf = inputArray.clone();

        for(int i = databuf.length-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(databuf[j] > databuf[j+1]) {
                    int buf = databuf[j];
                    databuf[j] = databuf[j + 1];
                    databuf[j + 1] = buf;
                }
            }
        }

        return new Pair<Integer, Integer>(databuf[0], databuf[databuf.length-1]);
    }

    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
