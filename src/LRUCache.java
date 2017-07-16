package practice;
import java.util.HashMap;
import java.util.Map;

/*
http://www.programcreek.com/2013/03/leetcode-lru-cache-java/
*/
public class LRUCache<K,V> {

    @Override
    public String toString() {
        return "LRUCache [capacity=" + capacity + //", map=" + map + 
                ", head="+ head + ", tail=" + tail + "]";
    }

    private int capacity = 0;
    private Map<K, CacheNode<K,V>> map = new HashMap<>();
    public CacheNode<K,V> head = null;
    public CacheNode<K,V> tail = null;
    
    public LRUCache(int cap) {
        this.capacity = cap;
    }
    
    public void set(K key, V value) {
        CacheNode<K,V> node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            
            remove(node);
        } else {
            
            if (map.size() == capacity)
            {
                //evict last item.
                remove(tail);
                map.remove(tail.key);
            }
            node = new CacheNode<K,V>();
            node.key = key;
            node.value = value;
            map.put(key,node);
        }

        moveToFront(node);
    }
    
    private void remove(CacheNode<K,V> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (head == node) {
            head = node.next;
        }
        if (tail == node) {
            tail = node.prev;
        }
    }
    
    public V get(K key) {
        CacheNode<K,V> node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            remove(node);
            moveToFront(node);
        }
        
        return node != null ? node.value : null;
    }
    
    private void moveToFront(CacheNode<K,V> node) {
        //remove node from list.
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LRUCache<String, Integer> cache = new LRUCache<>(5);
        cache.set("a", 1);
        
        cache.printLinkedList();
        
        cache.set("b", 2);
        
        cache.printLinkedList();
        
        cache.set("c", 3);
        
        cache.printLinkedList();
        
        cache.set("d", 4);
        cache.set("e", 5);
        
        cache.printLinkedList();
        
        System.out.println(cache.get("a"));
        
        cache.printLinkedList();
        
        cache.set("a", 6);
        
        cache.printLinkedList();

        cache.set("f", 7);
        
        cache.printLinkedList();
    }
    
    public void printLinkedList() {
        System.out.println("head: " + head.value);
        System.out.println("tail: " + tail.value);
        System.out.println("size: " + map.size());
        
        CacheNode<K,V> cur = head;
        while (cur != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}

class CacheNode<K,V> {
    public CacheNode<K,V> next;
    public CacheNode<K,V> prev;
    public K key;
    public V value;
    @Override
    public String toString() {
        return "CacheNode [key=" + key
                + ", value=" + value + "]";
    }
    
}
