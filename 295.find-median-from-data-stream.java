import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {
    // balanced heaps
    // hl[1] is the max of left heap
    // hr[1] is the min of right heap
    static final int MAX_NUM = 25003;
    int[] hl = new int[MAX_NUM]; // max heap (left side)
    int[] hr = new int[MAX_NUM]; // min heap (right side)
    int pl, pr, p, t;

    public MedianFinder() {
        pl = pr = 0;
    }

    public void addNum(int num) {
        // compare with left side median value (hl[1])
        if (pl == 0 || hl[1] >= num)
            addToHL(num);
        else
            addToHR(num);

        // keep balance
        // pr<=pl<=pr+1
        // pl=pr or pl=pr+1
        if (pl < pr) {
            addToHL(hr[1]);
            removeFromHR();
        } else if (pl > pr + 1) {
            addToHR(hl[1]);
            removeFromHL();
        }
    }

    public double findMedian() {
        if (pl == pr) {
            return (hl[1] + hr[1]) / 2.0d;
        } else {
            return hl[1];
        }
    }

    private void removeFromHL() {
        // remove top node, the max
        p = 1;
        hl[1] = hl[pl--];
        while (p * 2 <= pl) {
            int mt0 = p * 2;
            int mt1 = (p * 2 + 1 > pl) ? p * 2 : p * 2 + 1;
            mt0 = hl[mt0] >= hl[mt1] ? mt0 : mt1;
            if (hl[p] < hl[mt0]) {
                t = hl[mt0];
                hl[mt0] = hl[p];
                hl[p] = t;
                p = mt0;
            } else {
                break;
            }
        }
    }

    private void removeFromHR() {
        // remove top node, the min
        p = 1;
        hr[1] = hr[pr--];
        while (p * 2 <= pr) {
            int mt0 = p * 2;
            int mt1 = (p * 2 + 1 > pr) ? p * 2 : p * 2 + 1;
            mt0 = hr[mt0] <= hr[mt1] ? mt0 : mt1;
            if (hr[p] > hr[mt0]) {
                t = hr[mt0];
                hr[mt0] = hr[p];
                hr[p] = t;
                p = mt0;
            } else {
                break;
            }
        }
    }

    private void addToHL(int num) {
        // add to leaf node
        p = ++pl;
        hl[p] = num;
        while (p > 1 && p < MAX_NUM && hl[p] > hl[p >> 1]) {
            // max heap
            // if it is > its father node, swap
            t = hl[p >> 1];
            hl[p >> 1] = hl[p];
            hl[p] = t;
            p >>= 1;
        }
    }

    private void addToHR(int num) {
        p = ++pr;
        hr[p] = num;
        while (p > 1 && p < MAX_NUM && hr[p] < hr[p >> 1]) {
            // min heap
            // if it is < its father node, swap
            t = hr[p >> 1];
            hr[p >> 1] = hr[p];
            hr[p] = t;
            p >>= 1;
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
// @lc code=end
