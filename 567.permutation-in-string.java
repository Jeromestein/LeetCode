import java.util.Arrays;

/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    // checks if frequency of all chars in both array is same or not
    // faster than Arrays.equals()
    private boolean isSame(int[] A, int[] B) {
        for (int i = 0; i < 26; i++) {
            if (A[i] != B[i])
                return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        // c1[i] seems a bit fastere than s1.charAt(i)
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int l1 = c1.length;
        int l2 = c2.length;

        if (l2 < l1)
            return false;

        int[] s1CharCNT = new int[26];
        int[] s2CharCNT = new int[26];

        // for-loop to get frequency counts of length l1 from both strings
        // i.e. first sliding window.
        for (int i = 0; i < l1; i++) {
            s1CharCNT[c1[i] - 'a']++;
            s2CharCNT[c2[i] - 'a']++;
        }

        if (isSame(s1CharCNT, s2CharCNT))
            return true;

        // check for next sliding windows.
        for (int i = 1; i <= l2 - l1; i++) {
            // decrement frequency of first char in last sliding window
            s2CharCNT[c2[i - 1] - 'a']--;

            // increment frequency of char newly visited in curr sliding window
            s2CharCNT[c2[i + l1 - 1] - 'a']++;

            // check for this sliding window
            if (isSame(s1CharCNT, s2CharCNT))
                return true;
        }
        return false;
    }
}
// @lc code=end
