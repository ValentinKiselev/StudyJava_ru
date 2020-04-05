package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y);
        setHeight(2);
        setWidth(2);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        int leftUppCornerX = getX() - getWidth() / 2;
        int leftUppCornerY = getY() - getHeight() / 2;

        graphics.drawOval(leftUppCornerX, leftUppCornerY, getWidth(), getHeight());
        graphics.drawOval(leftUppCornerX, leftUppCornerY, getWidth(), getHeight());
    }
}
