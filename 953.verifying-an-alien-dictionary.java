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
        for (int i = 0; i < 26; i++) {
            index[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1], curr = words[i];

            for (int j = 0; j < pre.length(); j++) {
                // If we do not find a mismatch letter between words[i] and words[i + 1],
                // we need to examine the case when words are like ("apple", "app").
                if (j >= curr.length())
                    return false;

                char preC = pre.charAt(j), currC = curr.charAt(j);
                if (preC != currC) {
                    if (index[preC - 'a'] > index[currC - 'a']) {
                        return false;
                    } else {
                        // if we find the first different letter and they are sorted,
                        // then there's no need to check remaining letters
                        break;
                    }
                }

            }
        }

        return true;
    }
}

// @lc code=end
