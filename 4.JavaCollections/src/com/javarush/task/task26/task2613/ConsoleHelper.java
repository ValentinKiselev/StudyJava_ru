package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() throws InterruptOperationException {
        String input = "";
        try {
            input = bis.readLine();
        if(input.equalsIgnoreCase("EXIT")) {
            throw new InterruptOperationException();
        }
        } catch (IOException ioexception) {}
        return input;
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage("Please choice currency code:");
        String code = null;
        while (true) {
            code = readString();
            if (code.length() == 3)
                break;
            else
                writeMessage("Error, please choice again:");

        }
        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {

        writeMessage("Input nominal and amount:");
        String[] input;

        while (true) {
            input = readString().split(" ");
            int nominal = 0;
            int amount = 0;

            try {
                nominal = Integer.parseInt(input[0]);
                amount = Integer.parseInt(input[1]);
            }
            catch (Exception e) {
                writeMessage("Error, please repeat:");
                continue;
            }
            if (nominal <= 0 || amount <= 0 || input.length > 2) {
                writeMessage("Error, please again:");
                continue;
            }
            break;
        }
        return input;
    }
    public static Operation askOperation() throws InterruptOperationException{
        String numcommands = null;
        Operation operation = null;
        while (true){
            try {
                int numcommand = Integer.parseInt(readString());
                operation = Operation.getAllowableOperationByOrdinal(numcommand);
                return operation;
            }
            catch (IllegalArgumentException e){
                continue;
            }
        }
    }

}
