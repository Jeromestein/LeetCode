import java.util.Arrays;

/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    // public boolean checkInclusion(String s1, String s2) {
    // int uniqueCNT = 0;
    // // s1 and s2 consist of lowercase English letters.
    // int[] s1charCNT = new int[26];
    // int[] s2charCNT = new int[26];

    // // reset charCNT
    // Arrays.fill(s1charCNT, 0);
    // Arrays.fill(s2charCNT, 0);

    // for (int i = 0; i < s1.length(); i++) {
    // int idx = s1.charAt(i) - 'a';
    // if (s1charCNT[idx] == 0) {
    // uniqueCNT++;
    // }
    // s1charCNT[idx]++;
    // }

    // int start = 0, end = 0;

    // int currUniqueCNT = 1;
    // s2charCNT[s2.charAt(end) - 'a']++;
    // while (end < s2.length() && start < s2.length() - s1.length() + 1) {
    // if (currUniqueCNT < uniqueCNT) {
    // end++;
    // if (end < s2.length()) {
    // int idx = s2.charAt(end) - 'a';
    // if (s2charCNT[idx] == 0) {
    // currUniqueCNT++;
    // }
    // s2charCNT[idx]++;
    // }

    // }
    // if (currUniqueCNT == uniqueCNT && !Arrays.equals(s1charCNT, s2charCNT)) {
    // // T(n) of Arrays.equals(,) is O(1), the size of two arrays is both 26.
    // int idx = s2.charAt(start) - 'a';
    // s2charCNT[idx]--;
    // if (s2charCNT[idx] == 0) {
    // currUniqueCNT--;
    // }
    // start++;
    // }
    // if (currUniqueCNT == uniqueCNT && Arrays.equals(s1charCNT, s2charCNT)) {
    // return true;
    // }

    // // System.out.println(start + " " + end + " " + currUniqueCNT);

    // }

    // return false;
    // }

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
