import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class TaskFactory {
    private static final Map<String, Function<TaskData, Itask>> creators = new HashMap<>();

    public static void registerCreator(String type, Function<TaskData, Itask> creator) {
        creators.put(type, creator);
    }

    public static Itask createTask(TaskData data) {
        Function<TaskData, Itask> creator = creators.get(data.getType());
        if (creator == null) {
            throw new IllegalArgumentException("Unknown task type: " + data.getType());
        }
        return creator.apply(data);
    }


    static {
        registerCreator("Reminder", data -> new Reminder(data.title, data.type, data.amount, data.date));
        registerCreator("FinancialGoal", data -> new FinancialGoal(data.title, data.type, data.amount, data.date));
        registerCreator("Donation", data -> new Donation(data.title, data.type, data.amount, data.date));
    }
}

