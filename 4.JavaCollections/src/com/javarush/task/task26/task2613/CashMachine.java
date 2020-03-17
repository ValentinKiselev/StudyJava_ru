package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

import static com.javarush.task.task26.task2613.command.CommandExecutor.execute;

public class CashMachine {
    public static final String RESOURCE_PATH = CashMachine.class.getPackage().getName() + ".resources.";

    public static void main(String[] args) {

        try {
            Locale.setDefault(Locale.ENGLISH);
            CommandExecutor.execute(Operation.LOGIN);
            Operation askoperation;
            do {
                askoperation = ConsoleHelper.askOperation();
                execute(askoperation);
            }
            while (!Operation.EXIT.equals(askoperation));

        }
        catch (InterruptOperationException e){
            ConsoleHelper.printExitMessage();
        }

    }
}