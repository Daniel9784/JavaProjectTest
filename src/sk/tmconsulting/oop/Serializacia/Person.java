package sk.tmconsulting.oop.Serializacia;


import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;

    // Konštruktor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Metóda na zobrazenie údajov
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}