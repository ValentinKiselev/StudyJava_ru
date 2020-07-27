package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {

    public class Size{
        public int height;
        public int weight;

        public Size(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

    protected Size size = new Size(3,2);

    private List<Human> children = new ArrayList<>();


    private BloodGroup bloodGroup;

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public String getPosition(){return "Человек";}

    public void addChild(Human children){
        this.children.add(children);
    }
    public void removeChild(Human children){
        this.children.remove(children);
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Human(boolean isSoldier) {
        this.id = nextId;
        nextId++;
    }
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.getHeight() + " Вес: " + size.getWeight());
    }
    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }
    @Override
    public void live() {

    }
}