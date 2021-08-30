import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {
    Set<Integer> set;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /**
     * Get a random element from the set. Each element must have the same
     * probability of being returned.
     */
    public int getRandom() {
        Object[] nums = set.toArray();

        Random random = new Random();
        int upper = set.size() - 1, lower = 0;
        int randIndex = random.nextInt(upper - lower + 1) + lower;

        return (int) nums[randIndex];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
// @lc code=end
