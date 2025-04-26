package uloha.mysql;

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

    private static final String URL = "jdbc:mysql://localhost:3306/sprava_nakladov_2tabulky_db"; // uprav si
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    // Sčítaj celkové náklady v tabuľke
    public double getTotalExpenses() {
        String sql = "SELECT SUM(amount) FROM expenses";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getDouble(1); // Ta 1 znamena ze je to prvy parameter (na riadku 22), da sa odkazovat aj na nazov.
            } else {
                return 0.0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public Map<String, Double> getExpensesByCategory() {
        String sql = "SELECT category, SUM(amount) FROM expenses GROUP BY category";
        Map<String, Double> categorySums = new HashMap<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String category = resultSet.getString(1);
                double sum = resultSet.getDouble(2);
                categorySums.put(category, sum);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorySums;
    }
    public List<User> findUsersWithZInName() {
        String sql = "SELECT * FROM users WHERE SUBSTRING_INDEX(name, ' ', -1) LIKE '%Z%'";
        List<User> users = new ArrayList<>();   // Arraylist je na zaciatku prazdny

        // Connect na databazu a executnutie Query
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {   //Prechadzame jednotlivymi zaznamami
                User user = new User();  // Vytvorime prazdneho pouzivatela ktoreho naplnime ID, name, relation, birth_date
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setRelation(resultSet.getString("relation"));
                user.setBirthDate((resultSet.getDate("birth_date")));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    public List<User> userIn80sExpenses() {
        String sql = "SELECT users.id, users.name, users.relation, users.birth_date, " +
                "expenses.id AS expense_id, expenses.category, expenses.amount, expenses.expense_date " +
                "FROM users " +
                "INNER JOIN expenses ON users.id = expenses.user_id " +
                "WHERE users.birth_date BETWEEN '1980-01-01' AND '1989-12-31'";

        List<User> users = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setRelation(resultSet.getString("relation"));
                user.setBirthDate(resultSet.getDate("birth_date"));
                users.add(user);

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

            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setCategory(resultSet.getString("category"));
                user.setAmount(resultSet.getDouble("amount"));
                user.setExpenseDate(resultSet.getDate("expense_date"));

                users.add(user);
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

        Map<String, Double> expensesByCategory = repository.getExpensesByCategory();
        expensesByCategory.forEach((category, sum) ->
                System.out.println("Category: " + category + ", Sum: " + sum));

        List<User> usersWithZ = repository.findUsersWithZInName();
        System.out.println("\n Users with Z in the last name: \n");
        for(User user : usersWithZ)
            System.out.println(user);

        List<User> usersBornIn80s = repository.userIn80sExpenses();
        System.out.println();
        for (User user : usersBornIn80s) {
            System.out.println(user);
        }

        List<User> usersWithExpenses = repository.usersWithExpenses();
        for (User user : usersWithExpenses) {
            System.out.printf(
                    "User: %-20s | Category: %-15s | Amount: %8.2f € | Date: %s%n",
                    user.getName(),
                    user.getCategory(),
                    user.getAmount(),
                    user.getExpenseDate()
            );
        }

    }
}

