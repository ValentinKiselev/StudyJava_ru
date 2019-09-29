package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> ListOfFiles = new ArrayList<>();

        Stack<File> stack = new Stack<>();

        File DesRoot = new File(root);

        stack.push(DesRoot);

        while (!stack.isEmpty()) {

            File FileChild = stack.pop();

            if (FileChild.isDirectory()) {

                for (File f : FileChild.listFiles()) {
                    stack.push(f);
                }
            }

            else if (FileChild.isFile()) {
                ListOfFiles.add(FileChild.getAbsolutePath());
            }
        }
        return ListOfFiles;
    }

    public static void main(String[] args) throws IOException {
        List<String> fileList = getFileTree("D/");
        for (String s : fileList) {
            System.out.println(s);
        }
    }
}
