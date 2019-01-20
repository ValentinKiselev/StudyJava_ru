package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human Gi = new Human("Gi", true, 10);
        Human Gu = new Human("Gu", true, 10);
        Human Ga = new Human("Ga", true, 10);
        Human Go = new Human("Go", true, 10);
        Human Li = new Human("Li", true, 3, Go, Ga);
        Human Lu = new Human("Lu", true, 3, Go, Gi);
        Human La = new Human("La", true, 3, Go, Ga);
        Human Lo = new Human("Lo", true, 3, Gi, Ga);
        Human Lol = new Human("Lol", false, 1, Go, Gu);
        System.out.println(Gi.toString());
        System.out.println(Gu.toString());
        System.out.println(Ga.toString());
        System.out.println(Go.toString());
        System.out.println(Li.toString());
        System.out.println(Lu.toString());
        System.out.println(La.toString());
        System.out.println(Lo.toString());
        System.out.println(Lol.toString());
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age){
         this.name = name;
         this.sex = sex;
         this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}