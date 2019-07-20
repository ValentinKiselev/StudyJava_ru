package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("D:\\Home\\Downloads\\temp\\FirstSerializeTask.txt");
            InputStream inputStream = new FileInputStream("D:\\Home\\Downloads\\temp\\FirstSerializeTask.txt");

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            System.out.println(ivanov.equals(somePerson));
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter= new PrintWriter(outputStream);
            String AssetsIsEmpty = this.assets.isEmpty()?"Empty":"NotEmpty";
            printWriter.write(AssetsIsEmpty);
            printWriter.write( System.lineSeparator());
            printWriter.write(this.name);
            printWriter.write( System.lineSeparator());

            if(AssetsIsEmpty.equals("NotEmpty")){
                for(Asset as: assets){
                    printWriter.write(as.getName());
                    printWriter.write( System.lineSeparator());
                    printWriter.write(Double.toString(as.getPrice()));
                    printWriter.write( System.lineSeparator());
                }
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String AssetsIsEmpty = bufferedReader.readLine();
            this.name = bufferedReader.readLine();

            Asset assarr = null;

            while (bufferedReader.ready()){
                if(AssetsIsEmpty.equals("NotEmpty")){
                   assarr = new Asset(bufferedReader.readLine(), Double.parseDouble(bufferedReader.readLine()));
                   this.assets.add(assarr);
                }
            }
            bufferedReader.close();
        }
    }
}
