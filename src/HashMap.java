/*	Implement HashTable.
*/
public class HashTable<K, T> implements Map<K, T>
{
	private LinkedList<Node<K,T>>[] table
	private int size = 0;
	
	public HashTable<K,T>(int initSize)
	{
		table = new LinkedList<Node<K,T>>[initSize];
	}
	
	public void put(K key, T value)
	{
		int hash = key.hashCode() % size;
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
			for (Node<K,T> n : list)
			{
				if (n.key.equals(key))
				{
					n.value = value;
					return;
				}
			}
		}
		list.add(new Node<K,T>(key, value));	
	}
	
	public T get(K key)
	{
		int hash = key.hashCode() % size;
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
		for (Node<K,T> n : list)
		{
			if (n.key.equals(key))
			{
				return n.value;
			}
		}
		return null;
	}
}
