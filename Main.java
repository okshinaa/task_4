package ru.vsu.cs.okshina_v_a;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x = readDoubleNumber();
        int n = readIntNumber();

        double expression1 = calculateExpressionOne(x,n);
        double expression2 = calculateExpressionTwo(x,n);

        writeExpressionValue(expression1,expression2);
    }

    private static double readDoubleNumber(){
        System.out.println("Введите значение переменной x:");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextDouble();
    }

    private static int readIntNumber(){
        System.out.println("Введите значение переменной n:");
        Scanner scanner = new Scanner(System.in);
        int variable = scanner.nextInt();

        if (variable < 0) {
            System.out.println("Данные не корректны, введенное значение меньше 0");
            System.exit(0);
        }

        return variable;
    }

    public static int getFactorial(int factorial) {
        if (factorial <= 1) {
            return 1;
        }
        else {
            return factorial * getFactorial(factorial-1);
        }
    }

    private static double calculateExpressionOne(double x, int n){
        double expression = 0;
        double root = Math.sqrt(Math.abs(x));

        for (int i = 0; i < n; i++){
            double bracket = ((1.0 / getFactorial(i+1)) + root);

            expression += bracket;
        }

        return expression;
    }

    private static double calculateExpressionTwo(double x, int n){
        double expression = 1;

        for (int i = 0; i < n; i++){
            double bracket = (1 + (Math.sin((i+1) * x) / getFactorial(i+1)));

            expression *= bracket;
        }

        return expression;
    }

    private static void writeExpressionValue(double expression1, double expression2){
        System.out.printf("Значение выражения 1 = %.3f",expression1);
        System.out.println();
        System.out.printf("Значение выражения 2 = %.3f",expression2);
    }
}
