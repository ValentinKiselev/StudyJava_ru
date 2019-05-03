package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t1.printResult();
        t2.printResult();
    }

    public static class Read3Strings extends Thread{
        int count = 0;
        List<String> list1 = new ArrayList<>();
        public void run(){
            try {
                if (Solution.reader.ready()) {
                while (true){
                String h = Solution.reader.readLine();
                list1.add(h);
                if(list1.size() > 2) break;
                }

                }
            }
            catch (IOException g){

            }

        }

        public void printResult() {
            for(int i = 0; i < list1.size(); i++) {
                System.out.print(list1.get(i)+" ");
            }
        }
    }
}
