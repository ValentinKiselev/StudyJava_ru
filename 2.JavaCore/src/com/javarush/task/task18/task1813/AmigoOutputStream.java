package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream fileo;

    public AmigoOutputStream(FileOutputStream fileo) throws FileNotFoundException {
        super(fileName);
        this.fileo = fileo;
    }

    @Override
    public void flush() throws IOException {
        fileo.flush();
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileo.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileo.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        fileo.write(b);
    }

    @Override
    public void close() throws IOException {
        fileo.flush();
        byte[] bu = new String("JavaRush © All rights reserved.").getBytes();
        fileo.write(bu);
        fileo.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
