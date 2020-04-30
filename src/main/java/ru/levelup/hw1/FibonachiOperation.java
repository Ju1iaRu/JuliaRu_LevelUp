package ru.levelup.hw1;

public class FibonachiOperation {
    private int num1;

    public FibonachiOperation(int n1) {
        num1 = n1;
    }
    int[] calculate() {
        int[] f = new int[num1];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i < num1; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }



}
