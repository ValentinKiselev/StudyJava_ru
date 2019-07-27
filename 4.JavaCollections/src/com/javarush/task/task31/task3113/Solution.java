package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Что внутри папки?
*/
public class Solution {
    private static List<Path> DirList = new ArrayList<>();
    private static List<Path> FilesList = new ArrayList<>();
    private static long size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String pathname = buff.readLine();
        buff.close();
        Path path = Paths.get(pathname);
        if (!Files.isDirectory(path)) {
            System.out.println(path.toAbsolutePath() + " - не папка");
        }
        Files.walkFileTree(path, new MyFileVisitor());
        System.out.println("Всего папок - " + (DirList.size()-1));
        System.out.println("Всего файлов - " + (FilesList.size()1));
        System.out.println("Общий размер - " + size);

    }


    public static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            DirList.add(dir);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            FilesList.add(file);
            size += Files.size(file);
            return FileVisitResult.CONTINUE;
        }
    }
}
