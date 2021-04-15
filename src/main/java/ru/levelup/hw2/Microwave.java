package ru.levelup.hw2;

public class Microwave extends Appliances implements IFunctionality {
    public Microwave(double p, double w){
        super(p, "Микроволновка", w);
    }

    public String turnOn() {
        return "Выставляем таймер на 5 мин";
    }

    public String turnOff() {
        return "Выставляем таймер на 0 мин";
    }
}
