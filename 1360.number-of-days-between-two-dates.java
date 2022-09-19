/*
 * @lc app=leetcode id=1360 lang=java
 *
 * [1360] Number of Days Between Two Dates
 */

// @lc code=start
class Solution {
    public static boolean isLeap(int y) {
        return y % 4 == 0 && y % 100 != 0 || y % 400 == 0;
    }

    public static int calc(int y, int m, int d) {
        int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int day = 0;
        // year
        for (int i = 1971; i < y; i++) {
            if (isLeap(i)) {
                day += 366;
            } else {
                day += 365;
            }
        }
        // month
        for (int i = 1; i < m; i++) {
            day += month[i];
        }
        // day
        if (isLeap(y) && m > 2) {
            day += 1;
        }
        return day + d;
    }

    public int daysBetweenDates(String date1, String date2) {
        int y1 = Integer.parseInt(date1.substring(0, 4));
        int m1 = Integer.parseInt(date1.substring(5, 7));
        int d1 = Integer.parseInt(date1.substring(8));
        int y2 = Integer.parseInt(date2.substring(0, 4));
        int m2 = Integer.parseInt(date2.substring(5, 7));
        int d2 = Integer.parseInt(date2.substring(8));
        return Math.abs(calc(y1, m1, d1) - calc(y2, m2, d2));
    }
}
// @lc code=end
