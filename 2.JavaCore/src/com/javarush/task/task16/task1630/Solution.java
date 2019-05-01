package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static {
        try{
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            //reader.close();
        }
        catch (IOException h){

        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String fullFileName;
        private String s = "";


        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        public String getFileContent() {

            return s;
        }

        public void run() {

            try {
                FileInputStream fs = new FileInputStream(fullFileName);
                BufferedReader buff = new BufferedReader(new InputStreamReader(fs));
                String sss;

                while ((sss = buff.readLine()) != null) {
                    s += sss + " ";

                }
                fs.close();
                buff.close();
            }
            catch (Exception q) {

            }
        }
    }

}
