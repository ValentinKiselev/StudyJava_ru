package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) return "";
        else {
            return "Your order: "
                    + dishes + " of "
                    + tablet + ", cooking time " + getTotalCookingTime() + "min";
        }
    }

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }
    public int getTotalCookingTime(){
        int sumtime = 0;
        for (Dish d: dishes){
            sumtime = sumtime + d.getDuration();
        }
        return sumtime;
    }
}
