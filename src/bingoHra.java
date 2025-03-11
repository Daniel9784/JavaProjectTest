import java.util.Random;
import java.util.Scanner;


public class bingoHra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int nahodneCislo = random.nextInt(100) + 1;
        String vstup;
        int vstupneCislo;

        System.out.println("Myslím si číslo od 1 do 100. Uhádni ho!");

        while (true) {
            vstup = scanner.nextLine();

//          Overenie platnosti vstupu

            if (!vstup.matches("^\\d+$")) {
                System.out.println("Toto nie je číslo!");
                continue;
            }

            vstupneCislo = Integer.parseInt(vstup);


            if (vstupneCislo < 1 || vstupneCislo > 100) {
                System.out.println("Číslo nie je v rozsahu.");
                continue;
            }

//          Skusanie nahodneho cisla

            if (vstupneCislo < nahodneCislo) {
                System.out.println("Moje číslo je väčšie.");
            } else if (vstupneCislo > nahodneCislo) {
                System.out.println("Moje číslo je menšie.");
            } else {
                System.out.println("BINGO!");
                break;
            }
        }
        scanner.close();
    }
}
