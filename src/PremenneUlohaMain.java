import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PremenneUlohaMain {
    public static void main(String[] args) {
        String datumNarodenia = "03.04.2000";
        double znamka = 1.5;
        int rok = 2022;


        DecimalFormat df = new DecimalFormat("#,##0.00");
        String znamkaCiarka = df.format(znamka);

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = currentDate.format(formatter);

        System.out.println("Študent Jozef Mrkvička sa narodil " + datumNarodenia + ", " + "z maturitnej skúšky má známku " + znamkaCiarka + " a od septembra " + rok + " nastúpi do nového zamestnania.\n" + "V Bratislave dňa " + formattedDate);
    }
}
