import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    }
}
    @Override
    public void showMenu(){
        while(true) {
            System.out.println("\nBudget Menu");
            System.out.println("----------------------------");
            System.out.println("1. Add Expense");
            System.out.println("2. Test Budget");
            System.out.println("3. Exit");
            Scanner myObj = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            String choice = myObj.nextLine();
            while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
                System.out.println("Invalid choice");
                System.out.print("Enter your choice: ");
                choice = myObj.nextLine();
            }
            if (choice.equals("1")) {
                System.out.print("Enter Budget Category: ");
                String category = myObj.nextLine().trim();

                System.out.print("Enter Budget Amount with decimal points: ");
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
                    System.out.println("Invalid amount. Must be a valid currency (e.g., 500.00).");
                }
            }
            else if (choice.equals("2")) {

                    System.out.print("Enter category (e.g., groceries): ");
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
                        if (categoryBudget == 0f) {
                            System.out.println("No budget has been set for this category.");
                            continue;
                        }

                        float spentInCategory = currBudget.getSpentInCategory(currUser.getExpenses(), category);

                        if ((categoryBudget - spentInCategory) >= itemPrice) {
                            System.out.println(" You can afford \"" + itemTitle + "\" in the category \"" + category + "\".");
                        } else {
                            System.out.println(" You cannot afford \"" + itemTitle + "\". It exceeds your budget for \"" + category + "\".");
                        }

                        System.out.printf("Budget for %s: $%.2f | Spent: $%.2f | Remaining: $%.2f%n",
                                category, categoryBudget, spentInCategory, categoryBudget - spentInCategory);

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number for the item price.");
                    }
                }

            else if(choice.equals("3")) {

                break;
            }
        }
    }
}
