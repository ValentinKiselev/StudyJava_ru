package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Random random = new Random();

        // digits
        for (int i = 0; i < 8; i++) {
            if(i < 3) byteArrayOutputStream.write(48 + random.nextInt(10));
            else if(i >= 3 && i < 6) byteArrayOutputStream.write(65 + random.nextInt(26));
            else if(i >= 6 && i < 8) byteArrayOutputStream.write(97 + random.nextInt(26));
        }
        return byteArrayOutputStream;
    }
}