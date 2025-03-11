package uloha;

import java.util.Scanner;

public class novakalkulacka {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Zadajte dĺžku obdĺžnika v metroch: ");
        double dlzka = scanner.nextDouble();

        System.out.print("Zadajte šírku obdĺžnika v metroch: ");
        double sirka = scanner.nextDouble();

        scanner.nextLine(); // bolo nutné aby som nepreskočil if voľbu

        System.out.println("Vyberte, čo chcete vypočítať:");
        System.out.println("1. Obsah");
        System.out.println("2. Obvod");

        String volba = scanner.nextLine();


        if (volba.equals("obsah")) {
            double obsah = dlzka * sirka;
            System.out.println("Obsah obdĺžnika je: " + obsah + " m²");

        } else if (volba.equals("obvod")) {
            double obvod = 2 * (dlzka + sirka);
            System.out.println("Obvod obdĺžnika je: " + obvod + " m");
        } else {
            System.out.println("Error!");
        }

        scanner.close();
    }
}
