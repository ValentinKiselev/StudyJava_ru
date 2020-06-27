package com.javarush.task.task29.task2909.human;

import java.util.Date;

public class Student extends UniversityPerson {
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public int getCourse() {
        return course;
    }

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }
    public String getPosition(){return "Студент";}
    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta) {
        averageGrade += delta;
    }

    public void setCourse(String name, double value){
        if (name.equals("course")) {
                   course = (int) value;
                    return;
        }
    }
    public void setAverageGrade(double value){
                    averageGrade = value;
                   return;
            }

    public void setCourse(int course)
    {
    this.course = course;
    }

    public void setAverageGrade(String name, double value){
        if (name.equals("averageGrade")) {
            averageGrade = value;
            return;
        }
    }
    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }
    public double getAverageGrade() {
        return averageGrade;
    }
}