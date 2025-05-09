import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReminderMenu implements Imenu{
    private User currentUser;

    public ReminderMenu(User currentUser){
        this.currentUser=currentUser;
    }
    @Override
    public void showMenu(){
        while(true) {
            System.out.println("\nReminder Menu");
            System.out.println("----------------------------");
            System.out.println("1. Add Reminder");
            System.out.println("2. View Reminders");
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
                System.out.print("Enter Reminder Title: ");
                String title = myObj.nextLine();

                System.out.print("Enter Reminder Type: ");
                String type = myObj.nextLine();

                System.out.print("Enter Reminder Date (yyyy-MM-dd): ");
                String ReminderDateStr = myObj.nextLine();

                System.out.print("Enter Reminder Amount of money: ");
                String ReminderAmountStr = myObj.nextLine();
                try {
                    float ReminderAmount = Float.parseFloat(ReminderAmountStr);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date ReminderDate = sdf.parse(ReminderDateStr);
                    Reminder newReminder = new Reminder(title, type, ReminderAmount, ReminderDate);
                    currentUser.addReminder(newReminder);
                    System.out.println("Reminder added successfully");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Must be a number.");
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Use yyyy-MM-dd.");
                }
            } else if (choice.equals("2")) {
                List<Reminder> reminders = currentUser.getReminders();
                int cnt = 1;
                for (Reminder reminder : reminders) {
                    System.out.println("Reminder number " + cnt++);
                    System.out.println("Title: " + reminder.getTitle());
                    System.out.println("Type: " + reminder.getType());
                    System.out.println("Cost: " + reminder.getCost());
                    System.out.println("Date of Repeating task: " + reminder.getDateOfRepeatingTask());
                }
            } else if (choice.equals("3")) {
                break;
            }

        }
    }
}
