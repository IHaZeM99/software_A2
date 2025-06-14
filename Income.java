import java.util.Date;

public class Income {
    private String sourceTitle;
    private double income;
    private Date incomeDate;

    public Income(String title, double income, Date incomeDate) {
        this.sourceTitle = title;
        this.income = income;
        this.incomeDate = incomeDate;
    }
    public void setSourceTitle(String title){
        this.sourceTitle = title;
    }
    public void setIncome(float income){
        this.income = income;
    }
    public void setIncomeDate(Date incomeDate){
        this.incomeDate = incomeDate;
    }
    public String getSourceTitle(){
        return this.sourceTitle;
    }
    public double getIncome(){
        return this.income;
    }
    public Date getIncomeDate() {
        return this.incomeDate;
    }
}
