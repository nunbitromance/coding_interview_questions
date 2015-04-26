// LRU cache implementation
public class Node<K,V>
{
    public K Key {get;set;}
    public V Value {get;set;}
    public Node<K,V> Next {get;set;}
    public Node<K,V> Prev {get;set;}
}

public class LRUCache<K, V> 
{
    private Node<K,V> head = null;
    private Node<K,V> tail = null;
    private int size = null;
    private Dictionary<K,Node<K,V>> table = null;
    
    public LRUCache<K,V>(int initSize)
    {
        initSize = size;
        table = new Dictionary<K, Node<K,V>>();
    }
    
    public void Set(K key, V value)
    {
        Node<K,V> node = null;
        if (table.ContainsKey(key))
        {
            node = table[key];
            node.Value = value;
        }
        else
        {   
            if (size == table.Count)
            {
                //evict last item.
                Node<K,V> last = tail;
                last.Prev.Next = null;
                tail = last.Prev;
                table.Remove(last.Key);
            }
            node = new Node<K,V>(key, value);
            table.Add(node);
        } 
        //move node to front.
        MoveToFront(node);
    }
    
    public V Get(K key)
    {
        V value = null;
        if (table.ContainsKey(key))
        {
            Node<K,V> node = table[key];
            value = node.Value;
            MoveToFront(node);
        }
        else
        {
            value = null;
        }
        return value;
    }
    
    private void MoveToFront(Node node)
    {
        //remove node from list.
        if (node.Prev != null)
        {
            node.Prev.Next = node.Next;
        }
        if (node.Next != null)
        {
            node.Next.Prev = node.Prev;
        }
        if (tail == node)
        {
            tail = node.Prev;
        }       
        node.Next = head;
        head = node;
        if (tail == null)
        {
            tail = node;
        }
    }
}

import java.util.HashMap;
 
public class LRUCache {
	private HashMap<Integer, DoubleLinkedListNode> map 
		= new HashMap<Integer, DoubleLinkedListNode>();
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode end;
	private int capacity;
	private int len;
 
	public LRUCache(int capacity) {
		this.capacity = capacity;
		len = 0;
	}
 
	public int get(int key) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode latest = map.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.val;
		} else {
			return -1;
		}
	}
 
	public void removeNode(DoubleLinkedListNode node) {
		DoubleLinkedListNode cur = node;
		DoubleLinkedListNode pre = cur.pre;
		DoubleLinkedListNode post = cur.next;
 
		if (pre != null) {
			pre.next = post;
		} else {
			head = post;
		}
 
		if (post != null) {
			post.pre = pre;
		} else {
			end = pre;
		}
	}
 
	public void setHead(DoubleLinkedListNode node) {
		node.next = head;
		node.pre = null;
		if (head != null) {
			head.pre = node;
		}
 
		head = node;
		if (end == null) {
			end = node;
		}
	}
 
	public void set(int key, int value) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode oldNode = map.get(key);
			oldNode.val = value;
			removeNode(oldNode);
			setHead(oldNode);
		} else {
			DoubleLinkedListNode newNode = 
				new DoubleLinkedListNode(key, value);
			if (len < capacity) {
				setHead(newNode);
				map.put(key, newNode);
				len++;
			} else {
				map.remove(end.key);
				end = end.pre;
				if (end != null) {
					end.next = null;
				}
 
				setHead(newNode);
				map.put(key, newNode);
			}
		}
	}
}
 
class DoubleLinkedListNode {
	public int val;
	public int key;
	public DoubleLinkedListNode pre;
	public DoubleLinkedListNode next;
 
	public DoubleLinkedListNode(int key, int value) {
		val = value;
		this.key = key;
	}
}
