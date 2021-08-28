/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start

class Solution {
    private int[] index;
    private int[] temp;
    private int[] tempIndex;
    private int[] ans;

    public List<Integer> countSmaller(int[] nums) {
        index = new int[nums.length];
        temp = new int[nums.length];
        tempIndex = new int[nums.length];
        ans = new int[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            index[i] = i;
        }

        mergeSort(nums, 0, nums.length - 1);

        List<Integer> list = new ArrayList<Integer>();
        for (int num : ans) {
            list.add(num);
        }
        return list;
    }

    public void mergeSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    public void merge(int[] a, int l, int mid, int r) {
        int lPtr = l, rPtr = mid + 1, p = l;
        while (lPtr <= mid && rPtr <= r) {
            if (a[lPtr] <= a[rPtr]) {
                temp[p] = a[lPtr];
                tempIndex[p] = index[lPtr];
                // get the no. of smaller right elements during the merging process
                ans[index[lPtr]] += (rPtr - mid - 1);
                ++lPtr;
                ++p;
            } else {
                temp[p] = a[rPtr];
                tempIndex[p] = index[rPtr];
                ++rPtr;
                ++p;
            }
        }
        while (lPtr <= mid) {
            temp[p] = a[lPtr];
            tempIndex[p] = index[lPtr];
            ans[index[lPtr]] += (rPtr - mid - 1);
            ++lPtr;
            ++p;
        }
        while (rPtr <= r) {
            temp[p] = a[rPtr];
            tempIndex[p] = index[rPtr];
            ++rPtr;
            ++p;
        }
        for (int k = l; k <= r; ++k) {
            index[k] = tempIndex[k];
            a[k] = temp[k];
        }
    }
}

// @lc code=end
