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
            System.out.println("2. Set Budget for Extra Category");
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
                String categoryName = myObj.nextLine().trim();

                System.out.print("Enter Budget Amount: ");
                String budgetAmountStr = myObj.nextLine().trim();

                try {
                    double budgetAmount = Float.parseFloat(budgetAmountStr);

                    if (budgetAmount <= 0) {
                        System.out.println("Budget must be a positive number.");
                        continue;
                    }

                    if(budgetAmount > currBudget.getTotalIncome()){
                        System.out.println("Budget amount exceeds total income, please try again.");
                        continue;
                    }

                    currBudget.addCategory(categoryName, budgetAmount);
                    System.out.println("Budget of $" + budgetAmount + " set for category: " + categoryName);




                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Must be a valid currency.");
                }

            }
            else if (choice.equals("2")) {

                System.out.print("Enter Budget Amount for Extra Category: ");
                String budgetAmountStr = myObj.nextLine().trim();

                try {
                    double budgetAmount = Float.parseFloat(budgetAmountStr);

                    if (budgetAmount <= 0) {
                        System.out.println("Budget must be a positive number.");
                        continue;
                    }

                    if(budgetAmount > currBudget.getTotalIncome()){
                        System.out.println("Budget amount exceeds total income, please try again.");
                        continue;
                    }

                    currBudget.addCategory("Extras", budgetAmount);
                    System.out.println("Budget of $" + budgetAmount + " set for category: " + "Extras");




                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Must be a valid currency.");
                }
            }
           else if (choice.equals("3")) {
                System.out.print("Enter category: ");
                String categoryName = myObj.nextLine().trim();

                System.out.print("Enter item title: ");
                String itemTitle = myObj.nextLine().trim();

                System.out.print("Enter item price: ");
                String itemPriceStr = myObj.nextLine().trim();

                try {
                    double itemPrice = Float.parseFloat(itemPriceStr);
                    if (itemPrice <= 0) {
                        System.out.println("Price must be a positive number.");
                        continue;
                    }

                    double categoryBudget = currBudget.getBudgetForCategory(categoryName);
                    double spent = currBudget.getSpentInCategory(categoryName);

                    if ((categoryBudget - spent) >= itemPrice) {
                        System.out.println("You can afford \"" + itemTitle + "\" in category \"" + categoryName + "\".");
                    } else {
                        System.out.println("Cannot afford \"" + itemTitle + "\". It exceeds your budget for \"" + categoryName + "\".");
                    }

                    System.out.printf("Budget for %s: $%.2f | Spent: $%.2f | Remaining: $%.2f%n",
                            categoryName, categoryBudget, spent, categoryBudget - spent);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number for the item price.");
                }

            } else if (choice.equals("4")) {
                break;
            }
        }
    }
}
