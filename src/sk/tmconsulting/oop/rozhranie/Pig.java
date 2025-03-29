package sk.tmconsulting.oop.rozhranie;

public class Pig implements Animal{
    @Override
    public void animalSound() {
        System.out.println("The pig says: wee wee");
    }

    @Override
    public void run() {
        System.out.println("Zzz");
    }

    @Override
    public void jump() {
        System.out.println("Jump!");
    }

    public static void main(String[] args) {
        Pig myPig = new Pig();
        myPig.animalSound();
        myPig.run();
        myPig.jump();
        myPig.showFeet();
    }
}
