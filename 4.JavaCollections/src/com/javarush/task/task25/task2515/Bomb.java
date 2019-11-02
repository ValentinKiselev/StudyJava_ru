package com.javarush.task.task25.task2515;

public class Bomb extends BaseObject{
 //   public Bomb(double x, double y, double radius) {
 //       super(x, y, radius);
 //   }
    public Bomb(double x, double y)
    {
        super(x, y, 1);
    }
    public void move(){
        y++;
    }
    public void draw(Canvas canvas){
        canvas.setPoint(x,y,'B');
    }
}
