package sk.tmconsulting.oop.rozhranie;

public class Pig implements Animal, Mammal {
    @Override
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }

    @Override
    public void run() {
        // The body of sleep() is provided here
        System.out.println("Zzz");
    }

    @Override
    public void jump() {
        System.out.println("I jump!");
    }


    public static void main(String[] args) {
        Pig pig1 = new Pig();
        pig1.animalSound();
        pig1.run();
        pig1.jump();
        pig1.sleep();
        pig1.drinkMilk();
    }

}