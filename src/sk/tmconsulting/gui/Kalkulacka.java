package sk.tmconsulting.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

 // Dedime z JFrame aby moja trieda Kalkulacka bola akoby JFrame. Tym padom nemusime vytvarat dalsi JFrame objekt a vsetky jej metody su ihned dostupne.
public class Kalkulacka extends JFrame {

    private JTextField vstupnePole;
    private JButton vypocitajTlacitko;
    private JLabel vysledokStitok;

    public Kalkulacka() {
        setTitle("Kalkulačka");
        setSize(400, 160);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        vstupnePole = new JTextField();
        vstupnePole.setFont(new Font("Arial", Font.PLAIN, 24));
        vstupnePole.setHorizontalAlignment(SwingConstants.LEFT);
        add(vstupnePole, BorderLayout.NORTH);

        vypocitajTlacitko = new JButton("Vypočítať");
        vypocitajTlacitko.setFont(new Font("Arial", Font.BOLD, 20));
        add(vypocitajTlacitko, BorderLayout.CENTER);

        vysledokStitok = new JLabel("Výsledok: ", SwingConstants.CENTER);
        vysledokStitok.setFont(new Font("Arial", Font.PLAIN, 20));
        add(vysledokStitok, BorderLayout.SOUTH);

        // Pouzitie :: sa nazyva method reference. Je to skratena verzia: vypocitajTlacitko.addActionListener(e -> vypocitaj(e));
        // (e je parameter typu ActionEvent a obsahuje info o udalosti ako je kliknutie) tento parameter sa posiela metode vypocitaj pri kliknuti
        vypocitajTlacitko.addActionListener(this::vypocitaj);

        setVisible(true);
    }

    private void vypocitaj(ActionEvent e) {
        String vyraz = vstupnePole.getText();
        try {
            double result = vyhodnotVyraz(vyraz);
            vysledokStitok.setText("Výsledok: " + result);
        } catch (Exception ex) {
            vysledokStitok.setText("Výsledok: Chybný výraz");
        }
    }

    // Parser na jednoduche vyrazy s + - * /
    // Nebol pouzity ScriptEngine z dovodu ze od JDK15 by nemal byt podporovany.
    private double vyhodnotVyraz(String vyraz) {
        return new Object() {
            // pos uchovava poziciu v retazci vyraz a je na -1 aby sa zacalo citat od prveho znaku, ch uchovava aktualny znak ktory sa spracuvava
            int pos = -1, ch;
            // metoda sa vola vzdy ked prechadzame na dalsi znak v retazci.
            void nextChar() {
            // zabezpeci ze sa nastavi ch na dalsi znak retazca alebo na hodnotu -1 ak neexistuju dalsie znaky. ++pos nas dostane z pozicie -1 na 0 a potom sa pouzije vo vyraze
                ch = (++pos < vyraz.length()) ? vyraz.charAt(pos) : -1;
            }
           // Metoda na spracovanie jednotlivych znakov. Zisti ci aktualny char je rovny charToEat. Ak ano zje tento znak a vrati true. Znak sa takzvane zje a potom to pokracuje dalej
            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }
           // Vstupna metoda ktora spusti cele parsovanie. Najskor zavola nextChar aby zacala na prvom znaku vyrazu a potom zavola parseExpression co je hlavna metoda na parsovanie vyrazu.
            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < vyraz.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }
            // Parsuje operacie + - najprv zavola parseTerm ktory spracuvava nasobenie a delenie kedze to ma prednost
            double parseExpression() {
                double x = parseTerm();
                while (true) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }
            // Zavola parseFactor nech zisti ci sa jedna o kladne alebo zaporne cisla.
            double parseTerm() {
                double x = parseFactor();
                while (true) {
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }
            // Parsuje kladne aj zaporne cisla. Pomocou cyklu cita cele a desatine cisla a prevedie ich na double.
            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(vyraz.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Čakám číslo");
                }

                return x;
            }
        }.parse();
    }
  // Pouzitie new na vytvorenie noveho objektu. Po pouziti sa vola konstruktor triedy a tym sa vytvori novy objekt tejto triedy. New je implementovany priamo v Jave.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Kalkulacka::new);
    }
}
