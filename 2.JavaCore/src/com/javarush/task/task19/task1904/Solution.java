package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }

        @Override
        public Person read() throws IOException, ParseException {
            String s = this.fileScanner.nextLine();
            String[] spar = s.split(" ");
            String date1 = spar[3] + " " + spar[4] + " " + spar[5];
            Date date = new SimpleDateFormat("dd MM yyyy").parse(date1);
            return new Person(spar[1],spar[2],spar[0], date);
        }
    }
}
