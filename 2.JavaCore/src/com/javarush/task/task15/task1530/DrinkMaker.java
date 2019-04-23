package com.javarush.task.task15.task1530;

abstract public class DrinkMaker {
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();
    public void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }
}
