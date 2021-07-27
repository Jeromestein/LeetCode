import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=705 lang=java
 *
 * [705] Design HashSet
 */

// @lc code=start

class MyHashSet {
    // an array of linkedlists' addresses
    LinkedList[] hashTable;
    int N = 997;

    /** Initialize your data structure here. */
    public MyHashSet() {
        hashTable = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            hashTable[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        // 0 <= key <= 10^6
        int h = key % N;
        Iterator<Integer> it = hashTable[h].iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            if (element == key) {
                return;
            }
        }
        hashTable[h].offerLast(key);
    }

    public void remove(int key) {
        int h = key % N;
        Iterator<Integer> it = hashTable[h].iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            if (element == key) {
                hashTable[h].remove(element);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = key % N;
        Iterator<Integer> it = hashTable[h].iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */
// @lc code=end
