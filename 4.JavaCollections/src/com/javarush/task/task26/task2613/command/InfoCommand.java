package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

class InfoCommand implements Command  {
    @Override
    public void execute() {
        boolean moneystatus = false;

        for (CurrencyManipulator current : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (current.hasMoney()) {
                if (current.getTotalAmount() > 0) {
                    ConsoleHelper.writeMessage(current.getCurrencyCode() + " - " + current.getTotalAmount());
                    moneystatus = true;
                }
            }
        }
        if (!moneystatus) {
            ConsoleHelper.writeMessage("No money available.");
        }
    }

}
