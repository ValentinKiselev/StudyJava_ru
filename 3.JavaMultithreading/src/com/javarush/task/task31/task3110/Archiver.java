package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите, пожалуйста, путь.");
        String text = null;
        try {
            text = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(text));
        try {
            String name = bufferedReader.readLine();
            zipFileManager.createZip(Paths.get(new URI(name)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();
    }
}
