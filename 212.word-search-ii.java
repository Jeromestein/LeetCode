import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word = null;

    public TrieNode() {
    }
}

class Solution {
    char[][] _board = null;
    int _rows, _cols;
    List<String> _result = new ArrayList<String>();

    public List<String> findWords(char[][] board, String[] words) {

        // Step 1). Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (Character letter : word.toCharArray()) {
                // if no node associated to letter, then create a new one
                // return the node associated to letter.
                node = node.children.computeIfAbsent(letter, newNode -> new TrieNode());
            }
            node.word = word; // store words in Trie
        }

        this._board = board;
        _rows = board.length;
        _cols = board[0].length;
        // Step 2). Backtracking starting for each cell in the board
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }

        return this._result;
    }

    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = this._board[row][col];
        TrieNode currNode = parent.children.get(letter);

        // check if there is any match
        if (currNode.word != null) {
            this._result.add(currNode.word);
            currNode.word = null;
        }

        // mark the current letter before the EXPLORATION
        this._board[row][col] = '#';

        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = { -1, 0, 1, 0 };
        int[] colOffset = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; ++i) {
            int nr = row + rowOffset[i];
            int nc = col + colOffset[i];
            if (0 <= nr && nr < this._rows && 0 <= nc && nc < this._cols) {
                if (currNode.children.containsKey(this._board[nr][nc])) {
                    backtracking(nr, nc, currNode);
                }
            }
        }

        // End of EXPLORATION, restore the original letter in the board.
        this._board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}

// @lc code=end
