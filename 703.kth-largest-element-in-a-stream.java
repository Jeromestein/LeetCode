import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */

// @lc code=start

class KthLargest {
    final PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val);
        } else {
            // size == k
            if (minHeap.peek() < val) {
                // if the top node < val
                // remove top node
                minHeap.poll();
                // add val
                minHeap.add(val);
            }
        }
        return minHeap.peek();
    }
}
/**
 * Your KthLargest object will be instantiated and called as such: KthLargest
 * obj = new KthLargest(k, nums); int param_1 = obj.add(val);
 */
// @lc code=end
