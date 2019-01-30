package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Sallone", df.parse("JUNE 2 1980"));
        map.put("Sllone", df.parse("JUNE 3 1980"));
        map.put("Slone", df.parse("JUNE 4 1980"));
        map.put("Sone", df.parse("JUNE 5 1980"));
        map.put("Sne", df.parse("JUNE 6 1980"));
        map.put("Se", df.parse("JUNE 7 1980"));
        map.put("S", df.parse("JUNE 8 1980"));
        map.put("Stallon", df.parse("JUNE 9 1980"));
        map.put("Stallo", df.parse("JUNE 10 1980"));
        return map;
        //напишите тут ваш код
    }

    @SuppressWarnings("deprecation")
    public static void removeAllSummerPeople(HashMap<String, Date> map) {

        Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Date> pair = it.next();

            if (pair.getValue().getMonth() == 5 || pair.getValue().getMonth() == 6 || pair.getValue().getMonth() == 7) it.remove();
        }

    }

    public static void main(String[] args) {

    }
}
