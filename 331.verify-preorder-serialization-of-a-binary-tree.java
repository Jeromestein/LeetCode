/*
 * @lc app=leetcode id=331 lang=java
 *
 * [331] Verify Preorder Serialization of a Binary Tree
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        int nodeCNT = 0, nullCNT = 0;
        String[] inputs = preorder.split(",");

        for (String in : inputs) {
            if (nullCNT > nodeCNT) {
                // for any binary tree, nullCNT=nodeCNT+1
                return false;
            }

            if (in.equals("#")) {
                nullCNT++;
            } else {
                nodeCNT++;
            }

        }

        if (nullCNT != nodeCNT + 1) {
            return false;
        } else {
            return true;
        }
    }
}
// @lc code=end
