package com.javarush.task.task24.task2413;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height+2][width+2];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
    public void setPoint(double x, double y, char c){
        if(x < 0 || y < 0 || y >= matrix.length || x >= matrix[0].length) return;
        int rx = (int) Math.round(x);
        int ry = (int) Math.round(y);
        matrix[ry][rx] = c;
    }
    void drawMatrix(double x, double y, int[][] matrix, char c){
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }

}
