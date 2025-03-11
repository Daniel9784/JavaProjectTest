package com.w3schools.examples;

public class CyklyMain {
    public static void main(String[] args) {
        for(int i = 0; i<=10; i += 2){
            i++;
            System.out.println(i);
        }
        // Outer loop
        for (int i = 1; i <= 2; i++) {
            System.out.println("Outer: " + i); // Executes 2 times

            // Inner loop
            for (int j = 1; j <= 3; j++) {
                System.out.println(" Inner: " + j); // Executes 6 times (2 * 3)
            }
    }
        String[] automobilky = {"Volvo", "BMW","Ford","Mazda"};
        for (String automobilka:automobilky){
            System.out.println(automobilka);
        }
    }
}
