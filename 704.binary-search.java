
/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int front = 0, rear = nums.length - 1;
        while (front != rear) {
            int index = (front + rear) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] > target) {
                if (index > 0) {
                    rear = index - 1;
                } else {
                    rear = 0;
                }
            } else if (nums[index] < target) {
                if (front < nums.length - 1) {
                    front = index + 1;
                } else {
                    front = nums.length - 1;
                }
            }
        }
        if (front == rear) {
            if (nums[front] == target)
                return front;
            else
                return -1;
        }
        throw new IllegalArgumentException("No Solution");
    }
}
// @lc code=end
