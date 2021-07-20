import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        // dp[0] means empty string, valid
        dp[0] = true;

        // get max word length
        int maxWordLen = 0;
        for (String word : wordDict) {
            maxWordLen = Math.max(maxWordLen, word.length());
        }

        for (int i = 1; i <= s.length(); i++) {
            // don't need to walk though all the s[0,i-1]
            // if even the longest word can't fit in, dp[i] should be false
            for (int j = i; j >= 0 && j >= i - maxWordLen; j--) {
                if (dp[j] && wordDictSet.contains(s.subSequence(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
// @lc code=end
