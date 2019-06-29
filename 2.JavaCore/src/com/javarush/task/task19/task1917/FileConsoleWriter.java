package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }
    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }
    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }
    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter (FileDescriptor fileDescriptor) {
        this.fileWriter = new FileWriter(fileDescriptor);
    }
    public void write(char[] cbuf, int off, int len) throws IOException {
        //char[] buf = Arrays.copyOfRange(cbuf, off, len);
        for(int i = off; i < len+off; i++){
            System.out.print(cbuf[i]);
        }
        //System.out.print(buf.toString());
        this.fileWriter.write(cbuf, off, len);
    }
    public void write(int c) throws IOException {
        System.out.print(c);
        this.fileWriter.write(c);
    }
    public void write(String str) throws IOException {
        System.out.print(str);
        this.fileWriter.write(str);
    }
    public void write(String str, int off, int len) throws IOException {
        System.out.print(str.substring(off, off+len));
        this.fileWriter.write(str, off, len);
    }
    public void write(char[] chars) throws IOException {
        for(int i = 0; i < chars.length; i++){
        System.out.print(chars[i]);
        }
        //System.out.print(chars.toString());
        this.fileWriter.write(chars);
    }
    public void close() throws IOException {
        this.fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
    FileConsoleWriter fileConsoleWriter = new FileConsoleWriter(new File("file1.txt"));

    }
}
