/*
    3
   / \
  9  20
    /  \
   15   7
   
  Visit order: 3 -> 9 -> 20 -> 15 -> 7
*/
// Non-recursion
public static void DFS(Node root)
{
	Stack<Node> s = new Stack<Node>();
	s.Push(root);
	
	while (s.IsEmpty() == false)
	{
		Node cur = s.Peek();
		cur.Visited = true;
		bool anyChildrenToVisit = false;
		
		foreach (Node child in cur.Children)
		{
			if (child.Visited == false)
			{
				s.Push(child);
				anyChildrenToVisit = true;
				break;
			}
		}
		
		if (!anyChildrenToVisit)
		{
			s.Pop();
		}
	}
}

// Recursion
public static void DFS(Node root)
{
	if (root == null)
	{
		return;
	}
	
	root.Visited = true;
	foreach (Node child in cur.Children)
	{
		DFS(child);
	}
}