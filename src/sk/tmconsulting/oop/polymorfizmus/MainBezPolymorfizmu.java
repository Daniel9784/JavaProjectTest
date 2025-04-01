package sk.tmconsulting.oop.polymorfizmus;

import java.util.ArrayList;

class Animal2 {
    public void animalSound() {
        System.out.println("The animal makes a sound");
    }
}

class Pig2 {
    public void animalSound() {
        System.out.println("The pig says: wee wee");
    }
}

class Dog2 {
    public void animalSound() {
        System.out.println("The dog says: bow wow");
    }
}

class Main2 {
    public static void main(String[] args) {
        Animal2 myAnimal = new Animal2();  // Create a Animal object
        Pig2 myPig2 = new Pig2();  // Create a Pig object
        Dog2 myDog2 = new Dog2();  // Create a Dog object
        myAnimal.animalSound();
        myPig2.animalSound();
        myDog2.animalSound();

/*        ArrayList<Animal2> animals = new ArrayList<>();
        animals.add(myPig2);
        animals.add(myDog2);*/

    }
}