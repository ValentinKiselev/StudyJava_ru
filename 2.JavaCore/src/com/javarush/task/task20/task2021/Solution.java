package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {

    public static class SubSolution extends Solution {

        public void writeObject(ObjectOutputStream objectOutputStream) throws IOException {

            throw new NotSerializableException();
        }
        public void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException{
            throw new NotSerializableException();
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NotSerializableException {
        FileOutputStream fileOutput = new FileOutputStream("your.file.name");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

            SubSolution subsolution = new SubSolution();
            outputStream.writeObject(subsolution);

            outputStream.close();

            FileInputStream fiStream = new FileInputStream("your.file.name");
            ObjectInputStream objectStream = new ObjectInputStream(fiStream);

            SubSolution loadedObject = (SubSolution) objectStream.readObject();
            fiStream.close();
            objectStream.close();

    }
}
