public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int maxLen = 0;
        for (int i : L) {
            maxLen = Math.max(maxLen, i);
        }

        int left = 1, right = maxLen;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (getK(L, mid) >= k) {
                res = Math.max(res, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    public int getK(int[] L, int mid) {
        int k = 0;
        for (int i : L) {
            k += i / mid;
        }

        return k;
    }
}