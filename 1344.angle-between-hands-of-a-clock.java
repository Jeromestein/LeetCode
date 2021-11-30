/*
 * @lc app=leetcode id=1344 lang=java
 *
 * [1344] Angle Between Hands of a Clock
 */

// @lc code=start

class Solution {
    public double angleClock(int hour, int minutes) {
        // Math.abs(minAngle-hourAngle) double
        // minAngle=minutes/60*360=(minutes*6)%360;
        // hourAngle=(hour*30)%360+minutes/60*360/12=(hour*30)%360+minutes*0.5

        // 12, 30-> 180-15=165
        // 3, 30-> 180-90-15=75
        // 3, 15-> 90-(90+7.5)=7.5
        // 4, 50 -> 300 - (120+25)=155
        // 12,0 -> 0
        // 1, 57 -> 342-(30+)

        double minAngle = (minutes * 6) % 360, hourAngle = (hour * 30) % 360 + minutes * 0.5;
        double res = Math.abs(minAngle - hourAngle);
        return Math.min(res, 360 - res);

    }
}
// @lc code=end
