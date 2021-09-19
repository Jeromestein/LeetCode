class Solution {
    public int countKDifference(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) == k)
                    cnt++;

            }
        }

        return cnt;
    }
}