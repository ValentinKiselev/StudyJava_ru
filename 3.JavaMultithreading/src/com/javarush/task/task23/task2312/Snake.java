package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;
    private int x;
    private int y;

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public int getX() { return sections.get(0).getX(); }

    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {

    }

    public Snake(int x, int y) {
        this.sections = sections;
        this.isAlive = true;
        sections = new ArrayList<>();
        SnakeSection snakehead = new SnakeSection(x, y);
        sections.add(snakehead);
    }
}
