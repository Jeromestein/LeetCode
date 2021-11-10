/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 */

// @lc code=start

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // no adjacent
        // walk through the flowerbed,
        // each time [i-1]!=1&&[i+1]!=1, cnt++, [i]=1; O(n)
        // return cnt>=n

        // 0 0 0 0 -> 1 0 1 0, 2
        // 1 0 0 0 0 0 1 -> 1 0 1 0 1 0 1, 2

        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            if (count >= n)
                return true;
            i++;
        }
        return false;

    }
}
// @lc code=end
