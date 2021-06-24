import java.util.ArrayList;
import java.util.List;

i

/*
 * @lc app=leetcode id=352 lang=java
 *
 * [352] Data Stream as Disjoint Intervals
 */

// @lc code=start
class SummaryRanges {
    private List<int[]> intervalList;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        intervalList = new ArrayList<>();
    }

    public void addNum(int val) {
        int count = 0;
        boolean isAdded = false;
        for (int i = 0; i < intervalList.size(); i++) {
            if (intervalList.get(i)[0] <= val && intervalList.get(i)[1] >= val) {
                // val is included.
                isAdded = true;
                break;
            }            

            if (intervalList.get(i)[1] == val - 1) {
                isAdded = true;
                if ((i == intervalList.size() - 1 || intervalList.get(i + 1)[0] != val + 1)) {
                    // extends
                    intervalList.get(i)[1] = val;
                } else {
                    // joins
                    intervalList.get(i)[1] = intervalList.get(i + 1)[1];
                    intervalList.remove(i + 1);
                }
                break;
            } else if (intervalList.get(i)[0] == val + 1) {
                isAdded = true;
                intervalList.get(i)[0] = val;
                break;
            }

            if (intervalList.get(i)[0] >= val + 2)
                break;

            count++;
        }
        if (!isAdded) {
            intervalList.add(count, new int[] { val, val });
        }
    }

    public int[][] getIntervals() {

        return intervalList.toArray(new int[intervalList.size()][]);
    }
}
/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges(); obj.addNum(val); int[][] param_2 =
 * obj.getIntervals();
 */
// @lc code=end
