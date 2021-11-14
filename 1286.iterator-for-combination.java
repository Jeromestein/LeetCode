/*
 * @lc app=leetcode id=1286 lang=java
 *
 * [1286] Iterator for Combination
 */

// @lc code=start

class CombinationIterator {
    // build the map of order and char
    int[] nums;
    String chars;

    boolean has_next;
    // n is no. of letters
    // k is combination Length
    int n, k;

    // O(k)
    public CombinationIterator(String characters, int combinationLength) {
        n = characters.length();
        k = combinationLength;
        chars = characters;

        // init the first combination
        has_next = true;
        nums = new int[k];
        for (int i = 0; i < k; ++i) {
            nums[i] = i;
        }
    }

    // O(k)
    public String next() {
        // Convert nums into the combination to save.
        StringBuilder curr = new StringBuilder();
        for (int j : nums) {
            curr.append(chars.charAt(j));
        }

        // Generate next combination:
        // 1. From right to left, find the first j such that nums[j] != n - k + j.
        int j = k - 1;
        // it's combination not premutaion
        while (j >= 0 && nums[j] == n - k + j) {
            j--;
        }

        if (j >= 0) {
            // 2. Increase nums[j] by one.
            nums[j]++;
            // 3. Set nums[i] = nums[i - 1] + 1
            // for every i in range (j + 1, k) to move to the next combination.
            for (int i = j + 1; i < k; i++) {
                nums[i] = nums[i - 1] + 1;
            }
        } else {
            has_next = false;
        }

        return curr.toString();
    }

    // O(1)
    public boolean hasNext() {
        return has_next;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters,
 * combinationLength); String param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */
// @lc code=end
