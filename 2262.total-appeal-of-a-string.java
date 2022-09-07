/*
 * @lc app=leetcode id=2262 lang=java
 *
 * [2262] Total Appeal of A String
 */

// @lc code=start
class Solution {
    public long appealSum(String s) {
        long res = 0;
        // last[char] is the index of the char appears last time
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0, currContribution = 0; i < s.length(); i++) {
            int currChar = s.charAt(i) - 'a';
            // sum of contribution for substring ending with i
            // i-last[currChar] is the contribution of current charactor
            currContribution += i - last[currChar];
            res += currContribution;
            last[currChar] = i;
        }

        return res;
    }
}

// @lc code=end
