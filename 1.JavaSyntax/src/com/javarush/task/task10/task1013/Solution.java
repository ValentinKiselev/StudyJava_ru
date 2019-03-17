package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private int age;
        private int stage;
        private boolean hobby;
        private boolean male;
        private String country;
        private String profession;

        public Human(int age){
            this.age = age;
        }
        public Human(int age, int stage){
            this.age = age;
            this.stage = stage;
        }
        public Human(boolean hobby){
            this.hobby = hobby;
        }
        public Human(boolean male, int age){
            this.male = male;
            this.age = age;
        }
        public Human(boolean male, int age, int stage){
            this.male = male;
            this.age = age;
            this.stage = stage;
        }
        public Human(boolean male, int age, int stage, String country){
            this.male = male;
            this.age = age;
            this.stage = stage;
            this.country = country;
        }
        public Human(String country){
            this.country = country;
        }
        public Human(String country, String profession){
            this.country = country;
            this.profession = profession;
        }
        public Human(boolean male, int age, int stage, String country, String profession){
            this.male = male;
            this.age = age;
            this.stage = stage;
            this.country = country;
            this.profession = profession;
        }
        public Human(int age, String country, String profession){
            this.country = country;
            this.profession = profession;
            this.age = age;
        }

    }
}
