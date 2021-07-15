import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        // 这个数组用于记录每行中皇后所在的位置
        int[] queens = new int[n];
        // 官方在这里用-1填充queens数组，但是和下面的状态重置一样，没有必要
        // Arrays.fill(queens,-1);
        List<List<String>> results = new ArrayList<>();
        solveNQueens(results, queens, n, 0, 0, 0, 0);
        return results;
    }

    /**
     * int n：总行数 int row：当前行数 int columns：不可选的列 int diagonals1：不可选的左斜边 int
     * diagonals2：不可选的右斜边
     */
    public void solveNQueens(List<List<String>> results, int[] queens, int n, int row, int columns, int diagonals1,
            int diagonals2) {
        // 如果能到达这一步，说明搜索已经到底了，我们已经记录下了一个可行的方案
        if (row == n) {
            // 直接生成一个结果，并放入结果集中
            results.add(generateString(queens));
            // 方法终止
            return;
        }
        // 1<<n-1 是为了转化一个长度为n的，每位上都是1的二进制数，用于定位可以放置皇后的位置
        // 这里用于定位所有可选的位置，这里有一步取反，千万不要忽视了！
        // 上面我们用 1 表示不可选的位置，但是这里我们取反后，用1表示可选的位置
        int availableLocations = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
        // 我们通过下面的操作来保持之前所有的行对下一行的影响
        // 左斜边因为下降了一行需要左移一位
        diagonals1 <<= 1;
        // 右斜边因为下降了一行需要右移一位
        diagonals2 >>= 1;
        // 开始检查每个可选的位置
        while (availableLocations != 0) {
            // 定位最后一个1的位置，这个操作可以自己手写验证一下（不要忘了把负数转成补码）
            // 这个定位的意思是，生成的这个二进制数只有最后一个1还为1，其他位都变成了0
            int position = availableLocations & (-1 * availableLocations);
            // 这个方法是统计一个二进制数中所有的“1”的个数
            int columnNum = Integer.bitCount(position - 1);
            // 将这个位置添加到记录数组中
            queens[row] = columnNum;
            // 将这一位从可选取的位中移除
            // 减1把最后一个1拆成后面的多个1，再经过一次与操作把这些多出来的1全部清除
            availableLocations = availableLocations & (availableLocations - 1);
            // 沿着这个位置向下搜索，可选行和可选列的直接在参数上变化即可，这样就不需要手动重置状态了
            solveNQueens(results, queens, n, row + 1, columns | position, diagonals1 | position << 1,
                    diagonals2 | position >> 1);
            // 官方在这里曾经重置过数组queens的状态，但实际上没这个必要，每次循环上一次的结果都会被覆盖
            // queens[row]=-1;
        }
    }

    // 生成字符串
    public List<String> generateString(int[] queens) {
        List<String> result = new ArrayList<>();
        for (int i : queens) {
            char[] chars = new char[queens.length];
            Arrays.fill(chars, '.');
            chars[i] = 'Q';
            result.add(String.valueOf(chars));
        }
        return result;
    }
}
// @lc code=end
