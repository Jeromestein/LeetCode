#
# @lc app=leetcode id=76 lang=python3
#
# [76] Minimum Window Substring
#

# @lc code=start
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        n, m = len(s), len(t)
        if n < m:
            return ""

        cnt=Counter(t)
        curr_cnt=defaultdict(int)

        filtered_s=[]
        for i in range(n):
            if s[i] in cnt:
                filtered_s.append((i, s[i]))

        left, right = 0, 0
        formed=0
        res=float("inf"), 0,0
        
        while right < len(filtered_s):
            char = filtered_s[right][1]
            curr_cnt[char]+=1

            if curr_cnt[char]==cnt[char]:
                formed+=1

            while left <= right and formed == len(cnt):
                char = filtered_s[left][1]

                start = filtered_s[left][0]
                end = filtered_s[right][0]
                if end-start+1 < res[0]:
                    res=(end-start+1,start,end)
                
                curr_cnt[char]-=1
                if curr_cnt[char]<cnt[char]:
                    formed-=1
                
                left+=1
            
            right+=1

        if res[0] == float("inf"):
            return ""
        else:
            return s[res[1]:res[2]+1]
# @lc code=end

