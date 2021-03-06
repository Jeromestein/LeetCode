/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start

// mySolution: O(logn+m), m is the no. of taget elements.
// However, in the worst case, m may be n, so it becomes O(n)
/*
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (target == nums[pivot]) {
                int start = pivot;
                int end = pivot;
                while (start - 1 >= 0 && nums[start - 1] == target)
                    start--;
                while (end + 1 <= nums.length - 1 && nums[end + 1] == target)
                    end++;
                return new int[] { start, end };
            } else if (target < nums[pivot]) {
                right = pivot - 1;
            } else if (target > nums[pivot]) {
                left = pivot + 1;
            }
        }
        return new int[] { -1, -1 };
    }
}*/

class Solution {
    // binary search twice: find the fisrt one, and find the last one
    // O(2logn), which is O(logn)
    public int[] searchRange(int[] nums, int target) {
        int start = findFirstGorE(nums, target);
        // 1. if target is greater than all the elements in nums[],
        // the return should be A.length
        // 2. if there is no target in nums[],
        // return nums[x], which is closest to but greater than target
        if (start == nums.length || nums[start] != target) {
            return new int[] { -1, -1 };
        }

        int end = findFirstGorE(nums, target + 1) - 1;
        return new int[] { start, end };
    }

    // find the first number that is greater than or equal to target.
    // could return A.length if target is greater than A[A.length-1].
    // actually this is the same as lower_bound in C++ STL.
    public static int findFirstGorE(int[] A, int target) {
        // if target is greater than all the elements in A[],
        // the return should be A.length
        int left = 0, right = A.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // left <= mid < right
            if (A[mid] < target) {
                left = mid + 1;
            } else {
                // it should be hi = mid rather than hi = mid-1,
                // bacause it might be A[mid]==target.
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end
