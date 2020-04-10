package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("E:\\Home\\Downloads\\Java\\Java_learn_projects\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task34\\task3410\\res\\levels.txt"));
    private EventListener eventListener;
    public void setEventListener(EventListener eventListener){this.eventListener = eventListener;}
    public GameObjects getGameObjects() {
        return gameObjects;
    }
    public void restartLevel(int level){
        this.gameObjects = levelLoader.getLevel(level);
    }
    public void restart() {
        restartLevel(currentLevel);
    }
    public void startNextLevel() {
        currentLevel = currentLevel + 1;
        restartLevel(currentLevel);
    }
    public void move(Direction direction){

        Player player = gameObjects.getPlayer();

        if (checkWallCollision(player, direction)) {
            return;
        }
        if (checkBoxCollisionAndMoveIfAvailable(direction)){
            return;
        }

        int sellSize = FIELD_CELL_SIZE;

        switch (direction) {
            case LEFT:
                player.move(-sellSize, 0);
                break;
            case RIGHT:
                player.move(sellSize, 0);
                break;
            case UP:
                player.move(0, -sellSize);
                break;
            case DOWN:
                player.move(0, sellSize);
        }

        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){

        for (Wall wall : gameObjects.getWalls()){

            if(gameObject.isCollision(wall, direction)){
                return true;
            }
        }
        return false;
    }
    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction){

        Player player = gameObjects.getPlayer();

        GameObject stopObject = null;

        for (GameObject gameObject: gameObjects.getAll()){
            if (!(gameObject instanceof Player)&&!(gameObject instanceof Home) && player.isCollision(gameObject, direction)){
                stopObject = gameObject;
            }
        }

        if ((stopObject == null)){
            return false;
        }

        if (stopObject instanceof Box){
            Box stopedBox = (Box)stopObject;
            if (checkWallCollision(stopedBox, direction)){
                return true;
            }
            for (Box box : gameObjects.getBoxes()){
                if(stopedBox.isCollision(box, direction)){
                    return true;
                }
            }
            switch (direction)
            {
                case LEFT:
                    stopedBox.move(-FIELD_CELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(FIELD_CELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -FIELD_CELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, FIELD_CELL_SIZE);
            }
        }
        return false;
    }
    public void checkCompletion(){
        boolean Y = true;

        for(Home home : gameObjects.getHomes()){

            boolean status = false;

            for (Box box: gameObjects.getBoxes()){
                if ((box.getX() == home.getX()) && (box.getY() == home.getY()))
                    status = true;
            }

            if (!status)Y = false;
        }

        if (Y)
            eventListener.levelCompleted(currentLevel);
    }

}
