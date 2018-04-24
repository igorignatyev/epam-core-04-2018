package com.epam.homework;

import java.util.Scanner;

public class Task5 {

    /**
     * Ввести N слов с консоли.
     * Найти количество слов, содержащих только символы латинского алфавита, а среди них – количество слов с равным числом гласных и согласных букв.
     *
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено количество слов, состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
     * Количество различных вхождений одной буквы в слове учитывается.
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 5
     * Язык программирования Java is widespread
     *
     * Выходные данные:
     * 2
     */
    public static void main(String[] args) {

        String vowelsArray = "aeiouy";
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int countWordsWithSameNumVowelsAndConsonants = 0;

        for (int i = 0; i < n; i++) {

            String currentWord = scanner.next();
            char currentCharArray[] = currentWord.toCharArray();

            boolean isLatin = true;
            int vowels = 0;
            int consonants = 0;
            for (char c : currentCharArray) {
                if (!((int)c >= 65 && (int)c <= 90 || (int)c >= 97 && (int)c <= 122)) {
                    isLatin = false;
                    break;
                }
                if (vowelsArray.contains((new Character(c)).toString())) {
                    ++vowels;
                } else {
                    ++consonants;
                }
            }

            if (isLatin && vowels == consonants) {
                ++countWordsWithSameNumVowelsAndConsonants;
            }

        }
        System.out.println(countWordsWithSameNumVowelsAndConsonants);
    }
}
