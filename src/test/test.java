package test;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        while (true) {  // Nekonečný cyklus, kým používateľ nezadá "koniec programu"
            System.out.println("Zadaj slovnú známku (výborný, chválitebný, dobrý, dostatočný, nedostatočný) alebo 'koniec programu' na ukončenie:");

            String slovnaZnamka = scr.nextLine().toLowerCase();  // Konvertovanie na malé písmená pre lepšiu robustnosť

            if (slovnaZnamka.equals("koniec programu")) {
                System.out.println("Program ukončený.");
                break;  // Ukončenie cyklu
            }

            switch (slovnaZnamka) {
                case "výborný":
                    System.out.println(1);
                    break;
                case "chválitebný":
                    System.out.println(2);
                    break;
                case "dobrý":
                    System.out.println(3);
                    break;
                case "dostatočný":
                    System.out.println(4);
                    break;
                case "nedostatočný":
                    System.out.println(5);
                    break;
                default:
                    System.out.println("Chyba: Neplatná známka.");
            }
        }

        scr.close();  // Uzavretie Scanneru po ukončení programu
    }
}
