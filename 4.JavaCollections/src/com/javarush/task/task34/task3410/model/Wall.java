package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Wall extends CollisionObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.YELLOW);

        int leftUppCornerX = getX() - getWidth() / 2;
        int leftUppCornerY = getY() - getHeight() / 2;

        graphics.drawRect(leftUppCornerX, leftUppCornerY, getWidth(), getHeight());
        graphics.fillRect(leftUppCornerX, leftUppCornerY, getWidth(), getHeight());
    }
}
