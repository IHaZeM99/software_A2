import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user of the budget management system.
 * A user can track income, expenses, reminders, and a personal budget.
 */
public class User {
    private final int id;
    private static int userCount = 0;
    private final String username;
    private final String password;
    private String email;
    private String phone;
    private List<Income> incomes;
    private List<Expenses> expenses;
    private List<Reminder> reminders;
    private List<Itask> tasks;
    private Budget budget;


    /**
     * Constructs a new User with the given credentials and contact information.
     *
     * @param username the username of the user
     * @param password the user's password
     * @param email the user's email address
     * @param phone the user's phone number
     */

    User(String username, String password, String email, String phone){

        this.id = ++userCount;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.incomes = new ArrayList<Income>();
        this.expenses = new ArrayList<Expenses>();
        this.reminders = new ArrayList<Reminder>();
        this.tasks = new ArrayList<Itask>();
        this.budget = new Budget();
    }


    /**
     * Adds a new income entry for the user.
     *
     * @param income the income object to add
     */
    public void addIncome(Income income){
        incomes.add(income);
    }

    /**
     * Removes a specific income entry and updates the budget accordingly.
     *
     * @param income the income object to remove
     * @return true if the income was found and removed, false otherwise
     */
    public boolean removeIncome(Income income){
       boolean found = incomes.remove(income);
       if(found){
           budget.removeFromTotalIncome(income.getIncome());
       }
       return found;
    }

    /**
     * Adds a new expense entry for the user.
     *
     * @param expense the expense object to add
     */
    public void addExpenses(Expenses expense){
        expenses.add(expense);
    }

    /**
     * Adds a new reminder for the user.
     *
     * @param reminder the reminder to add
     */
    public void addReminder(Reminder reminder){
        reminders.add(reminder);
    }

    public void addTask(Itask task){
        tasks.add(task);
    }

    /**
     * Sets a new budget for the user.
     *
     * @param budget the budget to assign
     */
    public void setBudget(Budget budget){
        this.budget = budget;
    }

    /**
     * @return the user's unique ID
     */
    public int getId(){
        return id;
    }
     /**
     * @return the user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the user's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return list of all incomes
     */
    public List<Income> getIncomes() {
        return incomes;
    }

    /**
     * @return list of all expenses
     */
    public List<Expenses> getExpenses() {
        return expenses;
    }

    /**
     * @return list of all reminders
     */
    public List<Reminder> getReminders() {
        return reminders;
    }

    public List<Itask> getTasks() {
        return tasks;
    }

    /**
     * @return the user's budget
     */
    public Budget getBudget() {
        return budget;
    }
}

