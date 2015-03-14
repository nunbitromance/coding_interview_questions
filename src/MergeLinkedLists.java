/*
Merge two sorted linked lists
a: 1 -> 3 -> 5
b: 2 -> 4 -> 6

out: 1->2->3->4->5->6
*/
// Iterative version.
public static Node Merge(Node a, Node b)
{
	Node aCur = a;
	Node bCur = b;
	Node c = null;
	Node cCur = null;
	
	while (aCur != null && bCur != null)
	{
		Node result = null;
		if (aCur.Value < bCur.Value)
		{
			result = aCur;
			aCur = aCur.Next;
		}
		else
		{
			result = bCur;
			bCur = bCur.Next;
		}
		
		if (c == null)
		{
			c = result;
			cCur = c;
		}
		else
		{
			cCur.Next = result;
		}
		cCur = cCur.Next;
	}
	
	while (aCur!= null)
	{
		cCur.Next = aCur;
		aCur = aCur.Next;
		cCur = cCur.next;
	}
	while (bCur != null)
	{
		cCur.Next = bCur;
		bCur = bCur.Next;
		cCur = cCur.Next;
	}
	return c;
}

// Recursive version.
public static Node Merge(Node a, Node b)
{
	if (a == null && b == null)
	{
		return null;
	}
	else if (a != null && b == null)
	{
		return a;
	}
	else if (a == null && b != null)
	{
		return b;
	}
	
	Node c = null;
	if (a.Value < b.Value)
	{
		c = a;
		c.Next = Merge(a.Next, b);
	}
	else
	{
		c = b;
		c.Next = Merge(a, b.Next);
	}
	return c;
}