package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int maxSquare(int[][] matrix) {
        int side = 0;

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (x * y == 0) continue;

                if (matrix[y][x] == 1) {
                    matrix[y][x] = Math.min(matrix[y - 1][x], Math.min(matrix[y][x - 1], matrix[y - 1][x - 1])) + 1;
                }

                if (matrix[y][x] > side) {
                    side = matrix[y][x];
                }
            }
        }
        return side * side;
    }
}
