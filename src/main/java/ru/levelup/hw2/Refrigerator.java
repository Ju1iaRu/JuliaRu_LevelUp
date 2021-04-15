package ru.levelup.hw2;

public class Refrigerator extends Appliances implements IFunctionality {
    public Refrigerator(double p, double w) {
        super(p, "Холодильник", w);
    }

    public String turnOn() {
        return "Нажимаем кнопку вкл";
    }

    public String turnOff() {
        return "Нажимаем кнопку выкл";
    }
}
