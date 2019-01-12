package com.javarush.task.task05.task0504;


/* 
Трикотаж
*/

public class Solution {
    public static void main(String[] args) {
        Cat ca1 = new Cat("Kuc", 1,1,1);
        Cat ca2 = new Cat("Puc", 2,2,2);
        Cat ca3 = new Cat("Cuc", 3,3,3);
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}