/*
 * @lc app=leetcode id=249 lang=java
 *
 * [249] Group Shifted Strings
 */

// @lc code=start

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            map.computeIfAbsent(getKey(s), l -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // get key to form the same group, for example:
    // acf = "2,3", and pru = "2,3".
    private String getKey(String s) {
        char[] chars = s.toCharArray();
        String key = "";
        for (int i = 1; i < chars.length; i++) {
            int diff = chars[i] - chars[i - 1];
            key += diff < 0 ? diff + 26 : diff;
            key += ",";
        }
        return key;
    }
}
// @lc code=end
