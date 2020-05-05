package ru.levelup.hw2;

public class TVset extends Appliances implements IFunctionality {
    public TVset(double p, double w){
        super(p, "Телевизор", w);
    }

    public String turnOn() {
        return "Нажимаем на кнопку 1";
    }

    public String turnOff() {
        return "Нажимаем на красную кнопку";
    }
}
