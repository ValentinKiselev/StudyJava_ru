package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
    File file = new File(fileName);
    Properties properties = new Properties();
    try {
        FileInputStream fileInputStream = new FileInputStream(file);
        if (fileName.endsWith(".xml")) {
            properties.loadFromXML(fileInputStream);
        }
        else {properties.load(fileInputStream);}
        fileInputStream.close();
        return properties;
    }
    catch (Exception e){
        return properties;
    }

    }
}
