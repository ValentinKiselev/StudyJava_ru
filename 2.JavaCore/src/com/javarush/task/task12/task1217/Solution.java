package com.javarush.task.task12.task1217;

/* 
Лететь, бежать и плыть
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly{
        void fly(boolean choice);
    }
    public interface CanRun{
        void run(boolean choice);
    }
    public interface CanSwim{
        void swim(boolean choice);
    }

}
