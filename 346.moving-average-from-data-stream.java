/*
 * @lc app=leetcode id=346 lang=java
 *
 * [346] Moving Average from Data Stream
 */

// @lc code=start
class MovingAverage {
    int maxSize;
    double sum;
    Queue<Integer> q;

    public MovingAverage(int size) {
        this.maxSize = size;
        this.sum = 0;
        this.q = new LinkedList<>();
    }

    public double next(int val) {
        sum += val;
        q.add(val);
        if (q.size() > this.maxSize) {
            sum -= q.poll();
        }

        return sum / (double) q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
// @lc code=end
