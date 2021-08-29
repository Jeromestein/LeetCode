import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */

// @lc code=start

class LFUCache {

    class DlinkedNode {
        int key, value, freq = 1;
        DlinkedNode prev, next;

        public DlinkedNode() {
        }

        public DlinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DLinkedList {
        DlinkedNode head, tail;

        public DLinkedList() {
            head = new DlinkedNode();
            tail = new DlinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        void removeNode(DlinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void addToHead(DlinkedNode node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

    }

    Map<Integer, DlinkedNode> cache;
    Map<Integer, DLinkedList> freqMap;
    int size, capacity, minFreq;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        DlinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            updata_freqMap(node);
            return node.value;
        }

    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        DlinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            updata_freqMap(node);
        } else {
            if (size == capacity) {
                DLinkedList minFreqList = freqMap.get(minFreq);
                DlinkedNode minFreqNode = minFreqList.tail.prev;
                cache.remove(minFreqNode.key);
                minFreqList.removeNode(minFreqNode);
                size--;
            }

            minFreq = 1;
            size++;

            DlinkedNode newNode = new DlinkedNode(key, value);
            cache.put(key, newNode);
            addToFreqList(newNode, 1);
        }
    }

    void updata_freqMap(DlinkedNode node) {
        // remove node from freqList, and if the list is empty then update minFreq
        DLinkedList currFreqList = freqMap.get(node.freq);
        currFreqList.removeNode(node);
        if (node.freq == minFreq && currFreqList.head.next == currFreqList.tail) {
            minFreq = node.freq + 1;
        }

        // add node to newFreqList
        node.freq++;

        addToFreqList(node, node.freq);
    }

    void addToFreqList(DlinkedNode node, int freq) {
        DLinkedList freqList = freqMap.get(freq);
        if (freqList == null) {
            freqList = new DLinkedList();
            freqMap.put(freq, freqList);
        }
        freqList.addToHead(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
