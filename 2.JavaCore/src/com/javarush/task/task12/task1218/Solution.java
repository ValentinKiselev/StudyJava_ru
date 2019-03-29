package com.javarush.task.task12.task1218;

/* 
Есть, летать и двигаться
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanMove {
        public void move();
    }

    public interface CanEat {
        public void eat();
    }

    abstract public class Dog implements CanEat,CanMove {

    }

    abstract public class Duck implements CanMove, CanEat, CanFly{
    }

    abstract public class Car implements CanMove {
    }

    abstract public class Airplane implements CanMove, CanFly {
    }
}
