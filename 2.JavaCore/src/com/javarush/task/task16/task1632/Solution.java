package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(new Thread1()));
        threads.add(new Thread(new Thread2()));
        threads.add(new Thread(new Thread3()));
        threads.add(new Thread4());
        threads.add(new Thread(new Thread5()));
    }

    public static void main(String[] args) {
        for(Thread t: threads){
            t.start();
        }

        ((Thread4)threads.get(3)).showWarning();

    }

    public static class Thread1 implements Runnable{
        public void run(){
        while (true){

        }
        }

    }
    public static class Thread2 implements Runnable {
        public void run() {
        try{
            Thread.sleep(1);
        }
        catch (InterruptedException t){
        System.out.println("InterruptedException");
        }
        }
    }

    public static class Thread3 implements Runnable {
        public void run() {
        while (true){
            System.out.println("Ура");
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException g){

            }
        }
        }
    }

    public static class Thread4 extends Thread implements Message {

        private static volatile boolean stoptrigger = false;

        @Override
        public void run() {
            try {
                while (!stoptrigger) {
                Thread.sleep(0);
                }
                //if(!stoptrigger) interrupt();
            }
            catch (InterruptedException k) {}
        }

        @Override
        public void showWarning(){
            stoptrigger = true;
        }

    }
    public static class Thread5 implements Runnable {
        public void run() {
            int n1 = 0;
            int sum = 0;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try{
                while(reader.ready()){
                String s = reader.readLine();
                if(s.equals("N")) break;
                n1 = Integer.parseInt(s);
                sum = sum + n1;
                }
            }
            catch (Exception t){

            }
            System.out.println(sum);
        }
    }

}