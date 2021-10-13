/*
 * @lc app=leetcode id=1048 lang=java
 *
 * [1048] Longest String Chain
 */

// @lc code=start

class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Map<String, Integer> dp = new HashMap<>();

        // Sorting the list in terms of the word length.
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int longestWordSequenceLength = 1;

        for (int i = 0; i < n; i++) {
            String word = words[i];
            int presentLength = 1;
            // Find all possible predecessors for the current word by removing one letter at
            // a time.
            for (int j = 0; j < word.length(); j++) {
                StringBuilder temp = new StringBuilder(word);
                temp.deleteCharAt(j);

                int previousLength = dp.getOrDefault(temp.toString(), 0);
                presentLength = Math.max(presentLength, previousLength + 1);
            }
            dp.put(word, presentLength);
            longestWordSequenceLength = Math.max(longestWordSequenceLength, presentLength);
        }
        return longestWordSequenceLength;
    }
}

// @lc code=end
