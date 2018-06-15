package com.epam.homework;

import java.util.Scanner;
import java.util.Stack;

public class Task14 {

    /**
     * Найти количество элементов самой длинной строго возрастающей подпоследовательности.
     * Оператор отношения можно определить на множестве, включающем более одного элемента.
     * <a href="https://ru.wikipedia.org/wiki/Монотонная_последовательность">Строго возрастающая последовательность</a>
     *
     * Формат входных данных:
     * N (целое число) - количество элементов исходной последовательности (0 < N < 100).
     * N целых чисел - элементы последовательности.
     *
     * Формат выходных данных:
     * Число, отображающее количество элементов на самом большом возрастающем участке последовательности.
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 8
     * 2 1 3 3 4 5 6 5
     *
     * Выходные данные:
     * 4
     *
     *
     *
     * Входные данные:
     * 6
     * 6 5 4 3 2 1
     *
     * Выходные данные:
     * 0
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfElements = scanner.nextInt();
        int[] value = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++){
            value[i] = scanner.nextInt();
        }

        System.out.println(getMaxSubsequenceLength(value));

    }

    private static int getMaxSubsequenceLength(int[] value){

        int maxSubsequenceLength = 0;
        int currentSubsequenceLength = 1;

        for (int i = 0; i < value.length - 1; i++) {
            if (value[i] < value[i + 1]) {
                if (++currentSubsequenceLength > maxSubsequenceLength) {
                    maxSubsequenceLength = currentSubsequenceLength;
                }
            } else {
                currentSubsequenceLength = 1;
            }
        }

        return maxSubsequenceLength;

    }
}
