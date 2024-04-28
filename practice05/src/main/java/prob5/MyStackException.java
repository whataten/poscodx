package prob5;

public class MyStackException extends Exception{

    public MyStackException(String exception) {
        super(exception);
    }

    public MyStackException() {
        super("stack is empty");
    }
}
