package com.javarush.task.task34.task3410.model;

import java.util.HashSet;
import java.util.Set;

public class GameObjects {
    Set<Wall> walls;
    Set<Box> boxes;
    Set<Home> homes;
    Player player;

    public Set<Wall> getWalls() {
        return walls;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }

    public Set<Home> getHomes() {
        return homes;
    }

    public Player getPlayer() {
        return player;
    }

    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<Home> homes, Player player) {
        this.walls = walls;
        this.boxes = boxes;
        this.homes = homes;
        this.player = player;
    }
    public Set<GameObject> getAll(){
        Set<GameObject> gameObjectSet = new HashSet<>();
        gameObjectSet.addAll(getWalls());
        gameObjectSet.addAll(getBoxes());
        gameObjectSet.addAll(getHomes());
        gameObjectSet.add(getPlayer());
        return gameObjectSet;

    }
}
