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
        List<String> ans = new ArrayList<String>();
        int[] IP = new int[4];
        backtrack(ans, IP, s, 0, 0);
        return ans;
    }

    public void backtrack(List<String> ans, int[] IP, String s, int segCNT, int idx) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segCNT == 4) {
            if (idx == s.length()) {
                ans.add(buildStrIPAddr(IP));
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (idx == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(idx) == '0') {
            IP[segCNT] = 0;
            backtrack(ans, IP, s, segCNT + 1, idx + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;

        for (int segEnd = idx; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + s.charAt(segEnd) - '0';
            if (addr > 0 && addr < 256) {
                IP[segCNT] = addr;
                backtrack(ans, IP, s, segCNT + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

    public String buildStrIPAddr(int[] IP) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < 4; ++i) {
            str.append(IP[i]);

            str.append('.');
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }
}
// @lc code=end
