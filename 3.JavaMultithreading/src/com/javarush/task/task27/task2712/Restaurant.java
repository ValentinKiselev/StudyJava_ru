package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;

public class Restaurant {
    public static void main(String[] args) throws IOException {
        Tablet tablet = new Tablet(2);
        Cook cook = new Cook("Amigo");
        tablet.addObserver(cook);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        ConsoleHelper.writeMessage("заказ 1 клиента");
        tablet.createOrder();
        ConsoleHelper.writeMessage("заказ 2 клиента");
        tablet.createOrder();
        ConsoleHelper.writeMessage("заказ 3 клиента");
        tablet.createOrder();
        ConsoleHelper.writeMessage("заказ 4 клиента");
        tablet.createOrder();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }

}
