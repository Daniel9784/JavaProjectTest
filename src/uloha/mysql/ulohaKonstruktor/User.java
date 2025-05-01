package uloha.mysql.ulohaKonstruktor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String relation;
    private Date birthDate;
    private List<Expense> expenses = new ArrayList<>();

// Konstruktor pre findUsersWithZInName
    public User(int id, String name, String relation, Date birthDate) {
        this.id = id;
        this.name = name;
        this.relation = relation;
        this.birthDate = birthDate;
    }

// Konstruktor vyuzity v usersWithExpenses
    public User(String name, Expense expense) {
        this.name = name;
        this.expenses.add(expense);
    }

    public String getName() {

        return name;
    }

    public List<Expense> getExpenses() {

        return expenses;
    }

   // Na zobrazenie userIn80sExpenses
    @Override
    public String toString() {
        return "User {" +
                "\n id = " + id +
                "\n name = " + name +
                "\n relation = " + relation +
                "\n birthDate = " + birthDate +
                (expenses.isEmpty() ? "" : "\n expenses = " + expenses) +
                "\n}";
    }

    public static class Expense {
        private String category;
        private double amount;
        private Date expenseDate;

    // Konstruktor pre usersWithExpenses()
        public Expense(String category, double amount, Date expenseDate) {
            this.category = category;
            this.amount = amount;
            this.expenseDate = expenseDate;
        }

        public String getCategory() {

            return category;
        }

        public double getAmount() {

            return amount;
        }

        public Date getExpenseDate() {

            return expenseDate;
        }

        @Override
        public String toString() {
            return "\n\tExpense { category = '" + category + "', amount = " + amount + ", date = " + expenseDate + " }";
        }
    }
}
