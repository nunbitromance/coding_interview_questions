// Method 2: check that left subtree is always smaller than root. right subtree is always bigger than root.
public static bool isBST(Node root)
{
	return isBST(root, int.Max, 0);
}

private static bool isBST(Node root, int max, int min)
{
	if (root == null)
	{
		return true;
	}
	
	if (root.Value > max || root.Value < min)
	{
		return false;
	}
	
	if (!isBST(root.getLeft(), root.getValue(), min))
	{
		return false;
	}

	if (!isBST(root.getRight(), max, root.getValue())
	{
		return false;
	}
	
	return true;
}


// 2. serialize and deserialize binary search tree. 
// Part 1: Do a pre-order traversal of tree.
public static void serialize(Node root, List<Node> list)
{
	if (root == null)
	{
		return;
	}
	list.add(root);
	
	serialize(root.getLeft(), list);
	serialize(root.getRight(), list);
}

// Part 2: Deserialize pre-order list into tree.
public static Node deserialize(List<Node> list)
{
	return deserialize(list, 0, list.length - 1);
}

// deserialize a binary search tree
private static Node deserialize(List<Node> list, int begin, int end)
{
	if (begin > end)
	{
		return null;
	}
	
	Node root = list[begin];
	// find right child whose value is greater than root.
	int rightIndex = begin + 1;
	while (rightIndex <= end)
	{
		if (list[rightIndex].Value > root.Value)
		{
			break;
		}
		rightIndex++;
	}
	
	root.Left = deserialize(list, begin+1, rightIndex-1);
	root.Right = deserialize(list, rightIndex, end);
}

// serialize a binary tree: do preorder then inorder
public static void serialize(Node root, List<Node> list)
{
	if (root == null)
	{
		return;
	}
	list.add(root);
	
	serialize(root.getLeft(), list);
	serialize(root.getRight(), list);
}

// deserialize a binary tree
private static Node deserialize(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd)
{
	if (preBegin > preEnd || inBegin > inEnd)
	{
		return null;
	}
	
	Node root = new Node(preorder[preBegin]);
	
	// inorder root index
	int rootIndex = inBegin;
	while (inoder[rootIndex] != preorder[inBegin])
	{
		rootIndex++;
	}
	int length = rootIndex - inBegin;
		
	//k now points to right child in preorder
	root.Left = deserialize(preorder, inorder, preBegin + 1, preBegin + length, inBegin, rootIndex - 1);
	root.Right = deserialize(preorder, inorder, preBegin + length + 1, preEnd, rootIndex, inEnd); 

	return root;
}

// 3. is balanced tree? 
public static bool isBalanced(Node root)
{
	return isBalanced(root) == -1 ? false : true;
}

private static int isBalanced(Node root)
{
	if (root == null)
	{
		return 0;
	}
	
	int lheight = isBalanced(root.getLeft());
	if (lheight == -1)
	{
		return -1;
	}
	int rheight = isBalanced(root.getRight());
	if (rheight == -1)
	{
		return -1;
	}
	
	if (Math.abs(lheight - rheight) > 1)
	{
		return -1;
	}
	
	return Math.max(lheight, rheight) + 1;
}

// 4. successor in bst? 
public static Node getInorderSuccessor(Node root)
{
	// have a right child
	if (root.getRight())
	{
		Node cur = root.getRight();
		while (cur.getLeft())
		{
			cur = cur.getLeft();
		}
		return cur;
	}
	else
	{
		// am a left child or right child
		Node cur = root;;
		Node parent = root.getParent();
		// walk up until i am right child
		while (parent != null && parent.getLeft() != cur)
		{
			cur = parent;
			parent = cur.getParent();
		}
		return parent;
	} 
	
}

// 5. LRU cache? 
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



// 6. merge two sorted array? 
public void merge(int[] a, int i, int j, int k)
{
	int[] m = new int[k - i + 1];
	int iIndex = i;
	int jIndex = j;
	int kIndex = 0;
	
	while (iIndex <= j && jIndex <= k)
	{
		if (a[iIndex] > b[jIndex])
		{
			m[kIndex++] = b[jIndex++];
		}
		else
		{
			m[kIndex++] = a[iIndex++];
		}
	}
	
	while (iIndex <= j)
	{
		m[kIndex++] = a[iIndex++];
	}
	
	while (jIndex <= k)
	{
		m[kIndex++] = b[jIndex++];
	}
	
	// copy m to a
	m.CopyTo(a, i);
}

// 7. a number or numbers that are occuring odd # of times in an array? 
public static void oddNumbers(int[] a)
{
	Dictionary<int, int> dic = new Dictionary<int, int>();
	for (int i = 0; i < a.length; i++)
	{
		if (dic.containsKey(a[i]))
		{
			dic[a[i]]++;
		}
		else
		{
			dic.insert(a[i], 1);
		}
	}
	
	for (int j = 0; j < dic.size(); j++)
	{
		if (dic[a[i]] % 2 == 1)
		{
			print(a[i]);
		}
	}
	
	return result;
}

// 8. find a pair of two numbers that sums up to X?
public static void findPair(int[] a, int s)
{
	Dictionary<int, int> dic = new Dictionary<int, int>();
	for (int i = 0; i < a.length; i++)
	{
		if (dic.containsKey(s - a[i]))
		{
			print(a[i]);
		}
		else
		{
			dic.insert(a[i], 1);
		}
	}
}

// 9. is same tree?
public static bool isSameTree(Node a, Node b)
{
	if (a == null && b == null)
	{
		return true;
	}
	if (a == null || b == null)
	{
		return false;
	}
	return (a.getValue() == b.getValue()) && 
		isSameTree(a.getLeft(), b.getLeft()) && 
		isSameTree(a.getRight(), b.getRight());
}

// 10. contains tree?
public static bool containsTree(Node a, Node b)
{
	if (a == null)
	{
		return false;
	}
	
	if (a.getValue() == b.getValue() && isSameTree(a, b))
	{
		return true;
	}
	
	return containsTree(a.getLeft(), b) || containsTree(a.getRight(), b);
}

// 11. lowest common ancestor in BST
public static Node findLCA(Node root, Node a, Node b)
{
	if (root == null)
	{
		return null;
	}
	
	int rootVal = root.getValue();
	int aVal = a.getValue();
	int bVal = b.getValue();
	
	if (rootVal > aVal && rootVal < bVal)
	{
		return root;
	}
	else if (rootVal > aVal && rootVal > bVal)
	{
		return findLCA(root.getLeft(), a, b);
	}
	else
	{
		return findLCA(root.getRight(), a, b);
	}
	return null;
}

// 12. lower common ancestor in BT
public static Node findLCA(Node root, Node a, Node b)
{
	if (root == null)
	{
		return null;
	}
	
	if (root == a || root == b)
	{
		return root;
	}
	
	Node l = findLCA(root.getLeft(), a, b);
	Node r = findLCA(root.getRight(), a, b);
	
	if (l & r)
	{
		return root;
	} 
	if (l)
	{
		return l;
	}
	return r;
}

// 13. Comparator Example
public class IntegerComparator<int> : Comparator<int>
{
	public int compareTo(int a, int b)
	{
		return a.compareTo(b);
	}
}

// 14. Iterator Example
public class CustomIterator<T> : Iterator<T>
{
	private List<T> list;
	private int curPos = 0;
	
	public CustomIterator<T>(List<T> iterable)
	{
		list = iterable;
	}
	
	public bool hasNext()
	{
		return curPos < list.length;
	}
	
	public T next()
	{
		T item = list[curPos];
		curPos++;
		return item;
	}
}

public class CustomIterable<T> : Iterable<T>
{
	private List<T> list;

	public Iterator<T> iterator()
	{
		return new CustomIterator<T>(list);
	}
}

/*
The longest common substring of the strings "ABABC", "BABCA" and "ABCBA" is string "ABC" of length 3. Other common substrings are "AB", "BC" and "BA".
*/
public static string LongestCommonSubstring(string s1, string s2)
{
	if (s1 == null)
	{
		throw new ArgumentNullException("s1");
	}
	if (s2 == null)
	{
		throw new ArgumentNullException("s2");
	}	
	string maxSubstring = null;
	int maxLength = 0;
	int[][] m = new int[s1.Length][s2.Length];
	
	for (int i = 0; i < s1.Length; i++)
	{
		if (s1[i] == s2[0])
		{
			m[i][0] = 1;
		}
	}
	
	for (int j = 0; j < s2.Length; j++)
	{
		if (s2[j] == s1[0])
		{
			m[0][j] = 1;
		}
	}
	
	for (int i = 1; i < s1.Length; i++)
	{
		for (int j = 1; j < s2.Length; j++)
		{
			if (s1[i] == s2[j])
			{
				int result = m[i-1][j-1] + 1;
				if (result > maxLength)
				{
					maxLength = result;
					maxSubstring = s1.Substring(i-maxLength+1, maxLength);
				}
			}
			else
			{
				m[i][j] = 0;
			}
		}
	}
	
	return maxSubstring;
}

/*
Given a string S, find the longest palindromic substring in S.
s = "abac" => "aba"

Define P[ i, j ] ? true iff the substring Si � Sj is a palindrome, otherwise false.
Therefore,

P[ i, j ] ? ( P[ i+1, j-1 ] and Si = Sj )
The base cases are:

P[ i, i ] ? true
P[ i, i+1 ] ? True if same

string longestPalindromeDP(string s) {
  int n = s.length();
  int longestBegin = 0;
  int maxLen = 1;
  bool table[1000][1000] = {false};
  for (int i = 0; i < n; i++) {
    table[i][i] = true;
  }
  for (int i = 0; i < n-1; i++) {
    if (s[i] == s[i+1]) {
      table[i][i+1] = true;
      longestBegin = i;
      maxLen = 2;
    }
  }
  for (int len = 3; len <= n; len++) {
    for (int i = 0; i < n-len+1; i++) {
      int j = i+len-1;
      if (s[i] == s[j] && table[i+1][j-1]) {
        table[i][j] = true;
        longestBegin = i;
        maxLen = len;
      }
    }
  }
  return s.substr(longestBegin, maxLen);
}
Additional exercise:
Could you improve the above space complexity further and how?
