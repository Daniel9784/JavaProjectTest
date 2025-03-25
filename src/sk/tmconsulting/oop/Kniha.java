package sk.tmconsulting.oop;

public class Kniha {
    String nazov;
    int rokVydania;
    String autor; // Zatial zjednodusujeme, autor bude obsahovat meno a priezvisko
    int pocetStran;
    String vydavatelstvo; // Zatial pouzijeme iba jeho nazov

    public Kniha(String nazov, int rokVydania, String autor, int pocetStran, String vydavatelstvo) {
        this.nazov = nazov;
        this.rokVydania = rokVydania;
        this.autor = autor;
        this.pocetStran = pocetStran;
        this.vydavatelstvo = vydavatelstvo;
    }

    public Kniha() {
        nazov = "Ja, robot";
        autor = "Isaac Asimov";
        rokVydania = 1960;
        pocetStran = 289;
        vydavatelstvo = "Asimov Inc.";
    }
}
