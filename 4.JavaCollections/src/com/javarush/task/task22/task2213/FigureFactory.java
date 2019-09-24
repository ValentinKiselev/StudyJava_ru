package com.javarush.task.task22.task2213;

public class FigureFactory {
    public static final int[][] massive = {
            {1,1,0},
            {1,0,1},
            {1,0,0}
                  };
    static Figure createRandomFigure(int i, int j){
        return new Figure(1,1,massive);
    }
}
