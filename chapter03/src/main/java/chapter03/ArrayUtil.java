package chapter03;

public class ArrayUtil {
    public static double[] intToDouble(int[] ints) {

        double[] result = new double[ints.length];

        for (int i = 0; i < ints.length; i++) {
            result[i] = (double) ints[i];
        }
        return result;
    }
}
