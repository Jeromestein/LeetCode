/*
 * @lc app=leetcode id=1629 lang=java
 *
 * [1629] Slowest Key
 */

// @lc code=start

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int longest = releaseTimes[0];
        char slowestKey = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int currDuration = releaseTimes[i] - releaseTimes[i - 1];
            char currKey = keysPressed.charAt(i);

            if (currDuration > longest || currDuration == longest && currKey > slowestKey) {
                longest = currDuration;
                slowestKey = currKey;
            }
        }

        return slowestKey;
    }
}
// @lc code=end
