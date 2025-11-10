#
# @lc app=leetcode id=170 lang=python3
#
# [170] Two Sum III - Data structure design
#


# @lc code=start
class TwoSum:

    def __init__(self):
        self.map = defaultdict(int)

    def add(self, number: int) -> None:
        self.map[number] += 1

    def find(self, value: int) -> bool:
        for n1 in list(self.map.keys()):
            n2 = value - n1
            if n1 == n2:
                if self.map[n1] > 1:
                    return True
            else:
                if n2 in self.map:
                    return True

        return False


# Your TwoSum object will be instantiated and called as such:
# obj = TwoSum()
# obj.add(number)
# param_2 = obj.find(value)
# @lc code=end
