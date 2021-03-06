package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Player extends CollisionObject implements Movable {
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        int leftUppCornerX = getX() - getWidth() / 2;
        int leftUppCornerY = getY() - getHeight() / 2;

        graphics.drawOval(leftUppCornerX, leftUppCornerY, getWidth(), getHeight());
        graphics.drawOval(leftUppCornerX, leftUppCornerY, getWidth(), getHeight());
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
