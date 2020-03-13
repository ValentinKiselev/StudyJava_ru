package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

class DepositCommand implements Command{

    @Override
    public void execute() throws InterruptOperationException {
        String code = ConsoleHelper.askCurrencyCode();
        String[] value = ConsoleHelper.getValidTwoDigits(code);
        CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code).addAmount(Integer.parseInt(value[0]), Integer.parseInt(value[1]));
    }
}
