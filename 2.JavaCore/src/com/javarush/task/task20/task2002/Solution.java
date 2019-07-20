package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("D:\\Home\\Downloads\\temp\\FirstSerializeTask.txt");
            InputStream inputStream = new FileInputStream("D:\\Home\\Downloads\\temp\\FirstSerializeTask.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {

            BufferedWriter bW = new BufferedWriter(new OutputStreamWriter(outputStream));
            String isUsers = users != null ? "yes" : "no";
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(isUsers);
            writer.flush();
//bW.write(Long.toString(as.getBirthDate().getTime()));
            if(users != null){
                for (User user : users){
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    writer.println(user.getBirthDate().getTime());
                    writer.println(user.isMale());
                    writer.println(user.getCountry().toString());
                }
            }
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String isUsers = bufferedReader.readLine();
//user.setBirthDate(new Date(Long.parseLong(bR.readLine())));
            if(isUsers.equals("yes")){
                while (bufferedReader.ready()){
                    User user = new User();
                    user.setFirstName(bufferedReader.readLine());
                    user.setLastName(bufferedReader.readLine());
                    user.setBirthDate(new Date(Long.parseLong(bufferedReader.readLine())));
                    user.setMale(Boolean.parseBoolean(bufferedReader.readLine()));
                    user.setCountry(User.Country.valueOf(bufferedReader.readLine()));

                    this.users.add(user);

                }

            }
            bufferedReader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
