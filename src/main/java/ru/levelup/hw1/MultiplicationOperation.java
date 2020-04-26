package ru.levelup.hw1;

public class MultiplicationOperation {
    public MultiplicationOperation(double n1, double n2) {
        num1 = n1;
        num2 = n2;
    }
    private double num1;
    private double num2;

    double calculate() {
        return num1 * num2;
    }
}
