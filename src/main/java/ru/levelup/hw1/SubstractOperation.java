package ru.levelup.hw1;

public class SubstractOperation {
    private int num1;
    private int num2;

    public SubstractOperation(int n1, int n2) {
        num1 = n1;
        num2 = n2;
    }
    int calculate() {
        return num1 - num2;
    }
}
