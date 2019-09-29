package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        Map<String,ByteArrayOutputStream> content = new HashMap<>();

        try(ZipInputStream zipIn = new ZipInputStream(new FileInputStream(args[1])))
        {
            ZipEntry entry;

            while ((entry = zipIn.getNextEntry()) !=null){

                ByteArrayOutputStream ba = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int count = 0;

                while ((count = zipIn.read(buf)) !=-1){
                    ba.write(buf,0,count);
                }
                content.put(entry.toString(),ba);
                zipIn.closeEntry();

            }
        }
        try(ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(args[1])))
        {
            String fileName = args[0].substring(args[0].lastIndexOf(File.separator)+1);
            ZipEntry entry = new ZipEntry("new/" +fileName );
            zipOut.putNextEntry(entry);
            Files.copy(Paths.get(args[0]),zipOut);
            zipOut.closeEntry();
            for (Map.Entry<String,ByteArrayOutputStream> pair:content.entrySet())
            {
                entry = new ZipEntry(pair.getKey());
                if(!entry.toString().endsWith(fileName)){
                    zipOut.putNextEntry(entry);
                    zipOut.write(pair.getValue().toByteArray());
                    zipOut.closeEntry();
                }
            }

        }

    }
}
