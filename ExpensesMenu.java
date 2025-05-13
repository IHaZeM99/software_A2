import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ExpensesMenu implements Imenu{
    private User currentUser;
    private Budget currentBudget;

    ExpensesMenu(User currentUser, Budget currentBudget){
        this.currentUser=currentUser;
        this.currentBudget=currentBudget;
    }
    @Override
    public void showMenu(){
        while(true) {
            System.out.println("\nExpenses Menu");
            System.out.println("----------------------------");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
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
                System.out.print("do you want to add this expense in a specific category ? (Y/N): ");
                choice = myObj.nextLine();
                boolean putInCategory = false;
                String categoryName = "Extras";
                if(!currentBudget.hasNoUserCategories()) {
                    if (choice.equals("Y") || choice.equals("y")) {
                        putInCategory = true;
                        while (true) {
                            System.out.println("Please enter a valid category name: ");
                            categoryName = myObj.nextLine();
                            if (!currentBudget.isCategoryExists(categoryName)) {
                                System.out.println("Category does not exist");
                            } else {
                                break;
                            }
                        }
                    }
                }
                System.out.print("Enter Expense Title: ");
                String title = myObj.nextLine();

                System.out.print("Enter Expense Date (yyyy-MM-dd): ");
                String expenseDateStr = myObj.nextLine();

                System.out.print("Enter Expense Amount: ");
                String expenseAmountStr = myObj.nextLine();
                try {
                    double expenseAmount = Float.parseFloat(expenseAmountStr);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date expenseDate = sdf.parse(expenseDateStr);
                    Expenses newExpenses = new Expenses(categoryName, title, expenseAmount, expenseDate);
                    currentUser.addExpenses(newExpenses);
                    currentBudget.addExpenseToCategory(categoryName, newExpenses);
                    System.out.println("Expenses added successfully");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Must be a number.");
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Use yyyy-MM-dd.");
                }
            }
            else if (choice.equals("2")) {
                currentBudget.printReportForAllCategories();
            }
            else if(choice.equals("3")) {

                break;
            }
        }
    }
}
