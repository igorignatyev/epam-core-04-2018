package com.epam.homework;

import java.util.Scanner;

public class Task15 {

    /**
     * Найти сумму элементов матрицы, расположенных между первым и вторым положительными значениями в каждой строке.
     * В случае, если в строке нет двух положительных элементов - сумма от этой строки полагается равной нулю.
     * Сумма между двумя рядом расположенными элементами также равна нулю.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * Целое число, представляющее вычисленную сумму
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     *  3
     *  1   0   3
     * -1   2   2
     *  1  -1   3
     *
     * Выходные данные:
     * -1
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dimension = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, dimension);

        System.out.println(sumBetweenFirstPositiveElements(matrix));

    }

    private static int[][] readMatrix(Scanner scanner, int dimension) {
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int sumBetweenFirstPositiveElements(int[][] matrix){

        int dimension = matrix[0].length;
        int sum = 0;
        for (int i = 0; i < dimension; i++){
            int currentSum = 0;
            boolean firstPositiveFound = false;
            for (int j = 0; j < dimension; j++) {
                if (matrix[i][j] > 0) {
                    if (firstPositiveFound) {
                        sum += currentSum;
                        break;
                    } else {
                        firstPositiveFound = true;
                    }
                } else {
                    currentSum += matrix[i][j];
                }
            }
        }

        return sum;

    }

}
