package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a)
    {
        int x = a[0].length;
        int y = a.length;
        int count;
        int yEnd;
        int xEnd;
        int result = 0;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (a[i][j] == 1) {
                    count = i + 1;
                    while (true) {
                        if (count >= y || (a[count][j] == 0 && count < y)) {
                            yEnd = count - 1;
                            break;
                        }
                        count++;
                    }
                    count = j + 1;
                    while (true) {
                        if (count >= x || (a[i][count] == 0 && count < x)) {
                            xEnd = count - 1;
                            break;
                        }
                        count++;
                    }
                    boolean flag = true;
                    for (int p = i; p <= yEnd; p++) {
                        for (int q = j; q <= xEnd; q++) {
                            if (a[p][q] != 1) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag) {

                        for (int p = i; p <= yEnd; p++) {
                            for (int q = j; q <= xEnd; q++) {
                                a[p][q] = 0;
                            }
                        }
                        result++;
                    }
                }
            }
        }
        return result;
    }
}

