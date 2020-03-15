package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

class WithdrawCommand implements Command{

    @Override
    public void execute() throws InterruptOperationException{
        String currencyCode= ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int summa =summa(currencyManipulator);
        Map<Integer,Integer> map = new TreeMap(Collections.reverseOrder());
        try {
            map = currencyManipulator.withdrawAmount(summa);
        } catch (NotEnoughMoneyException e) {
            ConsoleHelper.writeMessage("Impossible to give out amount");
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if (entry.getValue()!=0){ConsoleHelper.writeMessage("\t"+entry.getKey()+" - "+entry.getValue());}
        }

    }
    private int summa(CurrencyManipulator currencyManipulator) throws InterruptOperationException {
        try {
            ConsoleHelper.writeMessage("Please, insert sum:");
            int summa = Integer.parseInt(ConsoleHelper.readString());
            if (!currencyManipulator.isAmountAvailable(summa))
            {
                ConsoleHelper.writeMessage("Not enough money.");
                summa=summa(currencyManipulator);
            }
            return summa;

        }
        catch (NumberFormatException e)
        {
            ConsoleHelper.writeMessage("Don't correct data");
            return summa(currencyManipulator);
        }
    }

}

