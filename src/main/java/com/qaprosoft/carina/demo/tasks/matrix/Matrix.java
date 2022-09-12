package com.qaprosoft.carina.demo.tasks.matrix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Matrix {
    private static final Logger LOGGER = LogManager.getLogger(Matrix.class);

    public static void main(String []args) {

        int[][] image = new int[][]{
                {2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 5, 5, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 5, 5, 0, 0, 3, 3, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        List<Rectangle> rectangles = new ArrayList<>();

        int countOfRectangles = 0;
        int columns = image[0].length;
        int rows = image.length;

        printArray(image);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (image[i][j] != 0) {
                    boolean firstOccurrenceFlag = true;
                    Rectangle rectangle = new Rectangle();
                    rectangle.setX1(i);
                    rectangle.setY1(j);
                    Set<Integer> widths = new HashSet<>();
                    int height = 0;
                    int m = i;
                    int n = j;
                    while (image[m][n] != 0) {
                        int width = 0;
                        while (image[m][n] != 0 && n < columns) {
                            image[m][n] = 0;
                            width++;
                            n++;
                        }
                        n = j;
                        if (firstOccurrenceFlag) {
                            rectangle.setWidth(width);
                            widths.add(width);
                            firstOccurrenceFlag = true;
                        }
                        if (!widths.add(width)) {
                            rectangle.setWidth(width);
                            height++;
                            m++;
                        } else {
                            rectangle.setFlag(false);
                            break;
                        }
                    }
                    rectangle.setHeight(height);
                    if (rectangle.isFlag()) {
                        rectangles.add(rectangle);
                        countOfRectangles++;
                    }
                }
            }
        }

        LOGGER.info("\033[1;31m" + "Found " + countOfRectangles + " rectangles." + "\033[0m");

        for (Rectangle rectangle : rectangles) {
            LOGGER.info(rectangle);
        }
    }

    public static void printArray(int[][] image) {
        for (int[] ints : image) {
            for (int j = 0; j < image[0].length; j++) {
                if (ints[j] != 0) {
                    System.out.print("\u001B[34m" + " " + ints[j] + " " + "\033[0m");
                } else {
                    System.out.print(" " + ints[j] + " ");
                }
            }
            System.out.println();
        }
    }
}
