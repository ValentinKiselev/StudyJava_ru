package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.TreeMap;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path folder = Paths.get(args[0]);//папка, путь в args[0]

        System.out.println(folder.getParent().toString() + "\\" +folder.getFileName());

        File sourceFile = new File(args[1]);// файл для записи

        System.out.println(sourceFile.getName());

        File resultFile = new File(sourceFile.getParent() +  "/allFilesContent.txt"); //файл, в который будет переименован результирующий файл

        System.out.println(resultFile.getName());

        TreeMap<String, Path> map = new TreeMap<>();

        System.out.println("create TreeMap");

        System.out.println("#try to rename file");

            FileUtils.renameFile(sourceFile, resultFile);

            System.out.println("rename?");

      Files.walkFileTree(folder, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                System.out.println("escape to method visitFile");

                if (!Files.isDirectory(file) && Files.readAllBytes(file).length<=50){

                    System.out.println("map.put");
                    map.put(file.getFileName().toString(), file);

                }
                return super.visitFile(file, attrs);
            }
        });

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile, true))){

            System.out.println("write data from msp to file:");

            for (Map.Entry<String, Path> entry : map.entrySet()) {

                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); //this statement prints out my keys and values
                BufferedReader reader = new BufferedReader(new FileReader(entry.getValue().toFile()));

                while (reader.ready()) {
                    writer.write(reader.readLine());
                    writer.write(System.lineSeparator());
                }

                reader.close();
                System.out.println("Done");
            }
        }
    }
}
