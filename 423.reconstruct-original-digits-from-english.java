/*
 * @lc app=leetcode id=423 lang=java
 *
 * [423] Reconstruct Original Digits from English
 */

// @lc code=start

class Solution {
    public String originalDigits(String s) {
        // building hashmap letter -> its frequency
        char[] count = new char[26 + (int) 'a'];
        for (char letter : s.toCharArray()) {
            count[letter]++;
        }

        // building hashmap digit -> its frequency
        int[] digitsCNT = new int[10];
        // letter "z" is present only in "zero"
        digitsCNT[0] = count['z'];
        // letter "w" is present only in "two"
        digitsCNT[2] = count['w'];
        // letter "u" is present only in "four"
        digitsCNT[4] = count['u'];
        // letter "x" is present only in "six"
        digitsCNT[6] = count['x'];
        // letter "g" is present only in "eight"
        digitsCNT[8] = count['g'];
        // letter "h" is present only in "three" and "eight"
        digitsCNT[3] = count['h'] - digitsCNT[8];
        // letter "f" is present only in "five" and "four"
        digitsCNT[5] = count['f'] - digitsCNT[4];
        // letter "s" is present only in "seven" and "six"
        digitsCNT[7] = count['s'] - digitsCNT[6];
        // letter "i" is present in "nine", "five", "six", and "eight"
        digitsCNT[9] = count['i'] - digitsCNT[5] - digitsCNT[6] - digitsCNT[8];
        // letter "n" is present in "one", "nine", and "seven"
        digitsCNT[1] = count['n'] - digitsCNT[7] - 2 * digitsCNT[9];

        // building output string
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < digitsCNT[i]; j++)
                res.append(i);

        return res.toString();
    }
}

// @lc code=end
