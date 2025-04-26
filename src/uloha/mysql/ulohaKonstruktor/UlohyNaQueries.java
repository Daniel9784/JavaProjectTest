package uloha.mysql.ulohaKonstruktor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UlohyNaQueries {

    private static final String URL = "jdbc:mysql://localhost:3306/sprava_nakladov_2tabulky_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Celkove vydavky
    public double getTotalExpenses() {
        String sql = "SELECT SUM(amount) FROM expenses";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

        // Odpoved z query premenena na desatinne cislo
            if (resultSet.next()) {
                return resultSet.getDouble(1);
            } else {
                return 0.0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    // Vydavky podla kategorii
    public Map<String, Double> getExpensesByCategory() {
        String sql = "SELECT category, SUM(amount) FROM expenses GROUP BY category";
        Map<String, Double> categorySum = new HashMap<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String category = resultSet.getString(1);
                double sum = resultSet.getDouble(2);
                categorySum.put(category, sum);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorySum;
    }

    public List<User> findUsersWithZInName() {
        String sql = "SELECT * FROM users WHERE SUBSTRING_INDEX(name, ' ', -1) LIKE '%Z%'";
        List<User> users = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {


        // Naplnime konstruktor udajmi
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("relation"),
                        resultSet.getDate("birth_date")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public List<User> userIn80sExpenses() {
        String sql = """
            SELECT id, name, relation, birth_date
            FROM users
            WHERE birth_date BETWEEN '1980-01-01' AND '1989-12-31'
            """;

        List<User> users = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

        // Naplnime konstruktor udajmi
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("relation"),
                        resultSet.getDate("birth_date")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public List<User> usersWithExpenses() {
        String sql = """
            SELECT users.name, expenses.category, expenses.amount, expenses.expense_date
            FROM users
            INNER JOIN expenses ON users.id = expenses.user_id
            """;

        List<User> users = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

        // Naplnime konstruktor udajmi
            while (resultSet.next()) {
        // Vnutorna trieda expense
                User.Expense expense = new User.Expense(
                        resultSet.getString("category"),
                        resultSet.getDouble("amount"),
                        resultSet.getDate("expense_date")
                );
                users.add(new User(resultSet.getString("name"), expense));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static void main(String[] args) {
        UlohyNaQueries repository = new UlohyNaQueries();

        double total = repository.getTotalExpenses();
        System.out.println("Total Expenses: " + total);

    // -> Lamba vyraz
        Map<String, Double> expensesByCategory = repository.getExpensesByCategory();
        expensesByCategory.forEach((category, sum) ->
                System.out.println("Category: " + category + ", Sum: " + sum));

        List<User> usersWithZ = repository.findUsersWithZInName();
        System.out.println("\nUsers with Z in the last name:\n");
        for (User user : usersWithZ)
            System.out.println(user);

        List<User> usersBornIn80s = repository.userIn80sExpenses();
        System.out.println("\nUsers born in 80s:\n");
        for (User user : usersBornIn80s) {
            System.out.println(user);
        }

        List<User> usersWithExpenses = repository.usersWithExpenses();
        System.out.println("\nUsers with Expenses:\n");
        for (User user : usersWithExpenses) {
            for (User.Expense expense : user.getExpenses()) {
                System.out.printf(
                        "User: %-20s | Category: %-15s | Amount: %8.2f € | Date: %s%n",
                        user.getName(),
                        expense.getCategory(),
                        expense.getAmount(),
                        expense.getExpenseDate()
                );
            }
        }
    }
}