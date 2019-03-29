package com.javarush.task.task12.task1229;

/* 
Родитель класса CTO
*/

public class Solution {

    public static void main(String[] args) {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public interface Businessman {
        public void workHard();
    }
    public static class Chield implements Businessman{

            public void workHard(){

            }

        }

    public static class CTO extends Chield  implements Businessman{
    }
}
