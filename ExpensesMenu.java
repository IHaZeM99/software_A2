import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ExpensesMenu implements Imenu{
    private User currentUser;


    ExpensesMenu(User currentUser){
        this.currentUser=currentUser;

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
                System.out.print("Enter Expense Title: ");
                String title = myObj.nextLine();

                System.out.print("Enter Expense Date (yyyy-MM-dd): ");
                String expenseDateStr = myObj.nextLine();

                System.out.print("Enter Expense Amount: ");
                String expenseAmountStr = myObj.nextLine();
                try {
                    float expenseAmount = Float.parseFloat(expenseAmountStr);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date expenseDate = sdf.parse(expenseDateStr);
                    Expenses newExpenses = new Expenses(title, expenseAmount, expenseDate);
                    currentUser.addExpenses(newExpenses);
                    System.out.println("Expenses added successfully");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Must be a number.");
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Use yyyy-MM-dd.");
                }
            }
            else if (choice.equals("2")) {
                List<Expenses> listOfExpenses = currentUser.getExpenses();
                int cnt = 1;
                for (Expenses expenses : listOfExpenses) {
                    System.out.println("Income number: " + cnt);
                    System.out.println("Title: " + expenses.getExpenseTitle());
                    System.out.println("Expense: " + expenses.getExpense());
                    System.out.println("Date: " + expenses.getExpenseDate());
                    System.out.println();
                    cnt++;
                }
            }
            else if(choice.equals("3")) {

                break;
            }
        }
    }
}
