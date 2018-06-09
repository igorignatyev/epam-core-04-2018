package com.epam.homework;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class Task9 {

    /**
     * С консоли вводятся три целых числа A, B, C.
     * Числа являются коэффициентами, задающими квадратное уравнение в общем виде: A*x^2 + B*x + C = 0
     * Необходимо найти корни этого уравнения.
     *
     * Формат входных данных:
     * Строка, содержащая 3 целых числа, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате решения уравнения может быть получено три варианта ответа:
     *
     * NO ROOTS
     * корень уравнения
     * первый корень уравнения, второй корень уравнения
     *
     * В результате выполнения в выходной поток посылается строка, соответствующая найденному решению.
     * Значения корней округляются до 2 знаков после запятой.
     * В качестве десятичного разделителя используется точка.
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 2 7 0
     *
     * Выходные данные:
     * -3.50, 0.00
     *
     *
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 4 4 1
     *
     * Выходные данные:
     * -0.50
     *
     *
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 7 0 35
     *
     * Выходные данные:
     * NO ROOTS
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        double discriminant = b*b - 4*a*c;

        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.UK);
        DecimalFormat rootFormat = new DecimalFormat("#0.00", decimalFormatSymbols);

        switch (Double.compare(discriminant, 0)) {
            case 1:
                double x1 = (-b - Math.sqrt(discriminant))/2/a;
                double x2 = (-b + Math.sqrt(discriminant))/2/a;
                System.out.println(rootFormat.format(x1) + ", " + rootFormat.format(x2));
                break;
            case 0:
                double x = -b/2/a;
                System.out.println(rootFormat.format(x));
                break;
            case -1:
                System.out.println("NO ROOTS");
        }

    }
}
