package com.epam.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Task8 {

    /**
     * Ввести N слов с консоли.
     * Помимо обычных слов, во входной последовательности могут встречаться целые числа (в том числе большие чем Long.MAX_VALUE).
     * Среди них необходимо найти число-палиндром (одинаково читающееся в обоих направлениях).
     * Число, содержащее одну цифру также является палиндромом.
     * Если палиндромов во входной последовательности больше одного - найти второй уникальный из них.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая минимум N слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено найденное число-палиндром.
     * В случае, если не найдено ни одного палиндрома - в поток должно быть выведено "NOT FOUND".
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 15
     * Chapter 11 describes exceptions, chapter 13 describes binary compatibility... chapter 22 presents a syntactic grammar
     * <p>
     * Выходные данные:
     * 22
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numOfWords = scanner.nextInt();

        int palindromesFound = 0;
        String foundPalindrome = null;

        for (int i = 0; i < numOfWords; i++) {
            String currentWord = scanner.next();
            if (isNumber(currentWord) && isPalindrome(currentWord)) {
                if (palindromesFound == 0) {
                    palindromesFound++;
                    foundPalindrome = currentWord;
                } else {
                    System.out.println(currentWord);
                    return;
                }
            }
        }
        System.out.println(palindromesFound == 0 ? "NOT FOUND" : foundPalindrome);

    }

    private static boolean isNumber(String word) {
        return word.matches("[0-9]+");
    }

    private static boolean isPalindrome(String word) {

        Stack<Character> chars = new Stack<>();
        for (int i = 0; i < word.length()/2; i++) {
            chars.push(word.charAt(i));
        }
        for (int i = word.length() - word.length()/2; i < word.length(); i++) {
            if (chars.pop() != word.charAt(i)) {
                return false;
            }
        }
        return true;

    }

}
