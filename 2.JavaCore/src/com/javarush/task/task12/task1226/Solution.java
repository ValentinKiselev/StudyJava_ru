package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {

    public  interface CanFly{
        void fly();
    }
    public interface CanClimb{
        void climb();
    }
    public interface CanRun{
        void run();
    }

    public static void main(String[] args) {

    }

    public class Cat implements CanRun, CanClimb{
        public void run(){
            String j ="run";
        }
        public void climb(){
            String j ="climb";
        }
    }

    public class Dog implements CanRun{
        public void run(){
            String j ="run";
        }
    }

    public class Tiger extends Cat {

    }

    public class Duck implements CanRun, CanFly{
        public void run(){
            String j ="run";
        }
        public void fly(){
            String j ="fly";
        }
    }
}
