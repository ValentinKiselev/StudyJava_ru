package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() throws InterruptOperationException {
        String message = "";
        try {
            message = bis.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }
}
