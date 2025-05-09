import java.util.List;

public class SignUpManager {
    private List<User> listOfUsers;
    SignUpManager(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    private boolean verifyCredentials(String username, String password) {

        for (User user : listOfUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return false;
            }
        }

        return true;
    }



    public void signUp(){
        while (true) {
            System.out.println("Enter Username: ");
            String userName = System.console().readLine();
            System.out.println("Enter Password: ");
            String password = System.console().readLine();
            System.out.println("Enter Email: ");
            String email = System.console().readLine();
            System.out.println("Enter your phone number: ");
            String phoneNumber = System.console().readLine();

            if (listOfUsers == null ||  verifyCredentials(userName, password)) {
                User user = new User(userName, password, email, phoneNumber);
                listOfUsers.add(user);
                break;
            }
            else {
                System.out.println("Username and password are already exists");
            }
        }


    }
}
