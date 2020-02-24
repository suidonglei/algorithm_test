package learn.contest.jen;

import javax.imageio.stream.ImageOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 5169. Number of Days Between Two Dates
 * Write a program to count the number of days between two dates.
 *
 * The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.
 *
 */
public class NumberDays {
    public static void main(String[] args) {
        NumberDays numberDays = new NumberDays();
        numberDays.daysBetweenDates("1971-06-29", "2010-09-23");
    }
    public int daysBetweenDates(String date1, String date2) {
        String[] dateA = date1.split("-");
        String[] dateB = date2.split("-");

        int day1 = Integer.parseInt(dateA[2]);
        int day2 = Integer.parseInt(dateB[2]);

        int month1 = Integer.parseInt(dateA[1]);
        int month2 = Integer.parseInt(dateB[1]);

        int year1 = Integer.parseInt(dateA[0]);
        int year2 = Integer.parseInt(dateB[0]);

        int days1 = getDays(year1, month1, day1);
        int days2 = getDays(year2, month2, day2);
        int result = days1 > days2 ? days1 - days2 : days2 - days1;

        return result;
    }

    private int getDays(int year, int month, int day) {
        Map<Integer, Integer> zidian = new HashMap<>();
        zidian.put(1, 31);
        zidian.put(3, 31);
        zidian.put(4, 30);
        zidian.put(5, 31);
        zidian.put(6, 30);
        zidian.put(7, 31);
        zidian.put(8, 31);
        zidian.put(9, 30);
        zidian.put(10, 31);
        zidian.put(11, 30);
        zidian.put(12, 31);
        int result = 0;
        for(int i = 1970; i < year; i ++) {
            if(i%4==0 && i%100!=0 || i%400 == 0) {
                result += 366;
            } else {
                result += 365;
            }
        }
        for(int i = 1; i < month; i ++) {
            if(Objects.isNull(zidian.get(i))) {
                if(year%4==0 && year%100!=0 || year%400 == 0) {
                    result += 29;
                } else {
                    result += 28;
                }
            } else {
                result += zidian.get(i);
            }
        }
        result += day;
        return result;
    }
}
