import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TaskMenu implements Imenu{
    private User currentUser;
    private String type;

    public TaskMenu(User currentUser, String type) {
        this.currentUser=currentUser;
        this.type=type;
    }
    @Override
    public void showMenu() {
        while(true) {
            System.out.println("\n" + type +" Menu");
            System.out.println("----------------------------");
            System.out.println("1. Add " + type );
            System.out.println("2. View " + type  + "s");
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
                System.out.print("Enter " + type +" Title: ");
                String title = myObj.nextLine();


                System.out.print("Enter " + type + " Date (yyyy-MM-dd): ");
                String DateStr = myObj.nextLine();

                System.out.print("Enter "+ type + " cost: ");
                String AmountStr = myObj.nextLine();
                try {
                    float amount = Float.parseFloat(AmountStr);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date taskDate = sdf.parse(DateStr);

                    TaskData data = new TaskData(title, type, amount, taskDate);
                    Itask newTask = TaskFactory.createTask(data);
                    currentUser.addTask(newTask);
                    System.out.println(type + " added successfully");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Must be a number.");
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Use yyyy-MM-dd.");
                }
            } else if (choice.equals("2")) {
                List<Itask> itasks = currentUser.getTasks();
                int cnt = 1;
                for (Itask task : itasks) {
                    if(task.getType().equals(type)) {
                        System.out.println(type + " number " + cnt++);
                        System.out.println("Title: " + task.getTitle());
                        System.out.println("Cost: " + task.getCost());
                        System.out.println("Date of reminding for the task: " + task.getDateOfRepeatingTask());
                    }
                }
            } else if (choice.equals("3")) {
                break;
            }

        }
    }

}
