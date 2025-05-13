import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface IpersistanceMechanism {

    public List<User> readUsersFromFile()throws IOException, ParseException;



    void saveAllUsersToFile(List<User> users) throws IOException;
}
