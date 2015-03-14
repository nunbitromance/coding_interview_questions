/*
Incremental Search: Given a list of words in a dictionary, find if a string s is a valid word.
Trie approach
*/
public class Node
{
	public Node(char val)
	{
		Children = new Node[256];
		Value = val;
	}
	
	public char Value {get;set;}
	public Node[] Children {get;set;}
}

public class Trie
{
	private Node Root {get;set;}
	
	public Trie()
	{
		Root = new Node('');
	}
	
	public void Insert(string s)
	{
		Node cur = Root;
	
		for (int i = 0; i < s.Length; i++)
		{
			if (cur.Children[i] == null)
			{
				cur.Children[i] = new Node(s[i]);
			}
			cur = cur.Children[i];
		}
	}
	
	public bool Search(string s)
	{
		Node cur = Root;
		int i = 0;
		while (cur != null && i < s.Length)
		{
			if (cur.Children[s[i]] == null)
			{
				return false;
			}
			cur = cur.Children[s[i]];
			i++;
		}
		
		return true;
	}	
}
