package com.w3schools.examples;

// Create a Main class
public class ConstructorMain {
    int x;  // Create a class attribute
    double y;
    String name;
    String lastName;

    // Create a class constructor for the Main class
    public ConstructorMain() {
        x = 5;  // Set the initial value for the class attribute x
        name = "Ján";
        lastName = "Žitniak";
    }

    public ConstructorMain(int x) {

        this.x = x;
    }

    public ConstructorMain(double y) {

        this.y = y;
    }

    public ConstructorMain(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public static void main(String[] args) {
        ConstructorMain myObj = new ConstructorMain(); // Create an object of class Main (This will call the constructor)
        System.out.println(myObj.x); // Print the value of x, the result is 5

        ConstructorMain myObj2 = new ConstructorMain(10);
        System.out.println(myObj2.x); // Print the value of x, the result is 10

        ConstructorMain myObj3 = new ConstructorMain("Jožko", "Mrkvička");
        System.out.println(myObj3.name + " " + myObj3.lastName);
    }
}

// Outputs 5
