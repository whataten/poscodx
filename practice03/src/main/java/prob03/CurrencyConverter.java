package prob03;

public class CurrencyConverter {

    private static double setted_rate = 0;

    public static void setRate(double rate) {
        setted_rate = rate;
    }

    public static double toDollar(double won) {

        var dollar = won / setted_rate;

        return dollar;

    }

    public static double toKRW(double dollar) {

        var won = dollar * setted_rate;

        return won;
    }

}
