package thread;

public class ThreadEx03 {
    public static void main(String[] args) {
        new AlphabetThread().start();
        new DigitThread().start();
        new Thread(new UpperCaseAlphabetRunnable()).start();
    }
}
