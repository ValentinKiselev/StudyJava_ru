package com.javarush.task.task14.task1411;

import javax.jws.soap.SOAPBinding;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        while (true)
        {
            String buf = reader.readLine();
            //создаем объект, пункт 2
            if (buf.equals("user")) person = new Person.User();
            else if (buf.equals("loser")) person = new Person.Loser();
            else if (buf.equals("proger")) person = new Person.Proger();
            else if (buf.equals("coder")) person = new Person.Coder();

            if(buf.equals("user") || buf.equals("loser") || buf.equals("coder") || buf.equals("proger")) doWork(person); //вызываем doWork
            if(!buf.equals("user") && !buf.equals("loser") && !buf.equals("coder") && !buf.equals("proger")) break;
        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) ((Person.User) person).live();
        if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();
        if (person instanceof Person.Proger) ((Person.Proger) person).enjoy();
        if (person instanceof Person.Coder) ((Person.Coder) person).writeCode();
    }
}
