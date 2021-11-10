import java.util.Deque;

/*
 * @lc app=leetcode id=269 lang=java
 *
 * [269] Alien Dictionary
 */

// @lc code=start

class Solution {
    // 1. Extracting dependency rules from the input. For example "A must be before
    // C",
    // "X must be before D", or "E must be before B".
    // 2. Putting the dependency rules into a graph with letters as nodes and
    // dependencies as edges (an adjacency list is best).
    // 3. Topologically sorting the graph nodes.

    public String alienOrder(String[] words) {
        // Step 0: Create data structures and find all unique letters.
        // adjacent list
        Map<Character, List<Character>> adjList = new HashMap<>();
        // indegree
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }

        // Step 1: Find all edges.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check that word2 is not a prefix of word1.
            // which means a letter is samller than '', impossibel
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    inDegree.put(word2.charAt(j), inDegree.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        // Step 2: Breadth-first search.
        StringBuilder sb = new StringBuilder();
        Deque<Character> q = new LinkedList<>();
        for (Character c : inDegree.keySet()) {
            if (inDegree.get(c).equals(0)) {
                q.add(c);
            }
        }
        while (!q.isEmpty()) {
            Character c = q.poll();
            sb.append(c);
            for (Character next : adjList.get(c)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next).equals(0)) {
                    q.add(next);
                }
            }
        }

        // the size of indegree is the number of letters
        if (sb.length() < inDegree.size()) {
            return "";
        }

        return sb.toString();
    }
}
// @lc code=end
