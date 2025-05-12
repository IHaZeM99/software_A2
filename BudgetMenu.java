import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BudgetMenu implements Imenu {
    private User currUser;
    private Budget currBudget;

    BudgetMenu(User currUser, Budget currBudget) {
        this.currUser = currUser;
        this.currBudget = currBudget;
    }

    @Override
    public void showMenu() {
        while (true) {
            System.out.println("\nBudget Menu");
            System.out.println("----------------------------");
            System.out.println("1. Set Budget for Category");
            System.out.println("2. Add Expense");
            System.out.println("3. Test Budget");
            System.out.println("4. Exit");
            Scanner myObj = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            String choice = myObj.nextLine();

            while (!choice.matches("[1-4]")) {
                System.out.println("Invalid choice");
                System.out.print("Enter your choice: ");
                choice = myObj.nextLine();
            }

            if (choice.equals("1")) {
                System.out.print("Enter Budget Category: ");
                String category = myObj.nextLine().trim();

                System.out.print("Enter Budget Amount: ");
                String budgetAmountStr = myObj.nextLine().trim();

                try {
                    float budgetAmount = Float.parseFloat(budgetAmountStr);

                    if (budgetAmount <= 0) {
                        System.out.println("Budget must be a positive number.");
                        continue;
                    }

                    currBudget.setBudgetForCategory(category, budgetAmount);
                    System.out.println("Budget of $" + budgetAmount + " set for category: " + category);

                    float spent = currBudget.getSpentInCategory(currUser.getExpenses(), category);
                    System.out.printf("You have spent $%.2f on %s.%n", spent, category);

                    if (spent > budgetAmount) {
                        System.out.println("Warning: You have exceeded your budget for " + category + "!");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Must be a valid currency.");
                }

            } else if (choice.equals("2")) {
                System.out.print("Enter Expense Category: ");
                String category = myObj.nextLine().trim();

                System.out.print("Enter Expense Date (yyyy-MM-dd): ");
                String dateStr = myObj.nextLine().trim();

                System.out.print("Enter Expense Amount: ");
                String amountStr = myObj.nextLine().trim();

                try {
                    float amount = Float.parseFloat(amountStr);
                    if (amount <= 0) {
                        System.out.println("Amount must be positive.");
                        continue;
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = sdf.parse(dateStr);

                    Expenses expense = new Expenses(category, amount, date);
                    currUser.addExpenses(expense);

                    System.out.println("Expense added successfully to category: " + category);

                    float categoryBudget = currBudget.getBudgetForCategory(category);
                    float spent = currBudget.getSpentInCategory(currUser.getExpenses(), category);

                    if (categoryBudget > 0) {
                        System.out.printf("Budget: $%.2f | Spent: $%.2f | Remaining: $%.2f%n",
                                categoryBudget, spent, categoryBudget - spent);
                        if (spent > categoryBudget) {
                            System.out.println("Warning: You've exceeded your budget in this category.");
                        }
                    } else {
                        System.out.println("No budget was set for this category.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Must be a valid number.");
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Use yyyy-MM-dd.");
                }

            } else if (choice.equals("3")) {
                System.out.print("Enter category: ");
                String category = myObj.nextLine().trim();

                System.out.print("Enter item title: ");
                String itemTitle = myObj.nextLine().trim();

                System.out.print("Enter item price: ");
                String itemPriceStr = myObj.nextLine().trim();

                try {
                    float itemPrice = Float.parseFloat(itemPriceStr);
                    if (itemPrice <= 0) {
                        System.out.println("Price must be a positive number.");
                        continue;
                    }

                    float categoryBudget = currBudget.getBudgetForCategory(category);
                    float spent = currBudget.getSpentInCategory(currUser.getExpenses(), category);

                    if ((categoryBudget - spent) >= itemPrice) {
                        System.out.println("You can afford \"" + itemTitle + "\" in category \"" + category + "\".");
                    } else {
                        System.out.println("Cannot afford \"" + itemTitle + "\". It exceeds your budget for \"" + category + "\".");
                    }

                    System.out.printf("Budget for %s: $%.2f | Spent: $%.2f | Remaining: $%.2f%n",
                            category, categoryBudget, spent, categoryBudget - spent);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number for the item price.");
                }

            } else if (choice.equals("4")) {
                break;
            }
        }
    }
}
