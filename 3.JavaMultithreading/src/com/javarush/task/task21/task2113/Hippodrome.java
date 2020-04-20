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

    public void run() throws InterruptedException {
    for(int i = 0; i < 100; i++) {
        move();
        print();
        Thread.sleep(200);
    }
    }

    public void print(){
        for(Horse horse: getHorses()){
            horse.print();
        }
        for(int i = 0; i < 10; i++) System.out.println();
    }

    public void move(){
        for(Horse horse: getHorses()){
            horse.move();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        Horse horse1 = new Horse("Plyashka", 3, 0);
        Horse horse2 = new Horse("Hryashka", 3, 0);
        Horse horse3 = new Horse("Nyashka", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        }
}
