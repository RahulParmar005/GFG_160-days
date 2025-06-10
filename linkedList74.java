// Design a data structure that works like a LRU Cache. Here cap denotes the capacity of the cache and Q denotes the number of queries. Query can be of two types:

// PUT x y: sets the value of the key x with value y
// GET x: gets the value of key x if present else returns -1.
// The LRUCache class has two methods get() and put() which are defined as follows.

// get(key): returns the value of the key if it already exists in the cache otherwise returns -1.
// put(key, value): if the key is already present, update its value. If not present, add the key-value pair to the cache. If the cache reaches its capacity it should remove the least recently used item before inserting the new item.
// In the constructor of the class the capacity of the cache should be initialized.


class Node {
    int key;
    int value;
    Node next;
    Node prev;
        
    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    private static int capacity;
    
    private static Map<Integer, Node> cacheMap;
    
    private Node head;
    
    private Node tail;
    

    LRUCache(int capacity) {
        // code here
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {

        if(!cacheMap.containsKey(key)){
            return -1;
        }
        
        Node node = cacheMap.get(key);
        remove(node);
        add(node);
        return node.value;
        // your code here
    }

        
    public void put(int key, int value) {
        // your code here
        if(cacheMap.containsKey(key)){
            Node oldNode = cacheMap.get(key);
            remove(oldNode);
        }
        Node node = new Node(key, value);
        cacheMap.put(key, node);
        add(node);
        if(cacheMap.size() > capacity){
            Node nodeToDelete = tail.prev;
            remove(nodeToDelete);
            cacheMap.remove(nodeToDelete.key);
        }
    }
    
    private void add(Node node){
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }
    
    private void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
}