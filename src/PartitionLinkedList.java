/*
Partition ListApr 30 '12
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->3->4->5.
*/
public static Node Partition(Node head, int pivot)
{
	Node first = head;
	Node firstTail = head;
	Node second = null;
	Node secondtail = null;
	Node cur = first;
	Node pivotNode = null;
	
	while (cur != null)
	{
		int val = cur.Value;
		
		if (pivot == val)
		{
			pivotNode = cur;	
		}
		else if (pivot > val)
		{
			if (second == null)
			{
				second = cur;
				secondTail = cur;
			}
			else
			{
				secondTail.Next = cur;
			}
		}
		else
		{
			firstTail.Next = cur;
		}
		
		cur = cur.Next;
	}
	
	// join first and second lists.
	firstTail.Next = pivot;
	pivot.Next = second;
	
	return first;
}