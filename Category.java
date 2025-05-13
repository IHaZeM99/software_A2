import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private double budget;
    private float totalSpent;
    private List<Expenses> expenses;

    public Category(String name, double budget) {
        this.name = name;
        this.budget = budget;
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expenses expense) {
        expenses.add(expense);
        totalSpent += expense.getExpense();
    }

    public double getTotalExpenses() {
        return totalSpent;
    }

    public boolean isOverBudget() {
        return getTotalExpenses() > budget;
    }

    // Getters and Setters
    public String getName() { return name; }
    public double getBudget() { return budget; }
    public List<Expenses> getExpenses() { return expenses; }
}