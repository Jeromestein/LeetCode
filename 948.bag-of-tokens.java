/*
 * @lc app=leetcode id=948 lang=java
 *
 * [948] Bag of Tokens
 */

// @lc code=start
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // 1. sort it ascendingly
        // 2. check the min tokens < power
        // 3. 2 pointers? left: -=tokens[i], score++; right: +=tokens[i], score--
        Arrays.sort(tokens);

        int left = 0, right = tokens.length - 1;
        int score = 0, maxScore = 0;
        // We should always play tokens face up until exhaustion,
        // then play one token face down and continue.
        while (left <= right && (power >= tokens[left] || score > 0)) {
            while (left <= right && power >= tokens[left]) {
                power -= tokens[left];
                left++;
                score++;
                maxScore = Math.max(maxScore, score);
            }

            if (left <= right && score > 0) {
                power += tokens[right];
                right--;
                score--;
            }
        }

        return maxScore;
    }
}
// @lc code=end
