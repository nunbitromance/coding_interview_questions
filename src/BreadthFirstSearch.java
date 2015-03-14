/*
    3
   / \
  9  20
    /  \
   15   7
   
  Visit order: 3 -> 9 -> 20 -> 15 -> 7
*/
// Non-recursion method
public static void BFS(Node root)
{
	Queue<Node> q = new Queue<Node>();
	q.Enqueue(root);
	
	while (q.IsEmpty() == false)
	{
		Node cur = q.Dequeue();
		cur.Visited = true;
		foreach (Node c in cur.Children)
		{
			if (c.Visited == false)
			{
				c.Visited = true;
				q.Enqueue(c);	
			}
		}
	}
}