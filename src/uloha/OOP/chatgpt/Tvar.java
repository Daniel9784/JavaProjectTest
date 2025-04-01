package uloha.OOP.chatgpt;

// Rodičovská trieda
public abstract class Tvar {
    protected String nazov;

    public Tvar(String nazov) {
        this.nazov = nazov;
    }

    public abstract double vypocitajObsah();

    public void zobrazInfo() {
        System.out.println("Tvar: " + nazov);
    }
}