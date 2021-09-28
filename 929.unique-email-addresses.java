/*
 * @lc app=leetcode id=929 lang=java
 *
 * [929] Unique Email Addresses
 */

// @lc code=start

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String e : emails) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            // stop at first '+'
            while (i < e.length() && e.charAt(i) != '+' && e.charAt(i) != '@') {
                // no '.'
                if (e.charAt(i) != '.') {
                    sb.append(e.charAt(i));
                }
                i++;
            }
            sb.append(e.substring(e.indexOf('@')));
            set.add(sb.toString());
        }

        return set.size();
    }
}

// @lc code=end
