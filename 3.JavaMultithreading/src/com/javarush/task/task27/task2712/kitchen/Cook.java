package com.javarush.task.task27.task2712.kitchen;

import java.util.Observable;
import java.util.Observer;

public class Cook implements Observer {
    private String name;
    private Order order;

    public Cook(String name) {
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Start cooking - " + arg.toString());
    }

    @Override
    public String toString() {
        return name;
    }
}
