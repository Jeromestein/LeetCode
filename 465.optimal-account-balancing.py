#
# @lc app=leetcode id=465 lang=python3
#
# [465] Optimal Account Balancing
#

# @lc code=start

class Solution:
    def minTransfers(self, transactions: List[List[int]]) -> int:
        balance_map = collections.defaultdict(int)
        for a, b, amount in transactions:
            balance_map[a] += amount
            balance_map[b] -= amount
        
        balance_list = [amount for amount in balance_map.values() if amount!=0]
        n = len(balance_list)
        
        # start from cur-th account, the min transactions we need to clean the debt
        def dfs(cur):
            while cur < n and balance_list[cur]==0:
                cur += 1
            if cur == n:
                return 0
            cost = float('inf')
            for nxt in range(cur + 1, n):
                # If nxt is a valid recipient, do the following: 
                # 1. add cur's balance to nxt.
                # 2. recursively call dfs(cur + 1).
                # 3. remove cur's balance from nxt.
                if balance_list[nxt] * balance_list[cur] < 0:
                    balance_list[nxt] += balance_list[cur]
                    cost = min(cost, 1 + dfs(cur + 1))
                    balance_list[nxt] -= balance_list[cur]
            return cost
        
        return dfs(0)

# @lc code=end

