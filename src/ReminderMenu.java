import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReminderMenu implements Imenu{
    private User currentUser;
    private List<Reminder> listofReminders;
    public ReminderMenu(User currentUser,List<Reminder> listofReminders){
        this.currentUser=currentUser;
        this.listofReminders=listofReminders;
    }
    @Override
    public void showMenu(){
        System.out.println("\nReminder Menu");
        System.out.println("----------------------------");
        System.out.println("1. Add Reminder");
        System.out.println("2. View Reminders");
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        String choice =  myObj.nextLine();
        while(!choice.equals("1") && !choice.equals("2")){
            System.out.println("Invalid choice");
            System.out.print("Enter your choice: ");
            choice =  myObj.nextLine();
        }
        if(choice.equals("1")){
            System.out.print("Enter Reminder Title: ");
            String title = myObj.nextLine();

            System.out.print("Enter Reminder Type: ");
            String type = myObj.nextLine();

            System.out.print("Enter Reminder Date (yyyy-MM-dd): ");
            String ReminderDateStr = myObj.nextLine();

            System.out.print("Enter Reminder Amount of money: ");
            String ReminderAmountStr = myObj.nextLine();
            try{
                float ReminderAmount = Float.parseFloat(ReminderAmountStr);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date ReminderDate = sdf.parse(ReminderDateStr);
                Reminder newReminder = new Reminder(title,type,ReminderAmount,ReminderDate);
                currentUser.addTask(newReminder);
                listofReminders.add(newReminder);
                System.out.println("Reminder added successfully");
                System.out.println("Current Reminders: "+listofReminders);
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Must be a number.");
            } catch (ParseException e) {
                System.out.println("Invalid date format. Use yyyy-MM-dd.");
            }
        }else if(choice.equals("2")){
            System.out.print("Current Reminders "+listofReminders);
        }
        myObj.close();
    }
}
