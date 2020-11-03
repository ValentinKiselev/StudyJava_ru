package com.javarush.task.task35.task3513;

import java.awt.*;

public class Tile {
    int value;

    public Tile(int value) {
        this.value = value;
    }
    public Tile() {
        this.value = 0;
    }
    public boolean isEmpty(){
        return value == 0;
    }
    public Color getFontColor(){
        if(value < 16) return new Color(0x776e65);
        else return new Color(0xf9f6f2);
    }
    public Color getTileColor(){
        int a = 0xff0000;
        switch (value){
            case 0 : a = 0xcdc1b4;
            break;
            case 2 : a = 0xeee4da;
            break;
            case 4 : a = 0xede0c8;
            break;
            case 8 : a = 0xf2b179;
            break;
            case 16 : a = 0xf59563;
            break;
            case 32 : a = 0xf67c5f;
            break;
            case 64 : a = 0xf65e3b;
            break;
            case 128 : a = 0xedcf72;
            break;
            case 256 : a = 0xedcc61;
            break;
            case 512 : a = 0xedc850;
            break;
            case 1024 : a = 0xedc53f;
            break;
            case 2048 : a = 0xedc22e;
            break;
        }
        return new Color(a);
    }
    }

