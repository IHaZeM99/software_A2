import java.util.Date;

public class Expenses {
    private String expenseTitle;
    private float expense;
    private Date expenseDate;
    public Expenses(String Title,float income,Date expenseDate) {
        this.expenseTitle = Title;
        this.expense = income;
        this.expenseDate = expenseDate;
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
    public float getExpense() {
        return expense;
    }
    public Date getExpenseDate() {
        return expenseDate;
    }
}

