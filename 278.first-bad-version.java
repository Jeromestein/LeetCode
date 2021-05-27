import jdk.internal.vm.compiler.word.Pointer;

/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int pivot = left + (right - left) / 2;
            if (isBadVersion(pivot) == true) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }

        return left;
    }
}
// @lc code=end
