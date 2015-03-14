/*	Implement HashTable.
*/
public class HashTable<K, T>
{
	private LinkedList<Node<K,T>>[] table
	private int size = 0;
	
	public HashTable<K,T>(int initSize)
	{
		table = new LinkedList<Node<K,T>>[initSize];
	}
	
	public void insert(K key, T value)
	{
		int hash = key.getHashCode() % size;
		LinkedList<Node<K,T>> list = null;
		if (table[hash] == null)
		{
		    list = new LinkedList<Node<K,T>();
			table[hash] = list;
		}
		else
		{
			list = table[hash];
		    bool isExists = false;
			foreach (Node<K,T> n in list)
			{
				if (n.Key.equals(key))
				{
					n.Value = value;
					return;
				}
			}
		}
		list.addToLast(new Node<K,T>(key, value));	
	}
	
	public T get(K key)
	{
		int hash = key.getHashCode() % size;
		LinkedList<Node<K,T>> list = null;
		if (table[hash] == null)
		{
		    list = new LinkedList<Node<K,T>();
			table[hash] = list;
		}
		else
		{
			list = table[hash];
		}
		foreach (Node<K,T> n in list)
		{
			if (n.Key.equals(key))
			{
				return n.Value;
			}
		}
		return null;
	}
}