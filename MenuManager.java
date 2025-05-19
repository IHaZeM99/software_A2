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
            System.out.println("5. Financial goals page");
            System.out.println("6. Donations page");
            System.out.println("7. Exit");
            String option = System.console().readLine();
            boolean exitMenu = false;
            switch (option) {
                case "1":
                    imenu = new IncomeMenu(currentUser);
                    imenu.showMenu();
                    break;
                case "2":
                    imenu = new ExpensesMenu(currentUser, currentUser.getBudget());
                    imenu.showMenu();
                    break;
                case "3":
                    if(currentUser.getIncomes().isEmpty()){
                        System.out.println("You don't have any incomes, so you can't set budget");
                        break;
                    }
                    imenu = new BudgetMenu(currentUser, currentUser.getBudget());
                    imenu.showMenu();
                    break;
                case "4":
                    imenu = new TaskMenu(currentUser, "Reminder");
                    imenu.showMenu();
                    break;
                case "5":
                    imenu = new TaskMenu(currentUser, "FinancialGoal");
                    imenu.showMenu();
                    break;
                case "6":
                    imenu = new TaskMenu(currentUser, "Donation");
                    imenu.showMenu();
                    break;
                case "7":
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
