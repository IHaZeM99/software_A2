import java.awt.*;
import java.util.List;

public class LoginManager {
    private List<User> listOfUsers;
    private MenuManager menuManager;
    LoginManager(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;

    }

    private User verifyCredentials(String username, String password) {


        for (User user : listOfUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    public void login(){
        int cnt = 3;
        while (cnt-- > 0) {
            System.out.println("Enter your username: ");
            String username = System.console().readLine();
            System.out.println("Enter your password: ");
            String password = System.console().readLine();
            User user = verifyCredentials(username, password);
            if (listOfUsers == null || user != null) {
                this.menuManager = new MenuManager(user);
                menuManager.showMainMenu();
                break;
            }
            else{
                if(cnt==0){
                   System.out.println("Invalid username or password, You had tried too much times.");
                   System.exit(0);
                }
                System.out.println("Invalid username or password");
                System.out.println("You have " + cnt + " attempts to login");
            }
        }

    }
}
