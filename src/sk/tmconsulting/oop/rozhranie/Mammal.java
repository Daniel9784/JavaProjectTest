package sk.tmconsulting.oop.rozhranie;

public interface Mammal {
    default void drinkMilk() {
        System.out.println("Drinks milk");
    }
}