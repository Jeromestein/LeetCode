## 递归实现会比循环遍历在面试中扣分吗？
[https://www.1point3acres.com/bbs/thread-774698-1-1.html](https://www.1point3acres.com/bbs/thread-774698-1-1.html)

简单的可能会被要求iterative实现，典型例子如前中后序的树遍历、bottom-up DP、楼主说的binary search等等。

逻辑复杂的backtracking、图和树的DFS、divide and conquer、quicksort / merge sort等就大胆写recursive吧。你让面试官写iterative他也不一定写得出。

觉得不放心就直接问他是想要recursive还是iterative呗。

## A general approach to backtracking questions in Java (Subsets, Permutations, Combination Sum, Palindrome Partioning)
[https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)](https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-\(Subsets-Permutations-Combination-Sum-Palindrome-Partioning\))


## PQ & Heap
![Pasted image 20250619112149.png](app://c55455f731bb44b193cabda799901361c75d/Users/plusone/Documents/Obsidian%20Vault/Pasted%20image%2020250619112149.png?1750357309121)


// sort in int[0]'s increasing order

PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);


## Sorts' Time&Space Complexity
![Pasted image 20250619112041.png](app://c55455f731bb44b193cabda799901361c75d/Users/plusone/Documents/Obsidian%20Vault/Pasted%20image%2020250619112041.png?1750357241505)

Arrays.sort() is based on merge or quick, which use O(n) space. So we can use heap to sort it.

