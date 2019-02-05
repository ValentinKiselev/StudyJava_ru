package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Human Pitia = new Human("Pitia", true, 1);
        System.out.println(Pitia.toString());
        Human Kitia = new Human("Kitia", false, 10);
        System.out.println(Kitia.toString());
        Human Kiia = new Human("Kiia", false, 20);
        System.out.println(Kiia.toString());
        ArrayList<Human> cl = new ArrayList<Human>();
        cl.add(Pitia);
        cl.add(Kitia);
        cl.add(Kiia);
        Human Piti = new Human("Piti", true, 40, cl);
        System.out.println(Piti.toString());
        Human Liti = new Human("Liti", false, 30, cl);
        System.out.println(Liti.toString());
        ArrayList<Human> gcl1 = new ArrayList<Human>();
        gcl1.add(Piti);
        ArrayList<Human> gcl2 = new ArrayList<Human>();
        gcl2.add(Liti);
        Human Pit = new Human("Pit", true, 80, gcl1);
        System.out.println(Pit.toString());
        Human Lit = new Human("Lit", false, 80, gcl1);
        System.out.println(Lit.toString());
        Human Git = new Human("Git", true, 80, gcl2);
        System.out.println(Pit.toString());
        Human Hub = new Human("Hub", false, 80, gcl2);
        System.out.println(Lit.toString());
    }

    public static class Human {
       public String name;
       public boolean sex;
       public int age;
       public ArrayList<Human> children = new ArrayList<Human>();

       Human(String name, boolean sex, int age, ArrayList<Human> children){
           this.name = name;
           this.sex = sex;
           this.age = age;
           this.children = children;
       }

        Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;

        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
