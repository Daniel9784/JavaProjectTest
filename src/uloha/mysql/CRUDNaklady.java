package uloha.mysql;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class CRUDNaklady {

    // Vstupne udaje pre databazu
    private static final String URL = "jdbc:mysql://localhost:3306/sprava_nakladov_db";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) {

    // Napojenie na databazu
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Scanner scanner = new Scanner(System.in)){
            System.out.println("Pripojenie do MYSQL bolo uspesne");

            boolean running = true;

    // Uvodne zobrazovacie menu
            while(running){
                System.out.println("MENU");
                System.out.println("1. Pridat naklad");
                System.out.println("2. Zobrazit naklady");
                System.out.println("3. Ukoncit program");
                System.out.println("Tvoja volba: ");
                String volba = scanner.nextLine();

    // Vyber volby
        switch(volba){
            case "1" -> pridajNaklad(conn, scanner);
            case "2" -> zobrazNaklady(conn);
            case "3" -> {
                running = false;
                System.out.println("Program ukonceny");
            }
            default -> System.out.println("Neplatna volba");
        }

            }

    }catch (SQLException e){
            System.out.println("Databazova chyba" + e.getMessage());
        }
}


    private static void pridajNaklad(Connection conn, Scanner scanner) {
        try {
            System.out.print("Zadaj meno nakladu: ");
            String nazov = scanner.nextLine();

            System.out.print("Zadaj cenu nakladu: ");
            double cena = Double.parseDouble(scanner.nextLine());

            System.out.println("Zvoľ kategóriu:");
            for (Kategoria kat : Kategoria.values()) {
                System.out.println("- " + kat.name());
            }

    // Naplnime kategoriu nulovou hodnotou a nasledne bude naplnena z inputu
            Kategoria kategoria = null;

                String input = scanner.nextLine();

                try {
                    kategoria = Kategoria.valueOf(input);
                } catch (IllegalArgumentException e) {
                    System.out.println(" Chybna kategoria.");
                }

    // Vlozenie udajov do databazy
            String sql = "INSERT INTO naklady (nazov, cena, kategoria) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nazov);
                stmt.setDouble(2, cena);
                stmt.setString(3, kategoria.name());
                stmt.executeUpdate();
                System.out.println("Naklad bol uspesne pridany");
            }

        } catch (Exception e) {
            System.err.println("Chyba pri pridavani do nakladov: " + e.getMessage());
        }
    }

    // Vypis nakladov z databazy
private static void zobrazNaklady(Connection conn){
String sql = "SELECT * FROM naklady";
try(Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql)) {
    System.out.println("Zoznam nakladov: ");
    while (rs.next()) {
        int id = rs.getInt("id");
        String meno = rs.getString("nazov");
        double cena = rs.getDouble("cena");
        String kategoria = rs.getString("kategoria");
        Timestamp cas = rs.getTimestamp("datum");
        System.out.printf("%d | %s | %.2f € | %s | %s%n", id, meno, cena, kategoria, cas);
}
}catch(SQLException e){
    System.out.println("Chyba " + e.getMessage());
}
}
}



