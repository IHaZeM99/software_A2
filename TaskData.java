import java.util.Date;

// Simple data holder
public class TaskData {
    public final String title;
    public final String type;
    public final double amount;
    public final Date date;

    public TaskData(String title, String type, double amount, Date date) {
        this.title = title;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getType() {
        return type;
    }
}
