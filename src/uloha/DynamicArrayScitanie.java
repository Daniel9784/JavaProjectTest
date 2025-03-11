package uloha;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArrayScitanie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> zadaneCisla = new ArrayList<>();
        System.out.println("Zadávajte čísla, ktoré chcete sčítať. Každé číslo oddelte tlačidlom 'Enter'. Stlačte '=' pre výpočet súčtu.");

        while (true) {
            String vstupnaHodnota = scanner.nextLine();

//          Vypíse sucet zadanych cisel pri pouziti znaku '='
            if (vstupnaHodnota.equals("=")) {
                double sucet = 0;
                for (double cisla : zadaneCisla) {
                    sucet = sucet + cisla;
                }
                String vystup = String.format("%.10f", sucet).replace('.', ',');
                System.out.println("Súčet: " + vystup);
                break;
            }

//          Pouzitie Regex pre overenie celych a desatinnych cisel
            if (vstupnaHodnota.matches("-?\\d+([.,]\\d+)?")) {

//          Kedze pri vstupe chceme aby pouzivatel mohol pouzivat pre desatinne cisla aj ciarku aj bodku, tak musime neskor nahradit tu ciarku bodkou aby ju Double.parseDouble() mohol akceptovat.
                vstupnaHodnota = vstupnaHodnota.replace(',', '.');
                zadaneCisla.add(Double.parseDouble(vstupnaHodnota));
            } else {
                System.out.println("Neplatný vstup, skúste znova.");
            }
        }

        scanner.close();
    }
}
