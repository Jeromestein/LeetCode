#
# @lc app=leetcode id=2125 lang=python3
#
# [2125] Number of Laser Beams in a Bank
#


# @lc code=start
class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        res = 0
        pre_cnt_devices = 0
        n = len(bank)

        for i in range(n):
            curr_cnt_devices = bank[i].count("1")
            if curr_cnt_devices > 0:
                res += pre_cnt_devices * curr_cnt_devices
                pre_cnt_devices = curr_cnt_devices

        return res


# @lc code=end
