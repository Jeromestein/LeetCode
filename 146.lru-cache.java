import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import javax.naming.LinkLoopException;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    /**
     * Initialize the LRU cache with positive size capacity.
     * 
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        // creat dummy head and tail
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Return the value of the key if the key exists, otherwise return -1.
     * 
     * @param key
     * @return
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            // if it exisits, then move it to the head of linkedlist
            moveToHead(node);
            return node.value;
        }
    }

    /**
     * Update the value of the key if the key exists. Otherwise, add the key-value
     * pair to the cache. If the number of keys exceeds the capacity from this
     * operation, evict the least recently used key.
     * 
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // if not exisits yet, create a new node
            DLinkedNode newNode = new DLinkedNode(key, value);
            // add it to hashmap
            cache.put(key, newNode);
            // add it to the head of linkedlist
            addToHead(newNode);
            size++;
            while (size > capacity) {
                // if exceeds the capacity, delete the tail of linkedlist
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            // if it exisits, upadaa its value, then move it to the head of linkedlist
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
