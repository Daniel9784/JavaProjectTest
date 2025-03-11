
import java.util.Random;
import java.util.Scanner;


public class bingoHra2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int nahodneCislo = random.nextInt(100) + 1;


        System.out.println("Myslím si číslo od 1 do 100. Uhádni ho!");

        while (true) {
            String textovyVstup = "";
            int vstup = 0;
            textovyVstup = scanner.nextLine();
            try {
                vstup = Integer.parseInt(textovyVstup);
            } catch (NumberFormatException e) {
                System.out.println("chyba");
                continue;
            }

//          Skusanie nahodneho cisla

            if (vstup < nahodneCislo) {
                System.out.println("Moje číslo je väčšie.");
            } else if (vstup > nahodneCislo) {
                System.out.println("Moje číslo je menšie.");
            } else {
                System.out.println("BINGO!");
                break;
            }
        }
        scanner.close();
    }
}
