package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    //public static List<String> f1 = new ArrayList<>();
    //public static List<String> f2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String filename1 = reader.readLine();
    String filename2 = reader.readLine();
    reader.close();

    BufferedReader readerf = new BufferedReader(new FileReader(filename1));
    //f1 = readerf.lines().collect(Collectors.toList());// lines() - returns a stream,
        // .collect(Collectors.toList()) - stream to collection List

    BufferedReader readerf2 = new BufferedReader(new FileReader(filename2));
    //f2 = readerf.lines().collect(Collectors.toList());

        ArrayList<String> f1 = new ArrayList<>();
        ArrayList<String> f2 = new ArrayList<>();

        while (readerf.ready()){
            f1.add(readerf.readLine());
        }
        while (readerf2.ready()){
            f2.add(readerf2.readLine());
        }

        for (int i = 0; i<f1.size() && i<f2.size();i++) {
            try {
                if (f1.get(i).equals(f2.get(i))) {
                    lines.add(new LineItem(Type.SAME, f2.get(i)));
                    f1.remove(i);
                    f2.remove(i);
                    i--;
                } else if (!f1.get(i).equals(f2.get(i)) && f2.size() > 1) {
                            if (!f1.get(i).equals(f2.get(i + 1))) {
                            lines.add(new LineItem(Type.REMOVED, f1.get(i)));
                            f1.remove(i);
                            i--;
                            }
                        else if (f1.get(i).equals(f2.get(i + 1))) {
                        lines.add(new LineItem(Type.ADDED, f2.get(i)));
                        f2.remove(i);
                        i--;
                        }

                } else {
                    lines.add(new LineItem(Type.REMOVED, f1.get(i)));
                    f1.remove(i);
                    i--;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                lines.add(new LineItem(Type.REMOVED, f1.get(i)));
                f1.remove(i);
                i--;
            }
        }

        while (!f1.isEmpty()) {
            lines.add(new LineItem(Type.REMOVED, f1.get(0)));
            f1.remove(0);
        }
        while (!f2.isEmpty()) {
            lines.add(new LineItem(Type.ADDED, f2.get(0)));
            f2.remove(0);
        }

        for (LineItem t : lines) {
            System.out.println(t.line +" "+ t.type);
        }
        readerf.close();
        readerf2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
