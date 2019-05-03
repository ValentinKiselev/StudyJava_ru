package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread testflow = new TestThread();
        testflow.start();
        testflow.interrupt();
    }

    public static class TestThread extends  Thread {

        public void run(){

        }
    }
}