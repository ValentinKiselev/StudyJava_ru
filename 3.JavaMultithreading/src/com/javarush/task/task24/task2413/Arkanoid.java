package com.javarush.task.task24.task2413;

import java.util.ArrayList;
import java.util.List;

public class Arkanoid {
    static Arkanoid game;
   private Ball ball;
   private Stand stand;
   private List<Brick> bricks;
   private boolean isGameOver;

    public Ball getBall() {
        return ball;
    }

    public Stand getStand() {
        return stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private  int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void run(){

    }
    public void move(){
        ball.move();
        stand.move();
    }
    public void draw(Canvas canvas)
    {
        for (Brick current : bricks) current.draw(canvas);
        ball.draw(canvas);
        stand.draw(canvas);
    }
    public void checkBricksBump(){
        for(Brick brick: new ArrayList<Brick>(bricks)){
            if(ball.isIntersec(brick)){
                double angle = Math.random() * 360;
                ball.setDirection(angle);
                bricks.remove(brick);
            }
        }
    }
    public void checkStandBump(){
        if(this.ball.isIntersec(stand)){
            double angle = 90 + 20 * (Math.random() - 0.5);
            ball.setDirection(angle);
        }
    }
    public void checkEndGame(){
        if(this.ball.x > height || this.ball.y > height) isGameOver = true;
    }
    public static void main (String[] args){

    }
}
