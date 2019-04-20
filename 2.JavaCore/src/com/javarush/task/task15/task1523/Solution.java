package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    boolean t;
    int y;
    short k;
    public static void main(String[] args) {

    }
    Solution(int v){
        this.y = y;
    }
    public Solution(short j){
        this.k = j;
    }
    private Solution(boolean k){
        this.t = k;
    }
    protected Solution(int y, short o){
        this.y = y;
        this.k = o;
    }
}

