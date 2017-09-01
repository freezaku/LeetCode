class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node dummyHead;
    private Node dummyTail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        dummyHead = new Node(-1, -1);
        dummyTail = new Node(-1, -1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))   return -1;
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToFront(node);
            node.value = value;
        } else {
            if(map.size() >= capacity) {
                removeNode();
            }
            Node node = new Node(key, value);
            map.put(key, node);
            moveToFront(node);
        }
    }
    
    private void moveToFront(Node node) {
        Node oldNode = dummyHead.next;
        oldNode.prev = node;
        node.next = oldNode;
        dummyHead.next = node;
        node.prev = dummyHead;
    }
    
    private void removeNode() {
        Node oldNode = dummyTail.prev;
        oldNode.prev.next = dummyTail;
        dummyTail.prev = oldNode.prev;
        oldNode.next = null;
        oldNode.prev = null;
        map.remove(oldNode.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
一个小系统设计题，
构造双向链表，配合map使用。
*/