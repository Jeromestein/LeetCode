import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = k - 1;
        int min = Integer.MAX_VALUE;

        while (right < nums.length) {
            min = Math.min(min, nums[right] - nums[left]);

            left++;
            right++;
        }

        return min;
    }
}