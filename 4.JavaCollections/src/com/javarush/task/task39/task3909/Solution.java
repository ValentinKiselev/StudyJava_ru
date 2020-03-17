package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isOneEditAway(String first, String second) {
        int lenght1 = first.length();
        int lenght2 = second.length();
        int delta = Math.abs(lenght1 - lenght2);
        if (delta > 1) return false;
        if (first.equals("") && second.equals("")) return true;
        if(first.equals(second)) return true;

        StringBuffer stringBuffer1 = (first.length() >= second.length()) ? new StringBuffer(first) : new StringBuffer(second);
        StringBuffer stringBuffer2 = (first.length() < second.length()) ? new StringBuffer(first) : new StringBuffer(second);

        for (int i = 0; i < stringBuffer2.length(); i++) {
            if (stringBuffer1.charAt(i) != stringBuffer2.charAt(i)) {
                if (delta != 0) {
                    stringBuffer1.deleteCharAt(i);
                } else {
                    stringBuffer1.deleteCharAt(i);
                    stringBuffer2.deleteCharAt(i);
                }
                break;
            }
        }

        if (stringBuffer1.length() != stringBuffer2.length()) stringBuffer1.deleteCharAt(stringBuffer1.length()-1);
        return stringBuffer1.toString().equals(stringBuffer2.toString());
    }
}
