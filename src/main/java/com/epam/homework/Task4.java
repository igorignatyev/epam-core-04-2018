package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;

public class Task4 {

    /**
     * Ввести с консоли N слов, состоящих из символов английского алфавита.
     * Найти слово, в котором число различных символов минимально.
     * Символы верхнего и нижнего регистра считать различными.
     * Если таких слов несколько, найти первое из них.
     *
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
     *
     * -------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 4
     * Cake is a lie
     *
     * Выходные данные:
     * a
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String wordWithMinimalNumDiffLetters = scanner.next();                  //assuming the first word to be min
        int minLength = uniqueLetters(wordWithMinimalNumDiffLetters);

        for (int i = 1; i < n; i++){
            String currentWord = scanner.next();
            int uniqueLetters = uniqueLetters(currentWord);
            if (uniqueLetters < minLength){
                minLength = uniqueLetters;
                wordWithMinimalNumDiffLetters = currentWord;
            }
        }

        System.out.println(wordWithMinimalNumDiffLetters);
    }

    private static int uniqueLetters(String word){
        char[] charArray = word.toCharArray();
        HashSet<Character> charsInCurrentWord = new HashSet<>();        //just putting all the chars to the set
        for (char c : charArray){                                       //getting size of the set == number of different letters
            charsInCurrentWord.add(c);                                  //since sets store only unique elements
        }
        return charsInCurrentWord.size();
    }

}
