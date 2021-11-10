/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // frequencies of the tasks
        int[] freq = new int[26];
        for (int t : tasks) {
            freq[t - 'A']++;
        }

        Arrays.sort(freq);

        // max frequency
        int idle_time = (freq[25] - 1) * n;

        for (int i = freq.length - 2; i >= 0 && idle_time > 0; --i) {
            idle_time -= Math.min(freq[25] - 1, freq[i]);
        }
        idle_time = Math.max(0, idle_time);

        return idle_time + tasks.length;
    }
}

// @lc code=end
