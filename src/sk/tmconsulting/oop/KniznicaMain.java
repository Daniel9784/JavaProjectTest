package sk.tmconsulting.oop;

public class KniznicaMain {
    public static void main(String[] args) {
        Kniha kniha1 = new Kniha(); // Vytvorili sme knihu s testovacimi udajmi

        System.out.println("Názov knihy č.1: " + kniha1.nazov);
        System.out.println("Autor knihy č.1: " + kniha1.autor);

        Kniha kniha2 = new Kniha("Harry Potter", 2000, "Rowlingová", 765, "Nejaké vydavateľstvo"); // Vytvarame knihu č.2 do ktorej vlozime hodnoty prostrednictvom overload konstruktora

        System.out.println("Názov knihy č.2: " + kniha2.nazov);
        System.out.println("Autor knihy č.2: " + kniha2.autor);

        Kniha kniha3 = new Kniha(); // Vytvorili sme knihu č.3 s testovacimi udajmi.
        // Naplnili sme atributy (premenne triedy alebo class fields) konkretnymi hodnotami
       kniha3.nazov = "Starec a more";
       kniha3.autor = "Ernet Hemingway";
       kniha3.vydavatelstvo = "Nejaké vydavateľstvo";
       kniha3.pocetStran = 340;
       kniha3.rokVydania = 1958;

        System.out.println("Názov knihy č.3: " + kniha3.nazov);
        System.out.println("Autor knihy č.3: " + kniha3.autor);
    }
}
