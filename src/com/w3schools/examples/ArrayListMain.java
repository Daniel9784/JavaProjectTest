package com.w3schools.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        cars.add(0, "VW"); // Insert element at the beginning of the list (0)
        System.out.println(cars);

        cars.add("Toyota");
        cars.set(0, "Opel");
        cars.remove(cars.size()-1); // Odstrani poslednu polozku v zozname, resp. dynamickom poli
        System.out.println(cars);

        cars.clear(); // Odstrani vsetky prvy pola
        System.out.println("V cars nemalo byť nič: " + cars);

        //System.out.println("Prvé auto je: " + cars.get(0)); // Nedokazeme sa odvolat na prve auto, lebo uz neexistuje

        System.out.println(); // Prazdny riadok

        ArrayList<Double> desatinneCisla = new ArrayList<Double>();
        desatinneCisla.add(10.1);
        desatinneCisla.add(9.15);
        desatinneCisla.add(7.344343);
        System.out.println(desatinneCisla);


        System.out.println("Vypíšem každé číslo zvlášť: ");
        for (int i = 0; i < desatinneCisla.size(); i++) {
            System.out.println(desatinneCisla.get(i));
        }

        System.out.println();

        System.out.println("Vypíšem každé číslo zvlášť cez foreach");
        for (Double desatinneCislo : desatinneCisla) {
            System.out.println(desatinneCislo);
        }

        System.out.println();

        // Naplnenie ArrayList celymi cislami
        List<Integer> myNumbers = new ArrayList<>();
        myNumbers.add(100);
        myNumbers.add(150);
        myNumbers.add(20);
        myNumbers.add(25);
        Collections.sort(myNumbers);
        for (int number : myNumbers) {
            System.out.println(number);
        }

        Collections.sort(myNumbers, Collections.reverseOrder()); // Zoradi opacnym sposobom
        System.out.println(myNumbers);

    }
}
