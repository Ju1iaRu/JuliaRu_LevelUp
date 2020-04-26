package ru.levelup.hw1;

public class FactorialOperation {
    public FactorialOperation(int n1) {
        num1 = n1;
    }
    private int num1;

    double calculate() {
        int result = 1;
        for(int i = 1; i <= num1; i++) {
            result = result * i;
        }
        return result;
    }

}
