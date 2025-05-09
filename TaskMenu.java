import java.lang.reflect.Array;

public class TaskMenu implements Imenu{
    private Array listofTasks;
    private String taskType;


    public TaskMenu(Array listofTasks, String taskType) {
        this.listofTasks = listofTasks;
        this.taskType = taskType;
    }
    @Override
    public void showMenu() {

    }
    public void viewTasks(){

    }
    public void addTask(Itask newTask){

    }
    public void deleteTask (Itask delTask){

    }
}
