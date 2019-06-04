package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String filename = buf.readLine();
        buf.close();

        if(args.length>0 && args[0].equals("-c")) {
            buf = new BufferedReader(new FileReader(filename));
            Integer maxIndex = 0;

            while (buf.ready()) {
                String onestring = buf.readLine();
                if (!onestring.isEmpty()) {
                    int ind = Integer.parseInt(onestring.substring(0, 8).trim());
                    if (maxIndex == 0 || maxIndex < ind) maxIndex = ind;

                }
            }

            buf.close();

            BufferedWriter bufwriter = new BufferedWriter(new FileWriter(filename, true));
            bufwriter.newLine();
            String sP = String.format("%-8.2f", Double.parseDouble(args[2]));
            bufwriter.write(String.format("%-8d%-30.30s%-8s%-4d", maxIndex + 1, args[1], sP, Integer.parseInt(args[3])));
            bufwriter.close();
        }

    }

}
