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
        CurrencyManipulator currencyManipulator= CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int summa=summaDeneg(currencyManipulator);
        Map<Integer,Integer> map= new TreeMap(Collections.reverseOrder());
        try {
            map = currencyManipulator.withdrawAmount(summa);
        } catch (NotEnoughMoneyException e) {
            ConsoleHelper.writeMessage("Невозможно выдать запрашиваемую сумму!");
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if (entry.getValue()!=0){ConsoleHelper.writeMessage("\t"+entry.getKey()+" - "+entry.getValue());}
        }

    }
    private int summaDeneg(CurrencyManipulator currencyManipulator) throws InterruptOperationException {
        try {
            ConsoleHelper.writeMessage("Введите сумму:");
            int summa = Integer.parseInt(ConsoleHelper.readString());
            if (!currencyManipulator.isAmountAvailable(summa))
            {
                ConsoleHelper.writeMessage("Дорогой, денег не достаточно!!!");
                summa=summaDeneg(currencyManipulator);
            }


            return summa;

        }catch (NumberFormatException e)
        {
            ConsoleHelper.writeMessage("Сумма неверная!!!");
            return summaDeneg(currencyManipulator);
        }
    }

}

