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

        backtrack(res, new int[4], s, 0, 0);
        return res;
    }

    public void backtrack(List<String> res, int[] IPAddrs, String s, int segStart, int segCNT) {
        if (segCNT == 4 || segStart == s.length()) {
            if (segCNT == 4 && segStart == s.length())
                res.add(buildIPAddr(IPAddrs));
            return;
        }

        if (s.charAt(segStart) == '0') {
            IPAddrs[segCNT] = 0;
            backtrack(res, IPAddrs, s, segStart + 1, segCNT + 1);
        }

        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            // addr = [segStart: segEnd] of s
            addr = addr * 10 + s.charAt(segEnd) - '0';
            if (addr < 256 && addr > 0) {
                IPAddrs[segCNT] = addr;
                backtrack(res, IPAddrs, s, segEnd + 1, segCNT + 1);
            } else {
                break;
            }
        }

    }

    public String buildIPAddr(int[] segments) {
        StringBuilder sb = new StringBuilder();
        for (int s : segments) {
            sb.append(s);
            sb.append(".");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

}
// @lc code=end
