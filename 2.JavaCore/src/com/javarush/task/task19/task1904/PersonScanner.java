package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public interface PersonScanner {

    Person read() throws IOException, ParseException;

    void close() throws IOException;
}
