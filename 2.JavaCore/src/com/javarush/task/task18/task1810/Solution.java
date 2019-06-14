package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = null;
        String fileName;
        int count;

        do {
            count = 1000;
            try {
                fileName = buff.readLine();
                inputStream = new FileInputStream(fileName);
                count = inputStream.available();
            } catch (IOException j) {
            }
        }
        while (count >= 1000);
        try {
            inputStream.close();
        } catch (Exception n) {
        }
        try {
            buff.close();
        } catch (IOException k) {
        }
        throw new DownloadException();
    }
        public static class DownloadException extends Exception {

        }
    }

