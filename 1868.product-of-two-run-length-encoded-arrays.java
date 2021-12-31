/*
 * @lc app=leetcode id=1868 lang=java
 *
 * [1868] Product of Two Run-Length Encoded Arrays
 */

// @lc code=start

class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int p1 = 0, p2 = 0;
        List<List<Integer>> res = new ArrayList<>();

        while (p1 < encoded1.length) {
            int len = Math.min(encoded1[p1][1], encoded2[p2][1]);
            int mult = encoded1[p1][0] * encoded2[p2][0];
            // to handle cases like [[1,3],[2,3]] *[[6,3],[3,3]] --> [[6,6]]
            if (res.size() > 0 && res.get(res.size() - 1).get(0) == mult)
                // update previous mult in res
                // instead of adding a new one
                res.get(res.size() - 1).set(1, res.get(res.size() - 1).get(1) + len);

            else
                res.add(Arrays.asList(mult, len));

            encoded1[p1][1] -= len;
            encoded2[p2][1] -= len;
            if (encoded1[p1][1] == 0)
                p1++;
            if (encoded2[p2][1] == 0)
                p2++;
        }
        return res;
    }
}
// @lc code=end
