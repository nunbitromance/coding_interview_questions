/*
Given a binary search tree, print the elements in-order iteratively without using recursion.

http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/

Morris traversal
*/

public static void PrintPostorder (Node root)
{
	Stack<Node> s = new Stack<Node>();
	
	s.Push(root);
	Node prev = null;
	Node cur = root;
	while (s.IsEmpty() != true)
	{
		cur = s.Peek();
		
		if (cur.Left == null && cur.Right == null)
		{
			Print(cur);
			s.Pop();
		}
		else if (prev == cur.Left)
		{
			s.Push(cur.Right);
		}
		else if (prev == cur.Right)
		{
			Print(cur);
			s.Pop();
		}	
		else
		{
			s.Push(cur.Left);
		}
		prev = cur;
	}
}

public static void PrintInorder(Node root)
{
	Stack<Node> s = new Stack<Node>();
	
	s.Push(root);
	Node prev = null;
	Node cur = root;
	while (s.IsEmpty() != true)
	{
		cur = s.Peek();
		
		if (cur.Left == null && cur.Right == null)
		{
			Print(cur);
			s.Pop();
		}
		else if (prev == cur.Left)
		{
			Print(cur);
			s.Push(cur.Right);
		}
		else if (prev == cur.Right)
		{
			s.Pop();
		}	
		else
		{
			s.Push(cur.Left);
		}
		
		prev = cur;
	}
}
