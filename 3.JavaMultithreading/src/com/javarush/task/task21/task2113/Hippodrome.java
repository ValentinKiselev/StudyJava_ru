package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    static Hippodrome game;


    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public Hippodrome() {
        this.horses = horses;
    }

    public void run(){

    }

    public void print(){

    }

    public void move(){

    }

    public static void main(String[] args) {
        game = new Hippodrome();
        Horse horse1 = new Horse("Plyashka", 3, 0);
        Horse horse2 = new Horse("Hryashka", 3, 0);
        Horse horse3 = new Horse("Nyashka", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        }
}
