import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=425 lang=java
 *
 * [425] Word Squares
 */

// @lc code=start

class Solution {
    int wordLen = 0;
    String[] words = null;
    Map<String, List<String>> prefixMap = null;

    public List<List<String>> wordSquares(String[] words) {
        // based on backtracking method

        // 1. In the first part, we add a new function buildPrefixHashTable(words)
        // to build a hashtable out of the input words.

        // 2. Then in the second part, in the function getWordsWithPrefix(),
        // we simply query the hashtable to retrieve all the words that possess the
        // given prefix.

        this.words = words;
        this.wordLen = words[0].length();

        List<List<String>> res = new ArrayList<>();
        // build prefixMap
        prefixMap = new HashMap<>();

        for (String word : words) {
            for (int i = 1; i < wordLen; ++i) {
                String prefix = word.substring(0, i);
                prefixMap.computeIfAbsent(prefix, v -> new ArrayList<>()).add(word);
            }
        }

        // try each word in the first line
        for (String word : words) {
            List<String> wordSquares = new ArrayList<>();
            wordSquares.add(word);
            backtracking(1, wordSquares, res);
        }
        return res;
    }

    public void backtracking(int step, List<String> wordSquares, List<List<String>> res) {
        if (step == wordLen) {
            // can derectly add(wordSquares), should create a new list, like clone()
            res.add(new ArrayList<>(wordSquares));
            return;
        }

        // get the prefix of current square
        StringBuilder prefix = new StringBuilder();
        for (String word : wordSquares) {
            prefix.append(word.charAt(step));
        }

        // get the candidates from the prefix
        List<String> candidates = prefixMap.computeIfAbsent(prefix.toString(), v -> new ArrayList<>());
        for (String candidate : candidates) {
            wordSquares.add(candidate);
            backtracking(step + 1, wordSquares, res);
            wordSquares.remove(wordSquares.size() - 1);
        }
    }
}

// @lc code=end
