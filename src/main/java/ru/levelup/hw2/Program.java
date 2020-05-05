package ru.levelup.hw2;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Refrigerator ref = new Refrigerator(1325, 80);
        System.out.println(ref.turnOn());
        System.out.println(ref.getPower());
        System.out.println(ref.getWeight());
        System.out.println("---------");

        Microwave microwave = new Microwave(700, 4.5);
        System.out.println(microwave.turnOn());
        System.out.println(microwave.getPower());
        System.out.println(microwave.getWeight());
        System.out.println("---------");

        TVset tvset = new TVset(240, 12);
        System.out.println(tvset.turnOn());
        System.out.println(tvset.getPower());
        System.out.println(tvset.getWeight());
        System.out.println("---------");

        System.out.println("Сортировка техники по мощности: ");
        Appliances[] apps = {ref, microwave, tvset};
        bubbleSort(apps);
        for(int i = 0; i < apps.length; i++) {
            System.out.println(apps[i].getPower());
        }
        System.out.println("---------");
        System.out.println("Техника, вес которой больше 5 кг: ");
        Appliances[] filteredApps = filterByWeight(5, apps);
        for(int i = 0; i < filteredApps.length; i++) {
            System.out.println(filteredApps[i].getWeight());
        }
    }
    public static void bubbleSort(Appliances[] arr){
        for(int i = arr.length-1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
            if(arr[j].power > arr[j+1].power) {
                Appliances tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
    }
}
    public static Appliances[] filterByWeight(double weight, Appliances[] apps) {
        ArrayList<Appliances> result = new ArrayList<Appliances>();
        for(int i = 0; i < apps.length; i++) {
            if (apps[i].weight > weight) {
                result.add(apps[i]);
            }
        }
        Appliances[] tmp = new Appliances[result.size()];
        tmp = result.toArray(tmp);
        return tmp;
    }
}
