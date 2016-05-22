import java.util.Arrays;
public class UserDao {
    private String[] users;

    public UserDao(String[] users) {
        this.users = Arrays.copyOf(users, users.length);
    }

    public String getUser(int id) throws NoSuchUserException {
        try {
            String username = users[id];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchUserException(id, e);
        }
        // Catch the ArrayIndexOutOfBoundsException
        // Re-throw a NoSuchUserException
        return users[id];
    }
}
