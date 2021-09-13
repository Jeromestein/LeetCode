import java.util.Arrays;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        // Duplicate numbers should be counted distinctly.
        // 1 <= nums[i].length <= 100

        // 1. get the max length
        int maxLen = 0;
        for (String num : nums) {
            maxLen = Math.max(maxLen, num.length());
        }

        // 2. add the leading zeros
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].length() < maxLen) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                while (sb.length() < maxLen) {
                    sb.insert(0, '0');
                }
                nums[i] = sb.toString();
            }
        }

        // 3. sort
        Arrays.sort(nums);

        // 4. Return the string that represents the kth largest integer in nums.
        StringBuilder res = new StringBuilder();
        res.append(nums[nums.length - k]);
        // delete leading zeros before outputing
        while (res.charAt(0) == '0' && res.length() > 1) {
            res.deleteCharAt(0);
        }

        return res.toString();
    }
}