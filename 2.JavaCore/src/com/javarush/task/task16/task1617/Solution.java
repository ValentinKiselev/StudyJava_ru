package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(numSeconds*1000 + 500);
        if(numSeconds < 3.5) clock.interrupt();



    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            String s1 = "Прервано!";
            String s2 = "Марш!";
            String buff = null;
            if(numSeconds < 3.5) buff = s2;
            else if (numSeconds >= 3.5) buff = s1;
            try{
                Thread current = Thread.currentThread();
                while(!current.isInterrupted() && numSeconds > 0) {
                    Thread.sleep(1000);
                    System.out.print(numSeconds+" ");
                    numSeconds--;
                    }
                System.out.println(buff);
                }
            catch (InterruptedException n){

            }
        }
    }
}
