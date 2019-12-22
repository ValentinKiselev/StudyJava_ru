package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.Human;

public class MaleFactory {
    public Human getPerson(int age) {

        if(age <= KidBoy.MAX_AGE){
            return new KidBoy();
        }
        else if(age > KidBoy.MAX_AGE && age <= TeenBoy.MAX_AGE){
            return new TeenBoy();
        }
        else if(age > TeenBoy.MAX_AGE){
            return new Man();
        }
        return null;
    }
}
