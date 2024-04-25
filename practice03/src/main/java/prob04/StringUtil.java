package prob04;

public class StringUtil {

    public static String concatenate(String[] strArr) {

        var sb = new StringBuilder();

        for (var str : strArr) {
            sb.append(str);
        }

        return sb.toString();
    }
}
