package sk.tmconsulting.oop;

public class Auto {
     String znacka;
     int rokVyroby;

    public Auto(String znacka, int rokVyroby) {
        this.znacka = znacka;
        this.rokVyroby = rokVyroby;
    }
    public Auto() {
        znacka = "Neznáma";
        rokVyroby = 0;
    }


    public void zobrazInfo() {
        System.out.println("\nZnačka: " + znacka);
        System.out.println("Rok výroby: " + rokVyroby );
    }


}

