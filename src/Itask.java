import java.util.Date;

public interface Itask {
    String getTitle();
    void setTitle(String title);

    String getType();
    void setType(String type);

    float getCost();
    void setCost(float cost);

    Date getDateOfRepeatingTask();
    void setDateOfRepeatingTask(Date date);

    void checkAndNotify();
}