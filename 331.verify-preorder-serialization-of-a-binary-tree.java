/*
 * @lc app=leetcode id=331 lang=java
 *
 * [331] Verify Preorder Serialization of a Binary Tree
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        int nodeCNT = 0, nullCNT = 0;

        for (int i = 0; i < preorder.length(); i++) {
            if (nullCNT > nodeCNT) {
                // for any binary tree, nullCNT=nodeCNT+1
                return false;
            }

            if (preorder.charAt(i) != ',') {
                if (preorder.charAt(i) == '#') {
                    // receive a null
                    nullCNT++;
                } else {
                    // receive a node
                    nodeCNT++;
                    while (i < preorder.length() && preorder.charAt(i) != ',') {
                        i++;
                    }
                }
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
