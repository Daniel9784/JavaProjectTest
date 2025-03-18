package uloha;

import java.util.ArrayList;
import java.util.Scanner;

class Kniha {
    String nazov;
    String autor;

    Kniha(String nazov, String autor) {
        this.nazov = nazov;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Kniha: " + nazov + ", Autor: " + autor;
    }
}

public class JednoduchaKniznica {
    private final ArrayList<Kniha> knihy = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        JednoduchaKniznica jednoduchaKniznica = new JednoduchaKniznica();
        jednoduchaKniznica.start();
    }

    public void start() {
        int volba;
        do {
            System.out.println("\n --- Knižnica ---");
            System.out.println("1. Zadaj novú knihu");
            System.out.println("2. Zobraz všetky knihy");
            System.out.println("3. Zobrat konkrétnu knihu (podľa indexu)");
            System.out.println("4. Vymaž konkrétnu knihu (podľa indexu)");
            System.out.println("5. Zobraz počet všetkých kníh");
            System.out.println("6. Vyhľadá knihu podľa názvu knihy alebo podľa autora");
            System.out.println("7. Ukončí program");
            System.out.print("Zadajte číslo voľby");
            volba = scanner.nextInt();
            scanner.nextLine();

            switch (volba) {
                case 1:
                    pridajKnihu();
                    break;
                case 2:
                    zobrazVsetkyKnihy();
                    break;
                case 3:
                    zobrazKnihuPodlaIndexu();
                    break;
                case 4:
                    vymazKnihuPodlaIndexu();
                    break;
                case 5:
                    zobrazPocetKnih();
                    break;
                case 6:
                    vyhladajKnihu();
                    break;
                case 7:
                    System.out.println("Program bol ukončený");
                    break;
                default:
                    System.out.println("Neplatná voľba!");
            }
        } while (volba != 7);
    }


    public void pridajKnihu() {
        System.out.print("Zadaj názov knihy: ");
        String nazov = scanner.nextLine();
        System.out.print("Zadaj autora knihy: ");
        String autor = scanner.nextLine();
        knihy.add(new Kniha(nazov, autor));
        System.out.println("Kniha bola pridaná.");
    }

    public void zobrazVsetkyKnihy() {
        if (knihy.isEmpty()) {
            System.out.println("Knižnica je prázdna.");
        } else {
            int index = 0;
            for (Kniha kniha : knihy) {
                System.out.println(index + ": " + kniha);
                index++;
            }
        }
    }

    public void zobrazKnihuPodlaIndexu() {
        System.out.println("Zadaj index knihy: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < knihy.size()) {
            System.out.println("Kniha na indexe " + index + ": " + knihy.get(index));
        } else {
            System.out.println("Neexistuje kniha na tomto indexe.");
        }
    }

    public void vymazKnihuPodlaIndexu() {
        System.out.println("Zadajte index knihy na vymazanie: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < knihy.size()) {
            knihy.remove(index);
            System.out.println("Kniha na indexe " + index + " bola vymazaná");
        } else {
            System.out.println("Neexistuje kniha na tomto indexe.");
        }
    }

    public void zobrazPocetKnih() {
        System.out.println("Počet všetkých kníh v knižnici: " + knihy.size());
    }

    public void vyhladajKnihu() {
        System.out.println("Zadajte názov knihy na vyhľadanie");
        String nazov = scanner.nextLine().toLowerCase().trim();


        boolean nasielPodlaNazvu = false;
        if (!nazov.isEmpty()) {
            for (Kniha kniha : knihy) {
                if (kniha.nazov.toLowerCase().contains(nazov)) {
                    System.out.println(kniha);
                    nasielPodlaNazvu = true;
                }
            }
            if (nasielPodlaNazvu) {
                System.out.println("Kniha bola nájdená podľa názvu knihy.");
                return;
            } else {
                System.out.println("Kniha podľa názvu nebola nájdená");
            }
        }
        System.out.println("Zadajte autora knihy na vyhľadávanie:");
        String autor = scanner.nextLine().toLowerCase().trim();

        boolean nasielPodlaAutora = false;
        if (!autor.isEmpty()) {
            for (Kniha kniha : knihy) {
                if (kniha.autor.toLowerCase().contains(autor)) {
                    System.out.println(kniha);
                    nasielPodlaAutora = true;
                }
            }
                if (nasielPodlaAutora) {
                    System.out.println("Kniha bola nájdená podľa mena autora");
              }
                else {
            System.out.println("Kniha podľa autora nebola nájdená");

        }
    }
}
}

