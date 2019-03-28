package com.javarush.task.task12.task1219;

/* 
Создаем человека
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }


    abstract public class Human implements CanRun, CanSwim {

    }

    abstract public class Duck implements CanFly, CanSwim, CanRun {

    }

    abstract public class Penguin implements CanSwim, CanRun {

    }

    abstract public class Airplane implements CanRun, CanFly {

    }
}
