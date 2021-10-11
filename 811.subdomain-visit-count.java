import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=811 lang=java
 *
 * [811] Subdomain Visit Count
 */

// @lc code=start

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap();

        for (String str : cpdomains) {
            // cpNdom[0]: no. pairs; cpNdom[1]: domain
            String[] cpNdom = str.split(" ");
            String[] domains = cpNdom[1].split("\\.");
            int count = Integer.valueOf(cpNdom[0]);
            String currDomain = "";
            for (int i = domains.length - 1; i >= 0; --i) {
                currDomain = domains[i] + (i < domains.length - 1 ? "." : "") + currDomain;
                map.put(currDomain, map.getOrDefault(currDomain, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (String dom : map.keySet())
            ans.add(map.get(dom) + " " + dom);
        return ans;
    }
}
// @lc code=end
