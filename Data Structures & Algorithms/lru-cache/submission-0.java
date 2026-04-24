class LRUCache {
    int cap;
    HashMap<Integer,Node> cache;
    Node left,right;
    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    public void insert(Node node){
        Node pre = this.right.prev;
        pre.next = node;
        node.prev = pre;
        node.next = this.right;
        this.right.prev = node;
    }
    public void delete(Node node){
        Node pre = node.prev;
        Node nxt = node.next;
        pre.next = nxt;
        nxt.prev = pre;
    }
    public int get(int key) {
        if(cache.containsKey(key)){
            Node curr = cache.get(key);
            delete(curr);
            insert(curr);
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            delete(cache.get(key));
        }
        Node node = new Node(key,value);
        insert(node);
        cache.put(key,node);

        if(cache.size() > cap){
            Node lru = this.left.next;
            delete(lru);
            cache.remove(lru.key);
        }
    }
}
class Node{
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */