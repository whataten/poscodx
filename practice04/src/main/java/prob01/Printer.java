package prob01;

public class Printer {
    // public void println(String input) {
    // System.out.println(input);
    // }

    // public void println(boolean input) {
    // System.out.println(input);
    // }

    // public void println(double input) {
    // System.out.println(input);
    // }

    // public void println(int input) {
    // System.out.println(input);
    // }

    public <T> void println(T t) {
        System.out.println(t);
    }

    public <T> void println(T... ts) {
        for (var t : ts) {
            System.out.println(t);
        }
    }

    public int sum(Integer... nums) {
        int s = 0;
        for (var n : nums) {
            s += n;
        }

        return s;
    }
}
