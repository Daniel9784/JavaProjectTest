package sk.tmconsulting.oop.enumExample;

import java.util.Scanner;

public class ZadajZnackuAutaVyhodnotimKvalitu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadaj značku vozidla VELKÝMI PÍSMENAMI");
        String zadaneVozidlo = scanner.nextLine();
        ZnackaAuta zadaneVozidloAkoEnum = ZnackaAuta.valueOf(zadaneVozidlo); // Prekonvertujeme String (znacka auta) na enum ZnackaAuta. A to nasledne ideme skontrolovat prostrednictvom prikazu if

        if (zadaneVozidloAkoEnum == ZnackaAuta.VW)
            System.out.println("Kvalita je veľmi dobrá");
        else if (zadaneVozidloAkoEnum == ZnackaAuta.FORD)
            System.out.println("Kvalita je veľmi dobrá");
        else if (zadaneVozidloAkoEnum == ZnackaAuta.HONDA)
            System.out.println("Kvalita je vynikajúca");
        else
            System.out.println("Neviem posúdiť kvalitu");

/*        if (zadaneVozidlo.equals(ZnackaAuta.VW.toString()))
            System.out.println("Kvalita je veľmi dobrá");
        else if (zadaneVozidlo.equals(ZnackaAuta.FORD.toString()))
            System.out.println("Kvalita je veľmi dobrá");
        else if (zadaneVozidlo.equals(ZnackaAuta.HONDA.toString()))
            System.out.println("Vynikajúca");
        else
            System.out.println("Neviem posúdiť kvalitu");*/



    }
}