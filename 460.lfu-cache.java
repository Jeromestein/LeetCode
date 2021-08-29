/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */

// @lc code=start

class LFUCache {

    class Node {
        int key;
        int value;
        int freq = 1;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;

        public DoublyLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void addToHead(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }
    }

    Map<Integer, Node> cache;
    Map<Integer, DoublyLinkedList> freqMap;
    int size, capacity, minFreq;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
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
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            updata_freqMap(node);
        } else {
            if (size == capacity) {
                DoublyLinkedList minFreqList = freqMap.get(minFreq);
                Node minFreqNode = minFreqList.tail.prev;
                cache.remove(minFreqNode.key);
                minFreqList.removeNode(minFreqNode);
                size--;
            }

            minFreq = 1;
            size++;

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            DoublyLinkedList linkedList = freqMap.get(1);
            if (linkedList == null) {
                linkedList = new DoublyLinkedList();
                freqMap.put(1, linkedList);
            }
            linkedList.addToHead(newNode);
        }
    }

    void updata_freqMap(Node node) {
        // remove node from freqList, and if the list is empty then update minFreq
        DoublyLinkedList currFreqList = freqMap.get(node.freq);
        currFreqList.removeNode(node);
        if (node.freq == minFreq && currFreqList.head.next == currFreqList.tail) {
            minFreq = node.freq + 1;
        }

        // add node to newFreqList
        node.freq++;
        DoublyLinkedList newFreqList = freqMap.get(node.freq);
        if (newFreqList == null) {
            newFreqList = new DoublyLinkedList();
            freqMap.put(node.freq, newFreqList);
        }
        newFreqList.addToHead(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
