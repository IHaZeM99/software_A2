import java.util.ArrayList;
import java.util.List;

public class system {
    private List<User> listOfUsers;
    private LoginManager loginManager;
    private SignUpManager signUpManager;


    private void loadData(){

    }

    private void saveData(){

    }

    system(){
        listOfUsers = new ArrayList<User>();
        loadData();
        this.loginManager= new LoginManager(listOfUsers);
        this.signUpManager= new SignUpManager(listOfUsers);

    }

    private void systemMenu(){
        while(true) {
            System.out.println("Welcome to the BudgetWise system: ");
            System.out.println("\nChoose one of these 3 options:");
            System.out.println("1. Login");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            String option = System.console().readLine();

            switch (option) {
                case "1":
                    loginManager.login();
                    break;
                case "2":
                    signUpManager.signUp();
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please try again");
            }
        }
    }

    public void runSystem(){


        systemMenu();

    }
}
