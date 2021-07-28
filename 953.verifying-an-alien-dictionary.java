import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=953 lang=java
 *
 * [953] Verifying an Alien Dictionary
 */

// @lc code=start

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i)
            index[order.charAt(i) - 'a'] = i;

        boolean isDifferent = false;
        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    isDifferent = true;

                    int val1 = index[word1.charAt(k) - 'a'], val2 = index[word2.charAt(k) - 'a'];
                    if (val1 > val2) {
                        // If they compare badly, it's not sorted.
                        return false;
                    } else if (val1 < val2) {
                        break;
                    }
                }
            }

            // If we didn't find a first difference, which is not different (!isDifferent)
            // the words are like ["apple","app"].
            if (!isDifferent && word1.length() > word2.length())
                return false;
        }

        return true;
    }
}
// @lc code=end
