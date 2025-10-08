#
# @lc app=leetcode id=1488 lang=python3
#
# [1488] Avoid Flood in The City
#

# @lc code=start
from sortedcontainers import SortedList


class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        # Initialize the answer array
        # Default all to 1 (for dry days we’ll decide which lake to dry)
        ans = [1] * len(rains)

        # SortedList to store indices of available dry days (rain == 0)
        st = SortedList()

        # Map to store the most recent day each lake was filled
        # mp[lake] = index of last time it rained on that lake
        mp = {}

        # Iterate over all days
        for i, rain in enumerate(rains):
            if rain == 0:
                # This is a dry day; store its index for future use
                st.add(i)
            else:
                # It's raining on lake 'rain'
                ans[i] = -1  # On rainy days, we must output -1

                # If this lake was already full, we must dry it before today
                if rain in mp:
                    # Find the earliest dry day that happens *after* mp[rain]
                    it = st.bisect(mp[rain])

                    # If there is no dry day available after the previous rain
                    # then flooding is unavoidable
                    if it == len(st):
                        return []

                    # Choose that dry day to dry this lake
                    ans[st[it]] = rain

                    # Remove that dry day from available set
                    st.discard(st[it])

                # Record the current rain day as the most recent fill of this lake
                mp[rain] = i

        # Return the filled answer array
        return ans


# @lc code=end
