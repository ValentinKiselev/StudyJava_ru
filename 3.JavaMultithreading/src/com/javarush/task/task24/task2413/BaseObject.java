package com.javarush.task.task24.task2413;

import static java.lang.Double.max;

public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public abstract void draw(Canvas canvas);

    public abstract void move();

    public boolean isIntersec(BaseObject o){
        if((this.radius - o.radius) <= max(this.radius, o.radius)) return true;
        return false;
    }
}
