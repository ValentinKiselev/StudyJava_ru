package com.javarush.task.task19.task1902;

/* 
Адаптер
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {

    private FileOutputStream fileOutputStream;

    @Override
    public void flush() throws IOException {
    this.fileOutputStream.flush();
    }

    @Override
    public void close() throws IOException {
        this.fileOutputStream.close();
    }

    @Override
    public void writeString(String s) throws IOException {
        this.fileOutputStream.write(s.getBytes());
    }

    public AdapterFileOutputStream (FileOutputStream fileOutputStream){
        this.fileOutputStream = fileOutputStream;
        }

    public static void main(String[] args) {

    }


}

