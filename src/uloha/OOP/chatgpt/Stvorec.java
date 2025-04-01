package uloha.OOP.chatgpt;

// Podtrieda Štvorec
public class Stvorec extends Tvar {
    private double strana;

    public Stvorec(double strana) {
        super("Štvorec");
        this.strana = strana;
    }

    @Override
    public double vypocitajObsah() {
        return strana * strana;
    }
}