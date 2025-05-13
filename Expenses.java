import java.util.Date;

public class Expenses {
    private String category;
    private String expenseTitle;
    private double expense;
    private Date expenseDate;
    public Expenses(String category, String Title,double income,Date expenseDate) {
        this.category = category;
        this.expenseTitle = Title;
        this.expense = income;
        this.expenseDate = expenseDate;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setExpenseTitle(String Title){
        this.expenseTitle = Title;
    }
    public void setExpense(float income) {
        this.expense = income;
    }
    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }
    public String getExpenseTitle() {
        return expenseTitle;
    }
    public double getExpense() {
        return expense;
    }
    public Date getExpenseDate() {
        return expenseDate;
    }
}

