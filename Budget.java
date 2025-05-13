import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Budget {
    private Map<String, Category> categories;
    private double totalIncome;
    public Budget() {
        categories = new HashMap<>();
        categories.put("Extras", new Category("Extras", 0.0));
        this.totalIncome = 0;
    }
    void addToTotalIncome(double totalIncome) {
        this.totalIncome += totalIncome;
    }

    void removeFromTotalIncome(double removedIncome) {
        this.totalIncome -= removedIncome;
    }

    double getTotalIncome() {
        return totalIncome;
    }

    Map<String, Category> getCategories() {
        return categories;
    }

    public void addCategory(String name, double budget) {
        categories.put(name, new Category(name, budget));
    }

    public void addExpenseToCategory(String name, Expenses expenses) {
        Category category = categories.get(name);
        if (category != null) {
            category.addExpense(expenses);
        } else {
            System.out.println("Category not found: " + name);
        }
    }

    public double getSpentInCategory(String categoryName) {
        Category category = categories.get(categoryName);

        if (category != null) {
            return category.getTotalExpenses();
        }
        else{
            System.out.println("Category not found: " + categoryName);
            return -1;
        }
    }

    public double getBudgetForCategory(String categoryName) {
        Category category = categories.get(categoryName);
        if (category != null) {
            return category.getBudget();
        }
        else{
            System.out.println("Category not found: " + categoryName);
            return -1;
        }
    }

    public boolean isCategoryExists(String categoryName) {
        return categories.containsKey(categoryName);
    }
    public void printReportForAllCategories() {

        if (categories.isEmpty()) {
            System.out.println("No categories to display.");
            return;
        }

        double totalExpenses = 0;
        List<Expenses> listOfExpenses;
        for (Category category : categories.values()) {
            System.out.println("Category: " + category.getName());
            System.out.println("  Budget: " + category.getBudget());
            listOfExpenses =category.getExpenses();
            int cnt = 1;
            for (Expenses expenses : listOfExpenses) {
                System.out.println("  Expense number: " + cnt);
                System.out.println("  Title: " + expenses.getExpenseTitle());
                System.out.println("  Expense: " + expenses.getExpense());
                System.out.println("  Date: " + expenses.getExpenseDate());
                System.out.println();
                cnt++;
            }
            totalExpenses += category.getTotalExpenses();
            System.out.println("  Total Expenses: " + category.getTotalExpenses());
            double remainingBudget =  category.getBudget()-category.getTotalExpenses();
            System.out.println("  Remaining of budget: " + remainingBudget);
            System.out.println("  Over Budget? " + category.isOverBudget());
            System.out.println();
        }
        double remainingMoney = totalIncome-totalExpenses;
        System.out.println("The Remaining of incomes is: " + remainingMoney);
        if(remainingMoney < 0){
            System.out.println("The Remaining of incomes is negative, you had exceeded the budget.");
        }
    }

    public void printReportForCategory(String categoryName) {
        Category category = categories.get(categoryName);
        if (category != null) {
            System.out.println("Category: " + category.getName());
            System.out.println("  Budget: " + category.getBudget());
            System.out.println("  Total Expenses: " + category.getTotalExpenses());
            System.out.println("  Over Budget? " + category.isOverBudget());
        }
    }

    public boolean hasNoUserCategories() {
        return categories.size() == 1 && categories.containsKey("Extras");
    }
}
