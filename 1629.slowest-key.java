/*
 * @lc app=leetcode id=1629 lang=java
 *
 * [1629] Slowest Key
 */

// @lc code=start
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        // keysPressed contains only lowercase English letters.
        int[] duration = new int[26];

        // get max duration of each letter
        for (int i = 0; i < keysPressed.length(); i++) {
            int currLetter = keysPressed.charAt(i) - 'a';
            int currDuration = 0;
            if (i == 0) {
                currDuration = releaseTimes[i];
            } else {
                currDuration = releaseTimes[i] - releaseTimes[i - 1];
            }
            duration[currLetter] = Math.max(duration[currLetter], currDuration);
        }

        int longest = 0;
        char res = 'a';
        for (int i = duration.length - 1; i >= 0; i--) {
            if (longest < duration[i]) {
                longest = duration[i];
                res = (char) (i + 'a');
            }
        }

        return res;
    }
}
// @lc code=end
