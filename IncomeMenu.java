import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IncomeMenu implements Imenu {
    private User currentUser;
    //private List<Income> listofIncomes;
    public IncomeMenu(User currentUser){

        this.currentUser=currentUser;
        //this.listofIncomes= currentUser.getIncomes();
    }
    @Override
    public void showMenu(){
        while(true) {
            System.out.println("\nIncome Menu");
            System.out.println("----------------------------");
            System.out.println("1. Add Income");
            System.out.println("2. View Incomes");
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
                System.out.print("Enter Income Title: ");
                String title = myObj.nextLine();

                System.out.print("Enter Income Date (yyyy-MM-dd): ");
                String incomeDateStr = myObj.nextLine();

                System.out.print("Enter Income Amount: ");
                String incomeAmountStr = myObj.nextLine();
                try {
                    float incomeAmount = Float.parseFloat(incomeAmountStr);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date incomeDate = sdf.parse(incomeDateStr);
                    Income newIncome = new Income(title, incomeAmount, incomeDate);
                    currentUser.addIncome(newIncome);

                    System.out.println("Income added successfully");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Must be a number.");
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Use yyyy-MM-dd.");
                }
            }
            else if (choice.equals("2")) {
                List<Income> listofIncomes = currentUser.getIncomes();
                int cnt = 1;
                for (Income income : listofIncomes) {
                    System.out.println("Income number: " + cnt);
                    System.out.println("Tile: " + income.getSourceTitle());
                    System.out.println("Income: " + income.getIncome());
                    System.out.println("Date: " + income.getIncomeDate());
                    System.out.println();
                    cnt++;
                }
            }
            else if(choice.equals("3")) {
                //myObj.close();
                break;
            }

        }
    }

}
