/* Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/
public static Node convertLinkedListToBST(Node head, int start, int end)
{
	if (head == null || start > end)
	{
		return null;
	}
	
	Node first = head;
	int mid = (start + end) / 2;
	for (int i = 0; i < mid; i++) {
		first = first.next;
	}
	
	Node root = new Node(first.val);
	root.left = convertLinkedListToBst(head, start, mid - 1);
	root.right = convertLinkedListToBst(head, mid+1, end);
	
	return root;
}

/*
Convert Sorted Array to Binary Search TreeOct 2 '12
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/
public static Node convertArrayToBST(int[] m, int start, int end)
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
