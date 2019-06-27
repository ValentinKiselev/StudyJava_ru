package com.javarush.task.task19.task1921;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        SimpleDateFormat simpledataformat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);

        Pattern pattern = Pattern.compile("([А-Яа-яA-Za-z\\s\\-]+)\\s([0-9]{1,2}\\s[0-9]{1,2}\\s[0-9]{4})");

        Matcher m;

        Date date = null;

        while (bufferedReader.ready()) {

            String tmp = bufferedReader.readLine();

            m = pattern.matcher(tmp);

            if (m.find()) {

                try {
                    date = simpledataformat.parse(m.group(2).trim());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                PEOPLE.add(new Person(m.group(1).trim(), date));


            }

        }
        bufferedReader.close();
    }
}
