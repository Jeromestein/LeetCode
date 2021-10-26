/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // frequencies of the tasks
        int[] cnt = new int[26];
        for (int t : tasks) {
            cnt[t - 'A']++;
        }

        Arrays.sort(cnt);

        // max frequency
        int idle_time = (cnt[25] - 1) * n;

        for (int i = cnt.length - 2; i >= 0 && idle_time > 0; --i) {
            idle_time -= Math.min(cnt[25] - 1, cnt[i]);
        }
        idle_time = Math.max(0, idle_time);

        return idle_time + tasks.length;
    }
}

// @lc code=end
