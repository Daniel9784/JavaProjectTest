package sk.tmconsulting.oop.rozhranie;

// interface
interface Animal {
    void animalSound(); // interface method (does not have a body)
    void run(); // interface method (does not have a body)
    void jump();
    default void sleep() {
        System.out.println("fuuuu");
    }
}