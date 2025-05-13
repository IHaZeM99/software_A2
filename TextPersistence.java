import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class TextPersistence implements IpersistanceMechanism{

    private String filePath;

    public TextPersistence(String filePath) {
        if(Objects.equals(filePath, "")){
            filePath = "users.txt";
        }
        this.filePath = filePath;
    }

    public List<User> readUsersFromFile() throws IOException, ParseException {
        List<User> users = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        int userCount = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < userCount; i++) {
            String userInfoLine = reader.readLine();
            User user = loadUser(userInfoLine);

            String incomesLine = reader.readLine();
            loadIncome(incomesLine, user);

            String budgetLine = reader.readLine();
            loadBudgetPlans(budgetLine, user);

            String expensesLine = reader.readLine();
            loadExpenses(expensesLine, user);

            String remindersLine = reader.readLine();
            loadReminders(remindersLine, user);

            users.add(user);
        }

        reader.close();
        return users;
    }


    public User loadUser(String line) {
        String[] parts = line.split("::");
        String username = parts[0];
        String password = parts[1];
        String email = parts[2];
        String phone = parts[3];

        return new User(username, password, email, phone);
    }


    public void loadIncome(String line, User user) throws ParseException {
        if (line.isEmpty()) return;
        String[] incomes = line.split(" ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (String incomeStr : incomes) {
            String[] parts = incomeStr.split("-");
            int n = parts.length;
            String title = parts[0];
            double amount = Double.parseDouble(parts[1]);
            String dateStr = parts[n - 3] + "-" + parts[n - 2] + "-" + parts[n - 1];
            Date date = sdf.parse(dateStr);


            Income income = new Income(title, amount, date);
            user.addIncome(income);
            user.getBudget().addToTotalIncome(amount);
        }
    }


    public void loadBudgetPlans(String line, User user) {
        if (line.isEmpty()) return;
        String[] budgets = line.split(" ");
        for (String budgetStr : budgets) {
            String[] parts = budgetStr.split("-");
            String category = parts[0];
            double amount = Double.parseDouble(parts[1]);

            user.getBudget().addCategory(category, amount);
        }
    }


    public void loadExpenses(String line, User user) throws ParseException {
        if (line.isEmpty()) return;
        String[] expenses = line.split(" ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (String expenseStr : expenses) {
            String[] parts = expenseStr.split("-");
            int n = parts.length;
            String category = parts[0];
            String title = parts[1];
            double amount = Double.parseDouble(parts[2]);
            String dateStr = parts[n - 3] + "-" + parts[n - 2] + "-" + parts[n - 1];
            Date date = sdf.parse(dateStr);

            Expenses expense = new Expenses(category, title, amount, date);
            user.addExpenses(expense);
            user.getBudget().addExpenseToCategory(category, expense);
        }
    }


    public void loadReminders(String line, User user) throws ParseException {
        if (line.isEmpty()) return;
        String[] reminders = line.split(" ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (String reminderStr : reminders) {
            String[] parts = reminderStr.split("-");
            int n = parts.length;
            String title = parts[0];
            double cost = Double.parseDouble(parts[1]);
            String dateStr = parts[n - 3] + "-" + parts[n - 2] + "-" + parts[n - 1];
            Date date = sdf.parse(dateStr);

            Reminder reminder = new Reminder(title,"Reminder", cost, date);
            user.addReminder(reminder);
        }
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public void saveAllUsersToFile(List<User> users) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));


        writer.write(String.valueOf(users.size()));
        writer.newLine();


        for (User user : users) {

            writer.write(user.getUsername() + "::" + user.getPassword() + "::" + user.getEmail() + "::" + user.getPhone());
            writer.newLine();


            List<Income> incomes = user.getIncomes();
            for (int i = 0; i < incomes.size(); i++) {
                Income income = incomes.get(i);
                writer.write(income.getSourceTitle() + "-" + income.getIncome() + "-" + formatDate(income.getIncomeDate()));
                if (i < incomes.size() - 1) writer.write(" ");
            }
            writer.newLine();


            Map<String, Category> categories = user.getBudget().getCategories();
            int i = 0;
            for (Map.Entry<String, Category> entry : categories.entrySet()) {
                writer.write(entry.getKey() + "-" + entry.getValue().getBudget());
                if (i < categories.size() - 1) writer.write(" ");
                i++;
            }
            writer.newLine();


            List<Expenses> expenses = user.getExpenses();
            for (int j = 0; j < expenses.size(); j++) {
                Expenses exp = expenses.get(j);
                writer.write(exp.getCategory() + "-" + exp.getExpenseTitle() + "-" + exp.getExpense() + "-" + formatDate(exp.getExpenseDate()));
                if (j < expenses.size() - 1) writer.write(" ");
            }
            writer.newLine();


            List<Reminder> reminders = user.getReminders();
            for (int k = 0; k < reminders.size(); k++) {
                Reminder r = reminders.get(k);
                writer.write(r.getTitle() + "-" + r.getCost() + "-" + formatDate(r.getDateOfRepeatingTask()));
                if (k < reminders.size() - 1) writer.write(" ");
            }
            writer.newLine();
        }

        writer.close();
    }
}
