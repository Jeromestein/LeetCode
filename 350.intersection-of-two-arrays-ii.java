import java.util.ArrayList;

/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] cnt = new int[1001];
        for (int num : nums1) {
            cnt[num]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (cnt[num] > 0) {
                list.add(num);
                cnt[num]--;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
// @lc code=end
