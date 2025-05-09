public class MenuManager {
    private User currentUser;
    private Imenu imenu;
    public MenuManager(User currentUser) {
        this.currentUser = currentUser;
    }

    public void setCurrentUser(User curUser){
        this.currentUser = curUser;
    }

    public void showMainMenu(){

        while(true){
            System.out.println("Enter your option: ");
            System.out.println("1. Income page");
            System.out.println("2. Expenses page");
            System.out.println("3. Budget page");
            System.out.println("4. Reminder page");
            System.out.println("5. Exit");
            String option = System.console().readLine();
            boolean exitMenu = false;
            switch (option) {
                case "1":
                    imenu = new IncomeMenu(currentUser);
                    imenu.showMenu();
                    break;
                case "2":
                    imenu = new ExpensesMenu(currentUser);
                    imenu.showMenu();
                    break;
                case "3":
                    imenu = new BudgetMenu(currentUser, currentUser.getBudget());
                    imenu.showMenu();
                    break;
                case "4":
                    imenu = new ReminderMenu(currentUser);
                    imenu.showMenu();
                    break;
                case "5":
                    exitMenu = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again");
            }
            if(exitMenu){
                break;
            }
        }
    }
}
