package ru.levelup.hw1;


import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.start();
    }

    private void start() {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите операцию сложения (+), вычитания (-), умножения (*), возведения в степень (^), факториал (!) или фибоначчи (f) : ");
        String operation = in.next();

        if (operation.equals("+")) {
            System.out.print("Введите 2 вещественных числа: ");
            double a = in.nextDouble();
            double b = in.nextDouble();

            AdditionOperation op = new AdditionOperation(a, b);
            double result = op.calculate();
            System.out.print("Результат сложения: " + result);
        }
        else if (operation.equals("-")) {
            System.out.print("Введите 2 целых числа: ");
            int a = in.nextInt();
            int b = in.nextInt();

            SubstractOperation op = new SubstractOperation(a, b);
            int result = op.calculate();
            System.out.print("Результат вычитания: "+ result);
        }
        else if (operation.equals("*")) {
            System.out.print("Введите 2 вещественных числа: ");
            double a = in.nextDouble();
            double b = in.nextDouble();

            MultiplicationOperation op = new MultiplicationOperation(a, b);
            double result = op.calculate();
            System.out.print("Результат умножения: "+ result);
        }
        else if (operation.equals("^")) {
            System.out.print("Введите 1 целое число (степень) и 1 вещественное число: ");
            int a = in.nextInt();
            double b = in.nextDouble();

            PowerOperation op = new PowerOperation(a, b);
            double result = op.calculate();
            System.out.print("Результат степени: "+ result);
        }
        else if (operation.equals("!")) {
            System.out.print("Введите целое число: ");
            int a = in.nextInt();

            FactorialOperation op = new FactorialOperation(a);
            double result = op.calculate();
            System.out.print("Результат факториала: "+ result);
        }
        else if (operation.equals("f")) {
            System.out.print("Введите целое число: ");
            int a = in.nextInt();

            FibonachiOperation op = new FibonachiOperation(a);
            int[] result = op.calculate();
            System.out.print("Результат фибоначчи: "+ Arrays.toString(result));

        }
        else {
            System.out.print("Ошибка. Операция не распознана");
        }

        in.close();
    }

}