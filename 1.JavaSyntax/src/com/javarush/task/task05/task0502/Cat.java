package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

        public Cat() {
        }
    public Cat(int age, int weight, int strength) {
        this.age = 10;
        this.weight = 10;
        this.strength = 10;
    }
    public boolean fight(Cat anotherCat) {

        if (this.age > anotherCat.age && this.weight > anotherCat.weight && this.strength > anotherCat.strength)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

    }
}
