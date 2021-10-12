/*
 * @lc app=leetcode id=1153 lang=java
 *
 * [1153] String Transforms Into Another String
 */

// @lc code=start

class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2))
            return true;
        Map<Character, Character> map = new HashMap<>();

        int len = str1.length();
        for (int i = 0; i < len; i++) {
            char ch1 = str1.charAt(i), ch2 = str2.charAt(i);
            if (map.putIfAbsent(ch1, ch2) != null && ch2 != map.putIfAbsent(ch1, ch2)) {
                return false;
            }
        }

        return new HashSet<Character>(map.values()).size() < 26;
    }
}
// @lc code=end
