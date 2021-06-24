import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=352 lang=java
 *
 * [352] Data Stream as Disjoint Intervals
 */

// @lc code=start
class SummaryRanges {
    // uniqueness
    Set<Integer> nums;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        // uniqueness & orderliness
        nums = new TreeSet<>();
    }

    public void addNum(int val) {
        nums.add(val);
    }

    public int[][] getIntervals() {
        ArrayList<int[]> res = new ArrayList<>();
        // uniqueness & orderliness
        Iterator<Integer> i = nums.iterator();
        int start = i.next(), end = start;

        for (int num : nums) {
            if (num > end + 1) {
                res.add(new int[] { start, end });
                start = num;
                end = num;
            } else {
                end = num;
            }
        }
        // put the rest { start, end } into res
        res.add(new int[] { start, end });
        return res.toArray(new int[res.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges(); obj.addNum(val); int[][] param_2 =
 * obj.getIntervals();
 */
// @lc code=end
