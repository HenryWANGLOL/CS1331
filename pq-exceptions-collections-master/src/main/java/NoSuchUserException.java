public class NoSuchUserException extends Exception {
    private int id;

    public NoSuchUserException(int id, Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return ("User" + id + "does not exist");
    }

    public int getid() {
        return id;
    }

}