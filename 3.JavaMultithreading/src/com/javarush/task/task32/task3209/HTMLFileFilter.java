package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File pathname) {
        String fileName = pathname.getName().toLowerCase();
        if(pathname.isDirectory() || fileName.endsWith(".html") || fileName.endsWith(".htm")) return true;
        return false;
    }

    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
