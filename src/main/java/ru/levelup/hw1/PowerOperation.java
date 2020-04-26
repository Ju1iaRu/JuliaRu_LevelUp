package ru.levelup.hw1;

public class PowerOperation {
    public PowerOperation (int n1, double n2) {
        num1 = n1;
        num2 = n2;
    }
    private int num1;
    private double num2;

    double calculate() {
        double result = num2; // число
        for(int i = 1; i < num1; ++i) { // степень
            result = result * num2;
        }
        return result;
    }
}
