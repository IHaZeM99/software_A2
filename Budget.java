import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Budget {
    private Map<String, Float> categoryBudgets = new HashMap<>();

    public void setBudgetForCategory(String category, float amount) {
        categoryBudgets.put(category.toLowerCase(), amount);
    }

    public float getBudgetForCategory(String category) {
        return categoryBudgets.getOrDefault(category.toLowerCase(), 0f);
    }

    public float calculateTotalIncome(List<Income> incomes) {
        float total = 0;
        for (Income income : incomes) {
            total += income.getIncome();
        }
        return total;
    }

    public float calculateTotalExpenses(List<Expenses> expenses) {
        float total = 0;
        for (Expenses expense : expenses) {
            total += expense.getExpense();
        }
        return total;
    }

    public boolean canAfford(float income, float expenses, float itemPrice) {
        return (income - expenses) >= itemPrice;
    }

    public float getSpentInCategory(List<Expenses> expenses, String category) {
        float total = 0;
        for (Expenses e : expenses) {
            if (e.getExpenseTitle().equalsIgnoreCase(category)) {
                total += e.getExpense();
            }
        }
        return total;
    }
}
