import java.util.HashSet;
import java.util.Set;

class Solution {
    // 1 <= target <= 800
    int min = 800;

    public int minimizeTheDifference(int[][] mat, int target) {
        dfs(mat, 0, target, 0);
        return min;
    }

    public void dfs(int[][] mat, int currRow, int target, int currSum) {
        // 1 <= m, n <= 70
        int m = mat.length, n = mat[0].length;
        // 1 <= mat[i][j] <= 70

        if (min == 0) {
            return;
        }

        if (currRow == m) {
            int diff = Math.abs(target - currSum);
            min = Math.min(min, diff);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < n; j++) {

            int newSum = currSum + mat[currRow][j];
            if (set.contains(newSum)) {
                continue;
            } else {
                dfs(mat, currRow + 1, target, newSum);
            }

        }
    }
}
