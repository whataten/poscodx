package exception;

public class MyClassTest {
    public static void main(String[] args) {
        try {
            new MyClass().danger();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
