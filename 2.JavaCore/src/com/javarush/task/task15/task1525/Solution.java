package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try{
        //BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream(Statics.FILE_NAME)));
        //String buff;
        //while (true){
        //    buff = b.readLine();
        //    lines.add(buff);
        //    if(buff != null) break;
        //}
            File file = new File(Statics.FILE_NAME);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String c = scanner.nextLine();
                lines.add(c);
            }
            //System.out.println(lines);
    }
        catch (FileNotFoundException e){
            System.out.println("Nema failu");
        }
    catch (IOException r){
    }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
