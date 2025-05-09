import java.util.ArrayList;
import java.util.List;

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
    private Budget budget;

    User( String username, String password, String email, String phone){
        this.id = ++userCount;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.incomes = new ArrayList<Income>();
        this.expenses = new ArrayList<Expenses>();
        this.reminders = new ArrayList<Reminder>();
        this.budget = new Budget();
    }

    public void addIncome(Income income){
        incomes.add(income);
    }
    public void addExpenses(Expenses expense){
        expenses.add(expense);
    }
    public void addReminder(Reminder reminder){
        reminders.add(reminder);
    }
    public void setBudget(Budget budget){
        this.budget = budget;
    }

    public int getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public List<Income> getIncomes(){
        return incomes;
    }
    public List<Expenses> getExpenses(){
        return expenses;
    }
    public List<Reminder> getReminders(){
        return reminders;
    }
    public Budget getBudget(){
        return budget;
    }
}
