package uloha.mysql;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String relation;
    private Date birthDate;

    private String category;
    private double amount;
    private Date expenseDate;

    // Gettery a settery
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }
    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }
    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    @Override
    public String toString() {
        return "User {" +
                "\n id = " + id +
                "\n name = " + name +
                "\n relation = " + relation +
                "\n birthDate = " + birthDate +
                (category != null ? "\n category = " + category : "") +
                (amount != 0.0 ? "\n amount = " + amount : "") +
                (expenseDate != null ? "\n expenseDate = " + expenseDate : "") +
                "\n}";
    }
}
