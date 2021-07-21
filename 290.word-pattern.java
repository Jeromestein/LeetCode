import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> pattern2String = new HashMap<>();
        Map<String, Character> String2pattern = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            // putIfAbsent(key, val) return null means key has no val now
            if (pattern2String.putIfAbsent(pattern.charAt(i), words[i]) != null) {
                // if key has val but val != words[i]
                if (!pattern2String.putIfAbsent(pattern.charAt(i), words[i]).equals(words[i])) {
                    return false;
                }
            }

            // putIfAbsent(key, val) return null means key has no val now
            if (String2pattern.putIfAbsent(words[i], pattern.charAt(i)) != null) {
                // if key has val but val != words[i]
                if (String2pattern.putIfAbsent(words[i], pattern.charAt(i)) != pattern.charAt(i)) {
                    return false;
                }
            }

        }

        return true;
    }
}
// @lc code=end
