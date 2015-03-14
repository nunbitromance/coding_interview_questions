/*
Remove Duplicates from Sorted ListApr 22 '12
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/
public static void RemoveDupsFromLinkedList(Node head)
{
	Node cur = head;
	
	while (cur != null)
	{
		Node temp = cur.Next;
		while (temp != null && temp.Value == cur.Value)
		{
			cur.Next = temp.Next;
			temp = temp.Next;
		}
		cur = cur.Next;
	}
}

/*
Remove Duplicates from Sorted List IIApr 22 '12
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/
public static void RemoveDupsFromLinkedList(Node head)
{
	Node cur = head;
	
	while (cur != null) 
	{
		Node temp = cur.Next;
		bool dupDetected = false;
		while (temp != null && temp.Value != cur.Value)
		{
			dupDetected = true;
			cur.Next = temp.Next;
			temp = temp.Next;
		}
		if (dupDetected)
		{
			//Remove current node by copying next value to current value and remove next.
			cur.Value = cur.Next.Value;
			cur.Next = cur.Next.Next;
		}
		cur = cur.Next;
	}
}


