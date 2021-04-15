package ru.levelup.hw2;

public class Appliances {
    public double power;
    public double weight;
    private String type;

    public Appliances(double p, String t, double w) {
        power = p;
        weight = w;
        type = t;
    }
    public String getPower() {
        return type + " мощностью: " + power;
    }
    public String getWeight() {
        return type + " весит: " + weight;
    }
}
