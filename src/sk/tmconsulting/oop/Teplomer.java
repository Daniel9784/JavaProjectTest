package sk.tmconsulting.oop;


public class Teplomer {
    private double teplotaC; // teplota v stupňoch Celzia

    // Konštruktor
    public Teplomer(double teplotaC) {
        setTeplotaC(teplotaC); // využívame setter aj tu kvôli validácii
    }

    // Setter s kontrolou rozsahu
    public void setTeplotaC(double teplotaC) {
        if (teplotaC >= -100 && teplotaC <= 100) {
            this.teplotaC = teplotaC;
        } else {
            System.out.println("Zadaná teplota je mimo rozsahu (-100 až 100°C).");
        }
    }

    // Getter pre teplotu v Celsius
    public double getTeplotaC() {
        // Zaokruhlenie mozeme urobit priamo v getteri
        return teplotaC;
    }

    // Getter pre teplotu vo Fahrenheit
    public double getTeplotaF() {
        return teplotaC * 9 / 5 + 32;
    }

    // Zobrazenie teploty
    public void zobrazTeplotu() {
        System.out.println("Teplota: " + teplotaC + " °C");
        System.out.println("Teplota: " + getTeplotaF() + " °F");
    }

    // Hlavná metóda
    public static void main(String[] args) {
        Teplomer t1 = new Teplomer(25.5);
        t1.zobrazTeplotu();

        System.out.println();

        t1.setTeplotaC(-150); // Neplatná hodnota
        t1.setTeplotaC(18.3); // Platná hodnota
        t1.zobrazTeplotu();
    }
}


