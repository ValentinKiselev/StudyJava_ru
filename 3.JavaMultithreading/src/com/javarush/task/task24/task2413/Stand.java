package com.javarush.task.task24.task2413;

public class Stand extends BaseObject{
    private double speed;
    private double direction;

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }
    public void setDirection(double direction) {
        this.direction = direction;
    }

    public Stand(double x, double y, double radius) {
        super(x, y, radius);
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    @Override
    public void draw(Canvas canvas) {

    }
    public void moveRight()
    {
        direction = 1;
    }
    public void moveLeft()
    {
        direction = -1;
    }

    @Override
    public void move() {
        double dx = speed * direction;
        x = x + dx;
    }
}
