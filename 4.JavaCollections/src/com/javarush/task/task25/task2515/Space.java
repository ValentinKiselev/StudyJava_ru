package com.javarush.task.task25.task2515;

import java.util.ArrayList;
import java.util.List;

public class Space {
    private int width;
    private int height;
    private SpaceShip ship;
    private List<Ufo> ufos = new ArrayList<Ufo>();
    private List<Rocket> rockets = new ArrayList<Rocket>();
    private List<Bomb> bombs = new ArrayList<Bomb>();


    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpaceShip getShip() {
        return ship;
    }

    public List<Ufo> getUfos() {
        return ufos;
    }

    public List<Rocket> getRockets() {
        return rockets;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public void setUfos(List<Ufo> ufos) {
        this.ufos = ufos;
    }

    public void setRockets(List<Rocket> rockets) {
        this.rockets = rockets;
    }

    public void setBombs(List<Bomb> bombs) {
        this.bombs = bombs;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }



    public static void main(String[] args) {

    }
    }

