package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

import static com.javarush.task.task26.task2613.command.CommandExecutor.execute;

public class CashMachine {
    public static void main(String[] args) {

        try {
            Locale.setDefault(Locale.ENGLISH);

            Operation askoperation;
            do {
                askoperation = ConsoleHelper.askOperation();
                execute(askoperation);
            }
            while (!Operation.EXIT.equals(askoperation));

        }
        catch (InterruptOperationException e){
            ConsoleHelper.writeMessage("Bye");
        }

    }
}