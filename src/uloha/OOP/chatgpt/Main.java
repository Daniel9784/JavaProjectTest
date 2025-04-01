package uloha.OOP.chatgpt;

public class Main {
    public static void main(String[] args) {
        Tvar kruh = new Kruh(5);
        Tvar stvorec = new Stvorec(4);

        kruh.zobrazInfo();
        System.out.println("Obsah: " + kruh.vypocitajObsah());

        stvorec.zobrazInfo();
        System.out.println("Obsah: " + stvorec.vypocitajObsah());
    }
}