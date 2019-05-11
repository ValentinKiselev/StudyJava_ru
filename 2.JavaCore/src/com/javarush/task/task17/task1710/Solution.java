package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]){
            case "-c": {

                try {
                    Person nonGrandePerson=null;
                    Date date = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    date = dateFormat.parse(args[3]);
                    if (args[2].equals("м")) {
                        nonGrandePerson = Person.createMale(args[1], date);
                    } else if (args[2].equals("ж")) {
                        nonGrandePerson = Person.createFemale(args[1], date);
                    }
                    else throw new Exception();
                    allPeople.add(nonGrandePerson);
                    System.out.println(allPeople.indexOf(nonGrandePerson));
                } catch (Exception t) {

                }
                break;
            }
            case "-u":
            {
                try{
                    Date date2;
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    date2 = dateFormat.parse(args[4]);
                    if (args[3].equals("м")) {
                        allPeople.set(Integer.parseInt(args[1]),Person.createMale(args[2], date2));
                    } else if (args[3].equals("ж")) {
                        allPeople.set(Integer.parseInt(args[1]),Person.createFemale(args[2], date2));
                    }
                    else throw new Exception();
                }
                catch (Exception t){

                }
                break;
            }
            case "-d":
            {
                try{
                Person nullPerson = allPeople.get(Integer.parseInt(args[1]));
                nullPerson.setBirthDate(null);
                nullPerson.setName(null);
                nullPerson.setSex(null);
                }
                catch (Exception t){

                }
                break;
            }
            case "-i":
            {
                try{
                    Person outPerson = allPeople.get(Integer.parseInt(args[1]));
                    Date date = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
                    String sexsex = "";
                    if(outPerson.getSex()==Sex.MALE) sexsex = "м";
                    else sexsex ="ж";
                    System.out.println(outPerson.getName()+" "+sexsex+" "+dateFormat.format(outPerson.getBirthDate()));
                }
                catch (Exception t){

                }
                break;
            }

        }
    }
}
