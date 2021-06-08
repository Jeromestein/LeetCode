import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0));
        }

        for (int num : nums2) {
            if (map.get(num) != null) {
                map.put(num, map.get(num) + 1);
            }

        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() > 0)
                cnt++;
        }
        int[] res = new int[cnt];
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() > 0) {
                res[--cnt] = i.getKey();
            }
        }
        return res;
    }
}
// @lc code=end
