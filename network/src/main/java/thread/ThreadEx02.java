package thread;

public class ThreadEx02 {
    public static void main(String[] args) {
        new AlphabetThread().start();
        new DigitThread().start();
    }
}
