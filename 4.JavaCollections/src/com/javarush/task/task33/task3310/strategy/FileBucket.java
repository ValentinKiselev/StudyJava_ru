package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    Path path;

    public FileBucket() {
        try{
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public long getFileSize(){
        try{
            return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0l;
    }
    public Entry getEntry(){
        Entry entry = null;
        if (getFileSize() <= 0) return entry;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            entry = (Entry) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return entry;
    }

    public void putEntry(Entry entry){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeObject(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
