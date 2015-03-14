/*
Rotate ListMar 28 '12
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/
public static void RotateLinkedList(Node head, int k)
{
	int count = 0;
	Node cur = head;
	Node tail = head;
	while (cur != null)
	{
		tail = cur;
		cur = cur.Next;
		count++;
	}
	
	int numOfRotations = k % count;
	cur = head;
	tail = head;
	for (int i = 0; i < numOfRotations; i++)
	{
		// put tail k times behinad;
		tail = tail.Next;
	}
	while (tail != null)
	{
		cur = cur.Next;
		tail = tail.Next;
	}
	Node temp = head;
	head = cur.Next;
	cur.Next = null;
	tail.Next = temp;
}
