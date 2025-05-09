import java.util.Date;

public class Reminder implements Itask{
    private String title;
    private String type;
    private float cost;
    private Date dateOfRepeatingTask;

    Reminder(String title,String type,float cost,Date dateOfRepeatingTask){
        this.title=title;
        this.type=type;
        this.cost=cost;
        this.dateOfRepeatingTask=dateOfRepeatingTask;
    }
    @Override
    public String getTitle(){
        return title;
    }
    @Override
    public void setTitle(String title){
        this.title = title;
    }
    @Override
    public String getType(){
        return type;
    }
    @Override
    public void setType(String type){
        this.type = type;
    }
    @Override
    public float getCost(){
        return cost;
    }
    @Override
    public void setCost(float cost){
        this.cost = cost;
    }
    @Override
    public Date getDateOfRepeatingTask(){
        return dateOfRepeatingTask;
    }
    @Override
    public void setDateOfRepeatingTask(Date date){
        this.dateOfRepeatingTask = date;
    }

    @Override
    public void checkAndNotify() {
        Date currentDate = new Date();
        if(dateOfRepeatingTask.getTime() >= currentDate.getTime()){

        }
    }
}

