package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    String number = "123456789012";
    private int pin = 1234;
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");
    @Override
    public void execute() throws InterruptOperationException {
        String cardNumber = "";
        String cardPin = "";

        while (true) {
            ConsoleHelper.writeMessage("Insert card number and pin:");
            cardNumber = ConsoleHelper.readString();
            cardPin = ConsoleHelper.readString();
            if (!cardNumber.matches("^\\d{12}$") || !cardPin.matches("^\\d{4}$")){
                ConsoleHelper.writeMessage("Repeat, please, insert");
                continue;
            }

            if (cardNumber.equals(number) && Integer.parseInt(cardPin) == pin && validCreditCards.containsKey(cardNumber)) {
                ConsoleHelper.writeMessage("Successful verification");
                break;
            }
        }


    }
}
