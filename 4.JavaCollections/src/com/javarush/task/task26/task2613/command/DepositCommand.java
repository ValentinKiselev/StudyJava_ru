package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command{

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.deposit_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        try {
            String code = ConsoleHelper.askCurrencyCode();

            String[] value = ConsoleHelper.getValidTwoDigits(code);
            CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code).addAmount(Integer.parseInt(value[0]), Integer.parseInt(value[1]));
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.parseInt(value[0]) * Integer.parseInt(value[1]), code));
        }
        catch (NumberFormatException e) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}
