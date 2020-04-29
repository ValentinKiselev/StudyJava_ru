package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона

+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber == null) return false;
        return (telNumber.matches("^\\+(\\d[\\-()]?){11}\\d$") || telNumber.matches("^[(\\d]-?(\\d[\\-)]?){8}\\d$"))
                && telNumber.matches("^(\\+)?(\\d)*(\\(\\d{3}\\))?(\\d+-?\\d+-?)?\\d+$");
    }

    public static void main(String[] args) {

    }
}
