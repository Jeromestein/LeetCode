import java.util.ArrayList;
import java.util.Set;

/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {

    String allVowels = new String("AEIOUaeiou");

    public String reverseVowels(String s) {
        ArrayList<Integer> vowels = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (allVowels.contains(s.substring(i, i + 1))) {
                vowels.add(i);
            }
        }
        StringBuilder res = new StringBuilder(s);
        int i = 0, j = vowels.size() - 1;
        while (i < j) {
            res.setCharAt(vowels.get(i), s.charAt(vowels.get(j)));
            res.setCharAt(vowels.get(j), s.charAt(vowels.get(i)));
            i++;
            j--;
        }
        return res.toString();
    }
}
// @lc code=end
