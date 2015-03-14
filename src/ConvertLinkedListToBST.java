/* Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/
public static Node ConvertLinkedListToBST(ref Node head, int start, int end)
{
	if (head == null || start > end)
	{
		return null;
	}
	
	int mid = (start + end) / 2;
	Node leftSubtree = ConvertLinkedListToBST(ref head, start, mid - 1);
	Node root = new Node(head.Value);
	root.Left = leftSubtree;
	head = head.Next;
	Node rightSubtree = ConvertLinkedList(ref head, mid + 1, end);
	root.right = rightSubtree;
	
	return root;
}

/*
Convert Sorted Array to Binary Search TreeOct 2 '12
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/
public static Node ConvertArrayToBST(int[] m, int start, int end)
{
	if (start > end)
	{
		return null;
	}
	
	int mid = (start + end) / 2;
	
	Node root = new Node(m[mid]);
	root.Left = ConvertArrayToBST(m, start, mid - 1);
	root.Right = ConvertArrayToBST(m, mid + 1, end);
	
	return root;
}