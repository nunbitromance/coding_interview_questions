// Iterative version.
public static void reverse(Node head)
{
	if (head == null)
	{
		return;
	}
	
	Node cur = head;
	Node prev = null;
	
	while (cur != null)
	{
		Node next = cur.Next;
		cur.Next = prev;
		prev = cur;
		cur = next;
	}
	
	head = prev;
}

// Recursive version: 1->2->3->4 to 4->3->2->1
public static Node reverse(Node head)
{
	if (head == null)
	{
		return null;
	}
	if (head.Next == null)
	{
		return head;
	}
	
	Node cur = head;
	Node rest = reverse(head.Next);
	
	cur.Next.Next = cur; // 4->3, 3->2, 2->1
	cur.Next = null; // 3-> null, 2-> null, 1->null
	
	return rest;
}

/*
Reverse Linked List IIJun 27 '12
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ? m ? n ? length of list.
*/
public static void Reverse(Node head, int m, int n)
{
	Node cur = head;
	
	int i = 0;
	
	while (cur)
	{
		if (i == m - 1)
		{
			Node cur2 = cur;
			Node prev = null;
			while (cur2 && i < n)
			{
				Node temp = cur2.Next;
				cur2.Next = prev2;
				prev2 = cur2;
				
				cur2 = cur2.Next;
				i++;
			}
			cur.Next = prev2;
			cur2.Next = prev2.Next;
		}
		cur = cur.Next;
		i++;
	}
	
	// point cur to m-1 th node
	for (int i = 1; i < m; i++)
	{
		cur = cur.Next;
	}
	
	
}
