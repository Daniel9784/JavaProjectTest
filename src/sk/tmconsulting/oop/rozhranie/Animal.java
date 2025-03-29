package sk.tmconsulting.oop.rozhranie;

public interface Animal {
     void animalSound();
     void run();
     void jump();
    default void showFeet(){
        System.out.println("Toto zviera má 4 nohy.");
    }
}
