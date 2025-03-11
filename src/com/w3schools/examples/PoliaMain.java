package com.w3schools.examples;

import java.util.Arrays;

public class PoliaMain {

    public static void vypisPole(int[] ages) {
        //System.out.println(ages); // pole ages nie je tu dostupne
        System.out.println("Vypisujem obsah poľa:");
        System.out.println(Arrays.toString(ages));
        // System.out.println(avg); // premenna avg napriek jej zadefinovaniu v metode main tu nie je dostupna
    }


    public static void main(String[] args) {
        double[] desatinneCisla = {10.3, 8.9, 1, 23, 2};
        System.out.println(Arrays.toString(desatinneCisla));
        System.out.println(desatinneCisla[0]); // Vypise prve cislo z pola
        System.out.println(desatinneCisla[4]); // Vypise posledne cislo z pola
        //System.out.println(desatinneCisla[5]); // Vypise ??? cislo z pola

        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        cars[0] = "Opel"; // Zmenime obsah prveho prvku na iny obsah
        System.out.println(cars[0]); // Now outputs Opel instead of Volvo

        System.out.println();
        System.out.println(cars.length); // Vypise dlzku pola

        System.out.println();
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }

        System.out.println("\n\nVýpis poľa cez for each");

        for (String car : cars) {
            System.out.println(car);
        }

        System.out.println();

        // An array storing different ages
        int[] ages = {20, 22, 18, 35, 48, 26, 87, 70};

        float avg, sum = 0;

        // Get the length of the array
        int length = ages.length;

        // Loop through the elements of the array
        for (int age : ages) {
            sum = sum + age;
            // int year = 2025; // premenna year je platna, resp. viditelna len v ramci cyklu, lebo je tam zadefinovana
        }

        // System.out.println(year); // premenna year nie je tu dostupna

        // Calculate the average by dividing the sum by the length
        avg = sum / length;

        // Print the sum
        System.out.println("The sum age is: " + sum);

        // Print the average
        System.out.println("The average age is: " + avg);

        // Vypis obsah pola prostrednictvom metody vypisPole
        vypisPole(ages);

    }
}
