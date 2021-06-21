/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] countMap = new int[26];
        int maxUnique = getMaxUniqueLetters(s);

        int result = 0;
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            // reset countMap
            Arrays.fill(countMap, 0);

            int windowStart = 0, windowEnd = 0, idx = 0, unique = 0, countAtLeastK = 0;
            while (windowEnd < str.length) {
                // If the number of unique characters in the sliding window
                // is less than or equal to currUnique,
                // expand the sliding window
                if (unique <= currUnique) {
                    idx = str[windowEnd] - 'a';
                    if (countMap[idx] == 0)
                        unique++;
                    countMap[idx]++;
                    if (countMap[idx] == k)
                        countAtLeastK++;
                    windowEnd++;
                }
                // shrink the sliding window
                else {
                    idx = str[windowStart] - 'a';
                    if (countMap[idx] == k)
                        countAtLeastK--;
                    countMap[idx]--;
                    if (countMap[idx] == 0)
                        unique--;
                    windowStart++;
                }

                // the number of unique characters in the sliding window
                // is equal to currUnique,
                // and all of unique characters are counted at least k times
                if (unique == currUnique && unique == countAtLeastK)
                    result = Math.max(windowEnd - windowStart, result);
            }
        }

        return result;
    }

    // get the maximum number of unique letters in the string s
    int getMaxUniqueLetters(String s) {
        boolean map[] = new boolean[26];
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s.charAt(i) - 'a']) {
                maxUnique++;
                map[s.charAt(i) - 'a'] = true;
            }
        }
        return maxUnique;
    }

    // public int longestSubstring(String s, int k) {
    // int[] count = new int[26];
    // for (int i = 0; i < s.length(); i++)
    // count[s.charAt(i) - 'a']++;

    // for (int i = 0; i < s.length(); i++) {
    // if (count[s.charAt(i) - 'a'] < k) {
    // int j = i + 1;
    // while (j < s.length() && count[s.charAt(j) - 'a'] < k)
    // j++;
    // return Math.max(longestSubstring(s.substring(0, i), k),
    // longestSubstring(s.substring(j), k));
    // }
    // }

    // return s.length();
    // }
}
// @lc code=end
