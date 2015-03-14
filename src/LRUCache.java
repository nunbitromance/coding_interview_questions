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

