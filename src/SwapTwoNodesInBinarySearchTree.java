/*

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

*/
public static void SwapTwoNodes(Node root, int max, int min, ref Node first, ref Node second)
{
	if (root == null)
	{
		return;
	}
	
	if (root.Value > max || root.Value < min)
	{
		if (first == null)
		{
			first = root;
		}
		else
		{
			second = root;
			
			// found second, swap first and second
			Node temp = first;
			first = second;
			second = temp;
		}
	}
	
	SwapTwoNodes(root.Left, root.Value, min, ref first, ref second);
	SwapTwoNodex(root.Right, max, root.Value, ref first, ref second);
}