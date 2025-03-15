package sk.tmconsulting.testy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Obdlznik {
    public static double vypocitajObvod(double stranaA, double stranaB) {
        return 2 * (stranaA + stranaB);
    }
    public static double vypocitajObsah(double stranaA, double stranaB) {
        return stranaA * stranaB;
    }

    public static void main(String[] args) {
        double a = 2.5; // Strana a
        double b = 3.5; // Strana b
        // TODO Vytvorit menu polozky s(tart) pre vstupne zadavanie stran a, b a prikaz q pre ukoncenie programu. Inac program bude fungovat do nekonecna
        System.out.println("Obvod obdĺžnika je: " + vypocitajObvod(a, b));
        System.out.println("Obsah obdĺžnika je: " + vypocitajObsah(a, b));
    }

    @Test
    public void testVypocitajObvod() {
        assertEquals(10, vypocitajObvod(2, 3));
        assertEquals(10, vypocitajObvod(1.5, 3.5));
        assertEquals(2, vypocitajObvod(0.9, 0.1));
    }

    @Test
    public void testVypocitajObsah() {
        assertEquals(20, vypocitajObsah(2, 10));
        assertEquals(8, vypocitajObsah(2, 4));
    }


}
