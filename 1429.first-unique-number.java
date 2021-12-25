/*
 * @lc app=leetcode id=1429 lang=java
 *
 * [1429] First Unique Number
 */

// @lc code=start

class FirstUnique {
    // LinkedHashSet support O(1) remove, even element is in the middle
    Set<Integer> setQueue = new LinkedHashSet<>();
    Map<Integer, Boolean> isUnique = new HashMap<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {

        if (!setQueue.isEmpty()) {
            return setQueue.iterator().next();
        } else {
            return -1;
        }
    }

    public void add(int value) {
        if (!isUnique.containsKey(value)) {
            isUnique.put(value, true);
            setQueue.add(value);
        } else if (isUnique.get(value)) {
            isUnique.put(value, false);
            setQueue.remove(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such: FirstUnique
 * obj = new FirstUnique(nums); int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
// @lc code=end
