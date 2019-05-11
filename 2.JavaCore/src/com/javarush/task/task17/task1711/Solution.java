package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]){
            case "-c": {

                synchronized (allPeople) {
                    try {
                        for (int i = 1; i < args.length; i = i + 3) {
                            Person nonGrandePerson = null;
                            Date date = new Date();
                            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                            date = dateFormat.parse(args[i+2]);
                            if (args[i + 1].equals("м")) {
                                nonGrandePerson = Person.createMale(args[i], date);
                            } else if (args[i + 1].equals("ж")) {
                                nonGrandePerson = Person.createFemale(args[i], date);
                            } else throw new Exception();
                            allPeople.add(nonGrandePerson);
                            System.out.println(allPeople.indexOf(nonGrandePerson));
                        }

                    } catch (Exception t) {

                    }
                }
                break;
            }
            case "-u":
            {
                synchronized (allPeople) {
                    try {
                        for (int i = 1; i < args.length; i = i + 4) {
                            Date date2;
                            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                            date2 = dateFormat.parse(args[i+3]);
                            if (args[i+2].equals("м")) {
                                allPeople.set(Integer.parseInt(args[i]), Person.createMale(args[i+1], date2));
                            } else if (args[i+2].equals("ж")) {
                                allPeople.set(Integer.parseInt(args[i]), Person.createFemale(args[i+1], date2));
                            } else throw new Exception();
                        }
                    }
                catch (Exception t) {

                    }
                }
                break;
            }
            case "-d":
            {
                synchronized (allPeople) {
                    try {
                        for (int i = 1; i < args.length; i = i + 1) {
                        Person nullPerson = allPeople.get(Integer.parseInt(args[i]));
                        nullPerson.setBirthDate(null);
                        nullPerson.setName(null);
                        nullPerson.setSex(null);
                    }
                    }
                    catch (Exception t) {

                    }
                }
                break;
            }
            case "-i":
            {
                synchronized (allPeople) {
                    try {
                        for (int i = 1; i < args.length; i = i + 1) {
                            Person outPerson = allPeople.get(Integer.parseInt(args[i]));
                            Date date = new Date();
                            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
                            String sexsex = "";
                            if (outPerson.getSex() == Sex.MALE) sexsex = "м";
                            else sexsex = "ж";
                            System.out.println(outPerson.getName() + " " + sexsex + " " + dateFormat.format(outPerson.getBirthDate()));
                        }
                    } catch (Exception t) {

                    }
                }
                break;
            }

        }
    }
}
