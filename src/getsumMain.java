public class getsumMain {

    public static void main(String[] args) {
        double[] cisla = {10, 23, 34.8, 47.5, 67.5};

        
        
        double vysledokSucet = scitajCisla(cisla);
        System.out.println("Súčet čísel je: " + vysledokSucet);

        double vysledokPriemer = priemerCisel(cisla);
        System.out.println("Priemer čísel je: " + vysledokPriemer);

        double vysledokPocet = pocetCisel(cisla);
        System.out.println("Počet čísel v poli je: " + vysledokPocet);

        double vysledokMax = maxCisel(cisla);
        System.out.println("Najvyššie číslo v poli je: " + vysledokMax);

        double vysledokMin = minCisel(cisla);
        System.out.println("Najvyššie číslo v poli je: " + vysledokMin);
    }

    public static double scitajCisla(double[] cisla) {
        double sucet = 0;
        for (double scitanie : cisla) {
            sucet =  sucet + scitanie;
        }
        return sucet;
    }
    
    public static double priemerCisel(double[] cisla) {
        double priemer = scitajCisla(cisla);
        return priemer / cisla.length;
    }

    public static double pocetCisel(double[] cisla) {
        return cisla.length;
    }
    public static double maxCisel(double[] cisla) {
        double najvyssie = cisla[0];
        for (double cislo : cisla) {
        najvyssie = Math.max(najvyssie, cislo);
        }
        return najvyssie;
    }
    public static double minCisel(double[] cisla) {
        double najnizsie = cisla[0];
        for (double cislo : cisla) {
            najnizsie = Math.min(najnizsie, cislo);
        }
        return najnizsie;
    }

}
