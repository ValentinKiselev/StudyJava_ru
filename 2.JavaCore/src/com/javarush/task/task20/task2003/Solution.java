package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Set<String> propertiesKeys;
    InputStream inputStream;
    Properties propert;
    public void fillInPropertiesMap() throws Exception {
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        String ss = fileName.readLine();
        inputStream = new FileInputStream(ss);
        load(inputStream);
        fileName.close();
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        propert = new Properties();
        for (Map.Entry<String, String> pair : properties.entrySet()){
            propert.setProperty(pair.getKey(), pair.getValue());
        }
        propert.store(outputStream,"");

    }

    public void load(InputStream inputStream) throws Exception {
        propert= new Properties();
        propert.load(inputStream);
        propertiesKeys = propert.stringPropertyNames();
        for(String s: propertiesKeys){
            properties.put(s, propert.getProperty(s));
        }
     }

    public static void main(String[] args) throws Exception {
    Solution solution = new Solution();
    solution.fillInPropertiesMap();
    OutputStream outputStream = new FileOutputStream("D:\\Home\\Downloads\\temp\\FirstSerializeTask.txt");
    solution.save(outputStream);
    outputStream.close();
    }
}
