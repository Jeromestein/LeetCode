import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start

class Solution {
    boolean[][] isPalindrome;

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        isPalindrome = new boolean[s.length()][s.length()];
        // DP to get the matrix of isPalindrome[start][end]
        for (int i = 0; i < s.length(); i++) {
            // because all the single character is Palindrome
            Arrays.fill(isPalindrome[i], true);
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            // don't need to consider single character
            for (int j = i + 1; j < s.length(); j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        backtarack(res, new ArrayList<>(), s, 0);
        return res;
    }

    public void backtarack(List<List<String>> res, List<String> temp, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome[start][end]) {
                temp.add(s.substring(start, end + 1));
                backtarack(res, temp, s, end + 1);
                temp.remove(temp.size() - 1);
            }
        }

    }
}
// @lc code=end
