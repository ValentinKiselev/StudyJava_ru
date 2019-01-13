package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String GrandfatherName = reader.readLine();
        Cat catGrandfather = new Cat(GrandfatherName);
        
        String GrandmotherName = reader.readLine();
        Cat catGrandmother = new Cat(GrandmotherName);
        
        String fatherName = reader.readLine();
        Cat catfather = new Cat(fatherName, null, catGrandfather);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catGrandmother, null);
        
        String sonName = reader.readLine();
        Cat catson = new Cat(sonName, catMother, catfather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catfather);

        System.out.println(catGrandfather.toString());
        System.out.println(catGrandmother.toString());
        System.out.println(catfather.toString());
        System.out.println(catMother.toString());
        System.out.println(catson.toString());
        System.out.println(catDaughter.toString());
    }

    public static class Cat {
        private String name;
        private Cat parent;
        private Cat parent1;
        private Cat parent2;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent) {
            this.name = name;
            this.parent = parent;
        }

        Cat(String name, Cat parent1, Cat parent2) {
            this.name = name;
            this.parent1 = parent1;
            this.parent2 = parent2;
        }
        @Override
        public String toString() {
            //if (parent == null)
            //    return "The cat's name is " + name + ", no mother ";
            if (parent1 == null && parent2 == null)
                return "The cat's name is " + name + ", no mother, no father ";
            if (parent1 == null && parent2 != null)
                return "The cat's name is " + name + ", no mother, father is " + parent2.name;
            if (parent1 != null && parent2 == null)
                return "The cat's name is " + name + ", mother is" + parent1.name + ", no father ";
            else
                return "The cat's name is " + name + ", mother is " + parent1.name + ", father is " + parent2.name;
        }
    }

}
