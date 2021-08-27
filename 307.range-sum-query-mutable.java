/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 */

// @lc code=start

// class NumArray {
//     int[] tree;
//     int n;

//     // Initializes the object with the integer array nums.
//     public NumArray(int[] nums) {
//         if (nums.length > 0) {
//             n = nums.length;
//             tree = new int[n * 2];
//             buildTree(nums);
//         }
//     }

//     private void buildTree(int[] nums) {
//         for (int i = 0; i < n; i++) {
//             tree[i + n] = nums[i];
//         }

//         for (int i = n - 1; i > 0; --i)
//             tree[i] = tree[i * 2] + tree[i * 2 + 1];
//     }

//     // Updates the value of nums[index] to be val.
//     public void update(int index, int val) {
//         index += n;

//         // update num itself
//         tree[index] = val;
//         // update related sums
//         while (index > 0) {
//             int left = index;
//             int right = index;
//             if (index % 2 == 0) {
//                 right = index + 1;
//             } else {
//                 left = index - 1;
//             }
//             // parent is updated after child is updated
//             tree[index / 2] = tree[left] + tree[right];
//             index /= 2;
//         }

//     }

//     // Returns the sum of the elements of nums
//     // between indices left and right inclusive
//     // (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
//     public int sumRange(int left, int right) {
//         // get leaf with value 'l'
//         left += n;
//         // get leaf with value 'r'
//         right += n;
//         int sum = 0;
//         while (left <= right) {
//             if ((left % 2) == 1) {
//                 sum += tree[left];
//                 left++;
//             }
//             if ((right % 2) == 0) {
//                 sum += tree[right];
//                 right--;
//             }
//             left /= 2;
//             right /= 2;
//         }
//         return sum;

//     }
// }

class NumArray {
    int t = 0;
    int[] a;

    public NumArray(int[] nums) {
        a = nums;
        for (int i : a)
            t += i;
    }

    public void update(int index, int val) {
        t -= a[index];
        t += val;
        a[index] = val;
    }

    public int sumRange(int left, int right) {
        int s = 0;
        int size = right - left + 1;
        if (Math.abs(a.length - size) > size) {
            for (int i = left; i <= right; i++)
                s += a[i];

            return s;
        } else {
            for (int i = 0; i < left; i++)
                s += a[i];
            for (int i = right + 1; i < a.length; i++)
                s += a[i];
        }
        return t - s;
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); obj.update(index,val); int param_2 =
 * obj.sumRange(left,right);
 */
// @lc code=end
