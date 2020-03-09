package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) throws InterruptOperationException {
        Locale.setDefault(Locale.ENGLISH);
        String code = ConsoleHelper.askCurrencyCode();
        String[] digits = ConsoleHelper.getValidTwoDigits(code);
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        cm.addAmount(Integer.parseInt(digits[0]), Integer.parseInt(digits[1]));

    }
}
