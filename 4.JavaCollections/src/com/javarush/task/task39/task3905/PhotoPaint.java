package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {

        if (x < 0 || y < 0 || x >= image.length || y >= image[x].length)
            return false;
        if (image[y][x].equals(desiredColor))
            return false;
        else {
            image[y][x] = desiredColor;
            return true;
        }
    }
}
