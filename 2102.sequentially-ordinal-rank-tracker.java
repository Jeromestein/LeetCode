/*
 * @lc app=leetcode id=2102 lang=java
 *
 * [2102] Sequentially Ordinal Rank Tracker
 */

// @lc code=start

// max-min heap
class SORTracker {
    class Location {
        String name;
        int score;

        public Location(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    PriorityQueue<Location> max;
    PriorityQueue<Location> min;

    public SORTracker() {
        min = new PriorityQueue<>(
                (l1, l2) -> l1.score == l2.score ? l2.name.compareTo(l1.name) : l1.score - l2.score);
        max = new PriorityQueue<>(
                (l1, l2) -> l1.score == l2.score ? l1.name.compareTo(l2.name) : l2.score - l1.score);
    }

    // O(logn)
    public void add(String name, int score) {
        min.add(new Location(name, score));
        Location lameOne = min.poll();
        max.add(lameOne);
    }

    // O(1)
    public String get() {
        Location bestOne = max.poll();
        min.add(bestOne);
        return min.peek().name;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */
// @lc code=end
