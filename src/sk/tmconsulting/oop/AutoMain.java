package sk.tmconsulting.oop;

public class AutoMain {
    public static void main(String[] args) {

        Auto auto1 = new Auto("Mustang", 2023);
        Auto auto2 = new Auto("Toyota", 2015);
        Auto auto3 = new Auto();

        auto1.zobrazInfo();
        auto2.zobrazInfo();
        auto3.zobrazInfo();
    }
}
