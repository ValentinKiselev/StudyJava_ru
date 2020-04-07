package com.javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    public LevelLoader(Path levels) {
    }
    public GameObjects getLevel(int level){
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();

        Player player = new Player(2*Model.FIELD_CELL_SIZE/2, 2*Model.FIELD_CELL_SIZE/2);
        boxes.add(new Box(5*Model.FIELD_CELL_SIZE/2,3*Model.FIELD_CELL_SIZE/2));
        walls.add(new Wall(Model.FIELD_CELL_SIZE/2, 5*Model.FIELD_CELL_SIZE/2));
        walls.add(new Wall(4*Model.FIELD_CELL_SIZE/2, 14*Model.FIELD_CELL_SIZE/2));
        homes.add(new Home(7*Model.FIELD_CELL_SIZE/2, 11*Model.FIELD_CELL_SIZE/2));

        GameObjects result = new GameObjects(walls, boxes, homes, player);

        return result;}
}
