import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        // if the endWord is not in wordList,
        // there is no valid transformation sequence.
        if (!wordSet.contains(endWord))
            return res;

        Map<String, Integer> stepMap = new HashMap<>();
        stepMap.put(beginWord, 0);
        Map<String, List<String>> parentsMap = new HashMap<>();
        parentsMap.put(beginWord, new ArrayList<>());

        // bfs
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        boolean isFoundEnd = false;
        for (int step = 1; !q.isEmpty() && !isFoundEnd; step++) {
            int currLevelSize = q.size();
            // level order traversal
            for (int i = 0; i < currLevelSize; i++) {
                String currWord = q.poll();
                char[] wordArray = currWord.toCharArray();
                int wordLen = currWord.length();

                // find next level words
                // beginWord, endWord, and wordList[i] consist of lowercase English letters
                for (int j = 0; j < wordLen; j++) {
                    char temp = wordArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String nextWord = String.valueOf(wordArray);

                        if (stepMap.containsKey(nextWord) && stepMap.get(nextWord) == step) {
                            parentsMap.get(nextWord).add(currWord);
                        }
                        // only if it exists in word set/list
                        if (wordSet.contains(nextWord)) {
                            q.add(nextWord);
                            // remove form word set, so each word get samllest step
                            wordSet.remove(nextWord);
                            stepMap.put(nextWord, step);

                            // set currWord as nextWord's parent
                            parentsMap.putIfAbsent(nextWord, new ArrayList<>());
                            parentsMap.get(nextWord).add(currWord);

                            if (nextWord.equals(endWord)) {
                                isFoundEnd = true;
                            }
                        }
                    }
                    wordArray[j] = temp;
                }
            }
        }

        if (isFoundEnd) {
            // use backtrack to get its path
            Deque<String> path = new LinkedList<>();
            path.addFirst(endWord);
            backtrack(res, path, parentsMap, beginWord, endWord);
        }

        return res;
    }

    public void backtrack(List<List<String>> res, Deque<String> path, Map<String, List<String>> parentsMap,
            String beginWord, String currWord) {
        if (currWord.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (String parentWord : parentsMap.get(currWord)) {
            path.addFirst(parentWord);
            backtrack(res, path, parentsMap, beginWord, parentWord);
            path.removeFirst();
        }
    }
}
// @lc code=end
