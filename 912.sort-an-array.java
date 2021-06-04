/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        // quickSort(nums, 0, nums.length - 1);
        // TopDown_mergeSort(nums, 0, nums.length - 1);
        // BottomUp_mergeSort(nums);
        heapSort(nums);
        // selectionSort(nums); // LTE in case 13
        // insertionSort(nums); // LTE in case 13
        // bubbleSort(nums); // LTE in case 11
        return nums;
    }

    /*************************** quick sort *******************************/
    private void quickSort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int mid = partition(nums, l, r);
        quickSort(nums, l, mid);
        quickSort(nums, mid + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot)
                r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot)
                l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    /*********************************************************************/
    /********************* top-down merge sort *****************************/
    private void TopDown_mergeSort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int mid = l + (r - l) / 2;
        TopDown_mergeSort(nums, l, mid);
        TopDown_mergeSort(nums, mid + 1, r);
        TopDown_merge(nums, l, r);
    }

    private void TopDown_merge(int[] nums, int l, int r) {
        int mid = l + (r - l) / 2;
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid || j <= r) {
            if (i > mid || j <= r && nums[i] > nums[j]) {
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }
        System.arraycopy(tmp, 0, nums, l, r - l + 1);
    }

    /*********************************************************************/
    /********************* bottom-up merge sort **************************/
    private void BottomUp_mergeSort(int[] nums) {
        for (int size = 1; size < nums.length; size *= 2) {
            for (int i = 0; i < nums.length - size; i += 2 * size) {
                int mid = i + size - 1;
                int end = Math.min(i + 2 * size - 1, nums.length - 1);
                BottomUp_merge(nums, i, mid, end);
            }
        }
    }

    private void BottomUp_merge(int[] nums, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid || j <= r) {
            if (i > mid || j <= r && nums[i] > nums[j]) {
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }
        System.arraycopy(tmp, 0, nums, l, r - l + 1);
    }

    /*********************************************************************/
    /**************************** heap sort ********************************/
    private void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, i, nums.length - 1);
        }
        for (int i = nums.length - 1; i >= 1; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i - 1);
        }
    }

    private void heapify(int[] nums, int i, int end) {
        while (i <= end) {
            int l = 2 * i + 1, r = 2 * i + 2;
            int maxIndex = i;
            if (l <= end && nums[l] > nums[maxIndex])
                maxIndex = l;
            if (r <= end && nums[r] > nums[maxIndex])
                maxIndex = r;
            if (maxIndex == i)
                break;
            swap(nums, i, maxIndex);
            i = maxIndex;
        }
    }

    private void heap_swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    /*********************************************************************/
    /************************** selection sort *****************************/
    private void selectionSort(int[] nums) {
        System.out.println(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            }
            if (minIndex != i)
                swap(nums, i, minIndex);
        }
    }

    /*********************************************************************/
    /*********************** insertion sort ********************************/
    private void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (nums[j] >= nums[j - 1])
                    break;
                swap(nums, j, j - 1);
            }
        }
    }

    /*********************************************************************/
    /**************************** bubble sort ******************************/
    private void bubbleSort(int[] nums) {
        for (int k = nums.length - 1; k >= 1; k--) {
            for (int i = 0; i < k; i++) {
                if (nums[i] > nums[i + 1])
                    swap(nums, i, i + 1);
            }
        }
    }
    /*********************************************************************/
}
// @lc code=end
