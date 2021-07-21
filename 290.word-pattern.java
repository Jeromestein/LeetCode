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
            if (pattern2String.containsKey(pattern.charAt(i))) {
                // if key has val but val != words[i]
                if (!pattern2String.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            } else {
                pattern2String.put(pattern.charAt(i), words[i]);
            }

            // putIfAbsent(key, val) return null means key has no val now
            if (String2pattern.containsKey(words[i])) {
                if (String2pattern.get(words[i]) != pattern.charAt(i)) {
                    return false;
                }
            } else {
                String2pattern.put(words[i], pattern.charAt(i));
            }

        }

        return true;
    }
}

// @lc code=end
