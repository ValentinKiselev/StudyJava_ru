package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
private AmigoOutputStream am;
    QuestionFileOutputStream(AmigoOutputStream am){
        this.am = am;
    }

    @Override
    public void flush() throws IOException {
        am.flush();
    }

    @Override
    public void write(int b) throws IOException {
        am.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        am.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        am.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String letter = reader.readLine();
        if(letter.equals("Д")){
            reader.close();
            am.close();

        }
        else {

        }
    }
}

