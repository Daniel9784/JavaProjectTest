package uloha;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;


import java.io.*;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Kniha implements Serializable {
    private static final long serialVersionUID = 1L;
    String nazov;
    String autor;

    Kniha(String nazov, String autor) {
        this.nazov = nazov;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Kniha: " + nazov + ", Autor: " + autor;
    }
}

public class JednoduchaKniznica {
    private ArrayList<Kniha> knihy = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        JednoduchaKniznica jednoduchaKniznica = new JednoduchaKniznica();
        jednoduchaKniznica.deserialize(jednoduchaKniznica.knihy,"zoznamKnih.ser");
        jednoduchaKniznica.start();
    }

    public void start() {
        int volba;
        do {
            System.out.println("\n --- Knižnica ---");
            System.out.println("1. Zadaj novú knihu");
            System.out.println("2. Zobraz všetky knihy");
            System.out.println("3. Zobrat konkrétnu knihu (podľa indexu)");
            System.out.println("4. Vymaž konkrétnu knihu (podľa indexu)");
            System.out.println("5. Zobraz počet všetkých kníh");
            System.out.println("6. Vyhľadá knihu podľa názvu knihy alebo podľa autora");
            System.out.println("7. Uloží knihy");
            System.out.println("8. Exportuje do PDF");
            System.out.println("9. Upraví knihu");
            System.out.println("10. Ukončí program");
            System.out.print("Zadajte číslo voľby");
            volba = scanner.nextInt();
            scanner.nextLine();

            switch (volba) {
                case 1 -> pridajKnihu();
                case 2 -> zobrazVsetkyKnihy();
                case 3 -> zobrazKnihuPodlaIndexu();
                case 4 -> vymazKnihuPodlaIndexu();
                case 5 -> zobrazPocetKnih();
                case 6 -> vyhladajKnihu();
                case 7 -> serialize(knihy, "zoznamKnih.ser");
                case 8 -> exportPDF();
                case 9 -> upravKnihu();
                case 10 -> System.out.println("Program bol ukončený");
                default -> System.out.println("Neplatná voľba!");
            }
        } while (volba != 10);
    }


    public void pridajKnihu() {
        System.out.print("Zadaj názov knihy: ");
        String nazov = scanner.nextLine();
        System.out.print("Zadaj autora knihy: ");
        String autor = scanner.nextLine();
        knihy.add(new Kniha(nazov, autor));
        System.out.println("Kniha bola pridaná.");
    }

    public void zobrazVsetkyKnihy() {
        if (knihy.isEmpty()) {
            System.out.println("Knižnica je prázdna.");
        } else {
            int index = 0;
            for (Kniha kniha : knihy) {
                System.out.println(index + ": " + kniha);
                index++;
            }
        }
    }

    public void zobrazKnihuPodlaIndexu() {
        System.out.println("Zadaj index knihy: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < knihy.size()) {
            System.out.println("Kniha na indexe " + index + ": " + knihy.get(index));
        } else {
            System.out.println("Neexistuje kniha na tomto indexe.");
        }
    }

    public void vymazKnihuPodlaIndexu() {
        System.out.println("Zadajte index knihy na vymazanie: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < knihy.size()) {
            knihy.remove(index);
            System.out.println("Kniha na indexe " + index + " bola vymazaná");
        } else {
            System.out.println("Neexistuje kniha na tomto indexe.");
        }
    }

    public void zobrazPocetKnih() {
        System.out.println("Počet všetkých kníh v knižnici: " + knihy.size());
    }

    public void vyhladajKnihu() {
        System.out.println("Zadajte názov knihy na vyhľadanie");
        String nazov = scanner.nextLine().toLowerCase().trim();


        boolean nasielPodlaNazvu = false;
        if (!nazov.isEmpty()) {
            for (Kniha kniha : knihy) {
                if (kniha.nazov.toLowerCase().contains(nazov)) {
                    System.out.println(kniha);
                    nasielPodlaNazvu = true;
                }
            }
            if (nasielPodlaNazvu) {
                System.out.println("Kniha bola nájdená podľa názvu knihy.");
                return;
            } else {
                System.out.println("Kniha podľa názvu nebola nájdená");
            }
        }
        System.out.println("Zadajte autora knihy na vyhľadávanie:");
        String autor = scanner.nextLine().toLowerCase().trim();

        boolean nasielPodlaAutora = false;
        if (!autor.isEmpty()) {
            for (Kniha kniha : knihy) {
                if (kniha.autor.toLowerCase().contains(autor)) {
                    System.out.println(kniha);
                    nasielPodlaAutora = true;
                }
            }
                if (nasielPodlaAutora) {
                    System.out.println("Kniha bola nájdená podľa mena autora");
              }
                else {
            System.out.println("Kniha podľa autora nebola nájdená");

        }
    }
}
public void serialize(ArrayList<Kniha> knihy, String zoznamKnih){
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(zoznamKnih))) {
        out.writeObject(knihy);
        System.out.println("Objekt bol serializovaný do: " + zoznamKnih);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public void deserialize(ArrayList<Kniha> knihy, String zoznamKnih){
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(zoznamKnih))) {
        knihy.addAll((ArrayList<Kniha>) in.readObject());
        System.out.println("Knihy boli načítané zo súboru.");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Neboli nájdené uložené knihy, začíname s prázdnou knižnicou.");
    }
}
public void exportPDF(){
        Document document = new Document();
    try
    {
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("zoznamKnih.pdf"));
        document.open();


        BaseFont baseFont = BaseFont.createFont("resources/fonts/FreeSans.otf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(baseFont, 12, Font.NORMAL);

        document.add(new Paragraph("Zoznam kníh: ", font));
        for(Kniha kniha:knihy){
            document.add(new Paragraph(kniha.toString(), font));
        }

        document.close();
        writer.close();
        System.out.println("PDF bol úspešne vytvorený");


    } catch (DocumentException | IOException e)
    {
        e.printStackTrace();
    }
}
public void upravKnihu(){
    System.out.println("Zadajte index knihy, ktorej názov chcete zmeniť");
    int index = scanner.nextInt();
    scanner.nextLine();
    if(index >= 0 && index < knihy.size() ){
        System.out.println("Vyberte možnosť: ");
        System.out.println("1. Zmeniť názov knihy");
        System.out.println("2. Zmeniť autora knihy");
        System.out.println("Zadajte voľbu: ");
        int volba = scanner.nextInt();
        scanner.nextLine();

        switch (volba) {
            case 1 -> {
                System.out.println("Zadajte nový názov knihy: ");
                String novyNazov = scanner.nextLine();
                knihy.get(index).nazov = novyNazov;
                System.out.println("Názov knihy bol zmenený");
            }
            case 2 -> {
                System.out.println("Zadajte nové meno autora knihy: ");
                String novyAutor = scanner.nextLine();
                knihy.get(index).autor = novyAutor;
                System.out.println("Autor knihy bol úspešne zmenený");
            }
            default -> System.out.println("Neplatná voľba!");
        }
} else{
        System.out.println("Neexistuje kniha na tomto indexe.");
}
}
}

