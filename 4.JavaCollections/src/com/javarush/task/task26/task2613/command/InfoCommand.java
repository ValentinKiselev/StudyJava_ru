package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

class InfoCommand implements Command  {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.info_en");
    @Override
    public void execute() {
        boolean moneystatus = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        for (CurrencyManipulator current : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (current.hasMoney()) {
                if (current.getTotalAmount() > 0) {
                    ConsoleHelper.writeMessage(current.getCurrencyCode() + " - " + current.getTotalAmount());
                    moneystatus = true;
                }
            }
        }
        if (!moneystatus) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }

}
