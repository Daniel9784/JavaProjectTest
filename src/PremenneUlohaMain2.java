import java.text.SimpleDateFormat;
import java.util.Date;

public class PremenneUlohaMain2 {
    public static void main(String[] args) {

        String meno = "Jozef Mrkvička";
        var datum = "18.06.2022";
        var znamka = 1.5;
        var znamkax2 = znamka * 2;
        var obdobie = "septembra 2022";
        var miesto = "Bratislava";

        Date aktualnyDatum = new Date();
        SimpleDateFormat formatDatumu = new SimpleDateFormat("dd.MM.yyyy");


        //       System.out.println("Študent " + meno + " sa narodil " + datum + ", z maturitnej skúšky má známku" + znamka + " a od " + obdobie + " nastúpi do nového zamestnania ako Java programátor.");
        //      System.out.println("V Bratislave dňa " + formatDatumu.format(aktualnyDatum));
//        System.out.println("Dvojnásobok priemernej známky je " + znamkax2);

        //System.out.printf("Známka naformátovaná vo forme desatinnej čiarky je %.2f", znamka);
        System.out.printf("Študent %s sa narodil %s, z maturitnej skúšky má známku %,2f a od %s nastúpi do nového zamestnania ako Java programátor", meno, datum, znamka, obdobie);
    }
}