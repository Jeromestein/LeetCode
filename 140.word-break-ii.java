import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> wordDictSet = new HashSet<>(wordDict);

        // get max word length
        int maxWordLen = 0;
        for (String word : wordDictSet) {
            maxWordLen = Math.max(maxWordLen, word.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        // dp[0] means empty string, valid
        dp[0] = true;

        // get dp
        for (int i = 1; i < s.length(); i++) {
            // don't need to walk though all the s[0,i-1]
            // if even the longest word can't fit in, than this string is invalid
            // dp[i] should be false
            for (int j = i; j >= 0 && j >= i - maxWordLen; j--) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        backtrack(s, res, wordDictSet, dp, new LinkedList<>(), s.length());
        return res;
    }

    public void backtrack(String s, List<String> res, Set<String> wordDictSet, boolean[] dp, Deque<String> temp,
            int end) {
        if (end == 0) {
            res.add(String.join(" ", temp));
            return;
        }

        // from end to start, backtracking the dp
        for (int start = end; start >= 0; start--) {
            String word = s.substring(start, end);
            if (dp[start] && wordDictSet.contains(word)) {
                temp.addFirst(word);
                backtrack(s, res, wordDictSet, dp, temp, start);
                temp.removeFirst();
            }
        }
    }
}

// @lc code=end
