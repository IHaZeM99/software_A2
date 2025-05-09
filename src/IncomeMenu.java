import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IncomeMenu implements Imenu {
    private User currentUser;
    private List<Income> listofIncomes;
    public IncomeMenu(User currentUser,List<Income> listofIncomes){
        this.currentUser=currentUser;
        this.listofIncomes=listofIncomes;
    }
    @Override
    public void showMenu(){
        System.out.println("\nIncome Menu");
        System.out.println("----------------------------");
        System.out.println("1. Add Income");
        System.out.println("2. View Incomes");
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        String choice =  myObj.nextLine();
        while(!choice.equals("1") && !choice.equals("2")){
            System.out.println("Invalid choice");
            System.out.print("Enter your choice: ");
            choice =  myObj.nextLine();
        }
        if(choice.equals("1")){
            System.out.print("Enter Income Title: ");
            String title = myObj.nextLine();

            System.out.print("Enter Income Date (yyyy-MM-dd): ");
            String incomeDateStr = myObj.nextLine();

            System.out.print("Enter Income Amount: ");
            String incomeAmountStr = myObj.nextLine();
            try{
                float incomeAmount = Float.parseFloat(incomeAmountStr);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date incomeDate = sdf.parse(incomeDateStr);
                Income newIncome = new Income(title,incomeAmount,incomeDate);
                currentUser.addIncome(newIncome);
                listofIncomes.add(newIncome);
                System.out.println("Income added successfully");
                System.out.println("Current Incomes: "+listofIncomes);
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Must be a number.");
            } catch (ParseException e) {
                System.out.println("Invalid date format. Use yyyy-MM-dd.");
            }
        }else if(choice.equals("2")){
            System.out.print("Current Incomes "+listofIncomes);
        }
        myObj.close();
    }

}
