import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) {
            return res;
        }

        backtrack(res, new StringBuilder(s), 1, 0);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder sb, int idx, int dotCNt) {
        if (dotCNt == 3) {
            if (isValidIP(sb)) {
                res.add(sb.toString());

            }
            return;
        }

        // 1. add "."
        if (idx < sb.length() && dotCNt < 3) {
            if (sb.charAt(idx - 1) != '.') {
                sb.insert(idx, ".");
                backtrack(res, sb, idx + 1, dotCNt + 1);
                sb.deleteCharAt(idx);
            }

            // 2. not add "."
            backtrack(res, sb, idx + 1, dotCNt);
        }

    }

    public boolean isValidIP(StringBuilder sb) {
        String[] bytes = sb.toString().split("\\.");

        if (bytes.length != 4) {
            return false;
        }
        for (String b : bytes) {
            if (b.equals("")) {
                return false;
            }
            if (!b.equals("0") && b.charAt(0) == '0') {
                return false;
            }
            long val = Long.valueOf(b);

            if (val < 0 || val > 255) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
