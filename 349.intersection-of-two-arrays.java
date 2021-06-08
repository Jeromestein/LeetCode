import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] flag = new boolean[1001];
        for (int num : nums1) {
            flag[num] = true;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (flag[num] == true) {
                list.add(num);
                flag[num] = false;
            }
        }
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // public int[] intersection(int[] nums1, int[] nums2) {
    // HashSet<Integer> set1 = new HashSet<Integer>();
    // for (Integer n : nums1)
    // set1.add(n);
    // HashSet<Integer> set2 = new HashSet<Integer>();
    // for (Integer n : nums2)
    // set2.add(n);

    // // get the intersections
    // set1.retainAll(set2);

    // int[] output = new int[set1.size()];
    // int idx = 0;
    // for (int s : set1)
    // output[idx++] = s;
    // return output;
    // }
}
// @lc code=end
