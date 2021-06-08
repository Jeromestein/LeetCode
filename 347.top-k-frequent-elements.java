import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            } else if (num < min) {
                min = num;
            }
        }

        // get element index
        // !! so the Space will be save!
        // and all the index will be positive !!!
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }

        // O(n*log(k))
        // to find the k element index
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (pq.size() < k) {
                    pq.add(count[i]);
                } else {
                    // peek() get the front element in queue
                    if (pq.peek() < count[i]) {
                        pq.add(count[i]);
                        pq.remove();
                    }
                }
                // System.out.println(pq);
            }
        }

        int[] res = new int[k];
        int i = 0;
        // O(n)
        // You may return the answer in any order.
        for (int ix = 0; ix < count.length; ix++) {
            if (count[ix] > 0 && count[ix] >= pq.peek()) {

                res[i] = ix + min;
                i++;
                if (i == k) {
                    return res;
                }
            }
        }

        // O(n * (2 + log(k)))
        return res;
    }
}
// @lc code=end
