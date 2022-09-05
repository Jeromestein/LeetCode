/*
 * @lc app=leetcode id=2214 lang=java
 *
 * [2214] Minimum Health to Beat Game
 */

// @lc code=start
class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int maxDamage = 0;
        long sum = 0;
        for (int x : damage) {
            maxDamage = Math.max(x, maxDamage);
            sum += x;
        }

        return (long) sum - Math.min(maxDamage, armor) + 1;
    }
}
// @lc code=end
