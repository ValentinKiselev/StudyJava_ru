package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arls = new ArrayList<String>();

        while (true) {
            String s = in.readLine();
            arls.add(s);
            if(s.equals("exit")) break;
        }

        FileOutputStream  fout = new FileOutputStream(arls.get(0));
        BufferedWriter buffw = new BufferedWriter(new OutputStreamWriter(fout));
        arls.remove(0);
        for(String ss:arls){
            buffw.write(ss);
            buffw.newLine();
            //buffw.flush();
        }

        buffw.close();

    }
}
