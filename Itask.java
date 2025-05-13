import java.util.Date;

public interface Itask {
    String getTitle();
    void setTitle(String title);

    String getType();
    void setType(String type);

    double getCost();
    void setCost(double cost);

    Date getDateOfRepeatingTask();
    void setDateOfRepeatingTask(Date date);

    void checkAndNotify();
}