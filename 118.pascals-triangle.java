import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();

            if (res.isEmpty()) {
                temp.add(1);
            } else {
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        temp.add(1);
                    } else {
                        List<Integer> preLine = res.get(i - 1);
                        int left = preLine.get(j - 1);
                        int right = preLine.get(j);

                        temp.add(left + right);
                    }
                }
            }

            res.add(temp);
        }

        return res;
    }
}
// @lc code=end
