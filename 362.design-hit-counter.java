/*
 * @lc app=leetcode id=362 lang=java
 *
 * [362] Design Hit Counter
 */

// @lc code=start
class HitCounter {
    Deque<int[]> deque;

    public HitCounter() {
        deque = new LinkedList<>();
        deque.addFirst(new int[] { 0, 0 });
    }

    // Time:O(1)
    public void hit(int timestamp) {
        // multiple hits arriving at the "same" timestamps.
        if (deque.peekLast()[0] == timestamp)
            deque.peekLast()[1]++;
        else
            deque.addLast(new int[] { timestamp, deque.peekLast()[1] + 1 });
    }

    // Time:O(N) N <= 300
    public int getHits(int timestamp) {

        int[] guardian = null;
        while (!deque.isEmpty() && timestamp - deque.peekFirst()[0] >= 300)
            guardian = deque.pollFirst();

        if (deque.isEmpty())
            deque.addFirst(new int[] { 0, 0 });
        else if (guardian != null)
            deque.addFirst(guardian);

        return deque.peekLast()[1] - deque.peekFirst()[1];
    }

}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
// @lc code=end
