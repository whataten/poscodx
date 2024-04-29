package chapter04;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        // Calendar.getInstance();
        // var aLocale = Locale.getDefault(Locale.Category.FORMAT);
        // TimeZone tz = TimeZone.getDefault();

        // System.out.println(aLocale + ":" + tz);

        Calendar cal = Calendar.getInstance();

        printDate(cal);

        // var locale = Locale.getDefault();
        // var calendar = Calendar.getInstance(locale);

        cal.set(Calendar.YEAR, 2024);
        cal.set(Calendar.MONTH, 11); // 12
        cal.set(Calendar.DATE, 25);
        printDate(cal);

        cal.set(2023, 9, 2);
        cal.add(Calendar.DATE, 300);
        printDate(cal);
    }

    private static void printDate(Calendar cal) {
        final String[] DAYS = { "일", "월", "화", "수", "목", "금", "토" };

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        System.out.println((year) + "년 " + (month + 1) + "월 " + date + "일 " + DAYS[day - 1] + "요일 " + hour + "시 "
                + minute + "분 " + second + "초");

    }
}
