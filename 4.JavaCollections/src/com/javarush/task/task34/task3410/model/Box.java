package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);

        int leftUppCornerX = getX() - getWidth() / 2;
        int leftUppCornerY = getY() - getHeight() / 2;

        graphics.drawRect(leftUppCornerX, leftUppCornerY, getWidth(), getHeight());
        graphics.fillRect(leftUppCornerX, leftUppCornerY, getWidth(), getHeight());
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
