/*
		 1
       /  \
      2    3
     / \  / \
    4  5 6   7
    
    Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 
*/
public static Node ConvertBinaryTreeToLinkedListInBSTOrder(Node root)
{
	Queue<Node> q = new Queue<Node>();
	Node cur = root;
	Node prev = null;
	
	q.Add(root);
	
	while (q.IsEmpty() == false)
	{
		cur = q.Dequeue();
		
		if (cur.Left != null)
		{
			q.Enqueue(cur.Left);
		}
		if (cur.Right != null)
		{
			q.Enqueue(cur.Right);
		}
		
		if (prev != null)
		{
			cur.Left = prev;
			prev.Right = cur;
		}
		prev = cur;
	}
	
	return root;
}
