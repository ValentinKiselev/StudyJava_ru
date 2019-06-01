package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
    ReadThread treads;
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    try{
        while (true){
        String filename = buf.readLine();
        if(filename.equals("exit")) break;
        treads = new ReadThread(filename);
        treads.start();
        }
    }
    catch (IOException e){

    }
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
        HashMap<Integer, Integer> maxFreqByte = new HashMap<>();

        public void run(){
            FileInputStream streamRead = null;
            try {
                streamRead = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try{
                    while (streamRead.available()>0) {
                    int byteoneof = streamRead.read();
                    if (!maxFreqByte.containsKey(byteoneof)) {
                        maxFreqByte.put(byteoneof, 1);
                    }
                    else maxFreqByte.put(byteoneof, maxFreqByte.get(byteoneof)+1);                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(streamRead!=null) {
                    try {
                        streamRead.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            int max = Collections.max(maxFreqByte.values());

            for(Map.Entry<Integer, Integer> map: maxFreqByte.entrySet()){
                if(map.getValue() == max){
                resultMap.put(fileName, map.getKey());
                }
            }
        }

    }
}
