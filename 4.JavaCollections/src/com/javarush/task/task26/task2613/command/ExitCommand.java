package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        {
            ConsoleHelper.writeMessage("Quit? (y,n):");
            try {
                String s = ConsoleHelper.readString();
                if (s.equalsIgnoreCase("Y")) {
                    ConsoleHelper.writeMessage("Bye");
                }
            } catch (InterruptOperationException e) {
                throw new InterruptOperationException ();
            }
        }
    }
}
