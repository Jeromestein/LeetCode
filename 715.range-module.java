/*
 * @lc app=leetcode id=715 lang=java
 *
 * [715] Range Module
 */

// @lc code=start
class RangeModule {
    TreeSet<Interval> ranges;

    /* Initializes the object of the data structure. */
    public RangeModule() {
        ranges = new TreeSet();
    }

    /**
     * Adds the half-open interval [left, right), tracking every real number in that
     * interval. Adding an interval that partially overlaps with currently tracked
     * numbers should add any numbers in the interval [left, right) that are not
     * already tracked.
     * 
     * @param left
     * @param right
     */
    public void addRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left - 1)).iterator();
        while (itr.hasNext()) {
            Interval iv = itr.next();
            if (right < iv.left)
                break;
            left = Math.min(left, iv.left);
            right = Math.max(right, iv.right);
            itr.remove();
        }
        ranges.add(new Interval(left, right));
    }

    /**
     * Returns true if every real number in the interval [left, right) is currently
     * being tracked, and false otherwise.
     * 
     * @param left
     * @param right
     * @return
     */
    public boolean queryRange(int left, int right) {
        Interval iv = ranges.higher(new Interval(0, left));
        return (iv != null && iv.left <= left && right <= iv.right);
    }

    /**
     * Stops tracking every real number currently being tracked in the half-open
     * interval [left, right).
     * 
     * @param left
     * @param right
     */
    public void removeRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left)).iterator();
        ArrayList<Interval> todo = new ArrayList();
        while (itr.hasNext()) {
            Interval iv = itr.next();
            if (right < iv.left)
                break;
            if (iv.left < left)
                todo.add(new Interval(iv.left, left));
            if (right < iv.right)
                todo.add(new Interval(right, iv.right));
            itr.remove();
        }
        for (Interval iv : todo)
            ranges.add(iv);
    }
}

class Interval implements Comparable<Interval> {
    int left;
    int right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int compareTo(Interval that) {
        if (this.right == that.right)
            return this.left - that.left;
        return this.right - that.right;
    }
}

/**
 * Your RangeModule object will be instantiated and called as such: RangeModule
 * obj = new RangeModule(); obj.addRange(left,right); boolean param_2 =
 * obj.queryRange(left,right); obj.removeRange(left,right);
 */
// @lc code=end
