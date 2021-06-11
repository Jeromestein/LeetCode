/*
 * @lc app=leetcode id=969 lang=java
 *
 * [969] Pancake Sorting
 */

// @lc code=start
class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int x = A.length, i; x > 0; x--) {
            // if the (x-1)th element is xth biggest element
            // then need no reverse
            if (A[x - 1] != x) {
                // find the xth biggest element
                for (i = A.length - 2; A[i] != x; i--)
                    ;
                // reverse1 make the xth biggest element become the first element
                reverse(A, i + 1);
                res.add(i + 1);
                // reverse2 make xth biggest element the (x-1)th element
                reverse(A, x);
                res.add(x);
            }
        }
        return res;
    }

    public void reverse(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }

    // public List<Integer> pancakeSort(int[] arr) {
    // Stack<Integer> stack = new Stack<>();
    // int n = arr.length;
    // int[] idx = new int[n];
    // for (int i = 0; i < n; i++)
    // idx[arr[i] - 1] = i;

    // for (int i = 0; i < n; i++) {
    // dew(stack, i, idx[i]);

    // int temp = idx[i];
    // idx[arr[i] - 1] = temp;
    // idx[i] = i;
    // arr[temp] = arr[i];

    // arr[i] = i + 1;
    // }

    // LinkedList<Integer> ans = new LinkedList<>();
    // while (!stack.isEmpty()) {
    // int x = stack.pop();
    // ans.addFirst(x);
    // }
    // return ans;
    // }

    // private void dew(Stack<Integer> stack, int j, int i) {
    // if (i != j) {
    // add(stack, i + 1);
    // add(stack, i - j + 1);
    // add(stack, i - j);
    // add(stack, i - j - 1);
    // add(stack, i - j);
    // add(stack, i + 1);
    // }
    // }

    // private void add(Stack<Integer> stack, int x) {
    // if (x > 1) {
    // if (!stack.isEmpty() && stack.peek() == x)
    // stack.pop();
    // else
    // stack.push(x);
    // }
    // }
}
// @lc code=end
