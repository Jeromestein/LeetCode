import java.util.Arrays;

/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */

// @lc code=start
// class KthLargest {
//     // 1 <= k <= 10^4
//     // 0 <= nums.length <= 10^4
//     static final int MAXSIZE = 10001;
//     // max heap
//     int[] leftHeap = new int[MAXSIZE];
//     // min heap
//     int[] rightHeap = new int[MAXSIZE];
//     int kth, leftHeapSize, rightHeapSize;

//     public KthLargest(int k, int[] nums) {
//         leftHeapSize = k;
//         rightHeapSize = nums.length - k;
//         kth = k;
//         Arrays.sort(nums);
//         for (int i = 0; i < k; i++) {
//             // leftHeap[1] is the top node, the max
//             leftHeap[i + 1] = nums[k - i - 1];
//         }
//         for (int i = k; i < nums.length; i++) {
//             // rightHeap[1] is the top node, the min
//             rightHeap[i - k + 1] = nums[k];
//         }
//     }

//     public int add(int val) {
//         for (int i = 1; i < leftHeapSize; i++) {
//             System.out.print(leftHeap[i] + " ");
//         }
//         System.out.println(" ");
//         for (int i = 1; i < rightHeapSize; i++) {
//             System.out.print(rightHeap[i] + " ");
//         }
//         System.out.println(" ");

//         if (val >= leftHeap[1]) {
//             // add val to right heap
//             addToRight(val);
//         } else {
//             // add leftHeap[1] to right heap
//             addToRight(leftHeap[1]);
//             // remove top node leftHeap[1] from left heap
//             removeFromLeft(leftHeap[1]);
//             // add val to left heap
//             addToLeft(val);
//         }

//         for (int i = 1; i < leftHeapSize; i++) {
//             System.out.print(leftHeap[i] + " ");
//         }
//         System.out.println(" ");
//         for (int i = 1; i < rightHeapSize; i++) {
//             System.out.print(rightHeap[i] + " ");
//         }
//         System.out.println(" ");

//         return leftHeap[1];
//     }

//     private void addToLeft(int num) {
//         leftHeapSize++;
//         int indexNum = leftHeapSize;
//         leftHeap[indexNum] = num;
//         int t;
//         while (indexNum > 1 && indexNum < MAXSIZE && leftHeap[indexNum] > leftHeap[indexNum >> 1]) {
//             // max heap
//             // if it is > its father node, swap
//             t = leftHeap[indexNum >> 1];
//             leftHeap[indexNum >> 1] = leftHeap[indexNum];
//             leftHeap[indexNum] = t;
//             indexNum >>= 1;
//         }
//     }

//     private void removeFromLeft(int num) {
//         // remove top node, the max
//         int indexNum = 1;
//         leftHeap[1] = leftHeap[leftHeapSize--];
//         int t;
//         while (indexNum * 2 <= leftHeapSize) {
//             int mt0 = indexNum * 2;
//             int mt1 = (indexNum * 2 + 1 > leftHeapSize) ? indexNum * 2 : indexNum * 2 + 1;
//             mt0 = leftHeap[mt0] >= leftHeap[mt1] ? mt0 : mt1;
//             if (leftHeap[indexNum] < leftHeap[mt0]) {
//                 t = leftHeap[mt0];
//                 leftHeap[mt0] = leftHeap[indexNum];
//                 leftHeap[indexNum] = t;
//                 indexNum = mt0;
//             } else {
//                 break;
//             }
//         }
//     }

//     private void addToRight(int num) {
//         rightHeapSize++;
//         int indexNum = rightHeapSize;
//         rightHeap[indexNum] = num;
//         int t;
//         while (indexNum > 1 && indexNum < MAXSIZE && rightHeap[indexNum] < rightHeap[indexNum >> 1]) {
//             // min heap
//             // if it is < its father node, swap
//             t = leftHeap[indexNum >> 1];
//             rightHeap[indexNum >> 1] = rightHeap[indexNum];
//             rightHeap[indexNum] = t;
//             indexNum >>= 1;
//         }
//     }

// }
class KthLargest {
    final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }
}
/**
 * Your KthLargest object will be instantiated and called as such: KthLargest
 * obj = new KthLargest(k, nums); int param_1 = obj.add(val);
 */
// @lc code=end
