/*

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

*/
class NodePairWrapper {
	public Node first;
	public Node second;
	public Node prev;
}

public void swapTwoNodes(Node root, int max, int min) {
	NodePairWrapper npw = new NodePairWrapper();
	swapTwoNodes(root, Integer.MAX_VALUE, Integer.MIN_VALUE, npw);
	
	if (wrapper.second == null) {
		// if parent child value are swapped, swap them.
		int temp = wrapper.first.value;
		wrapper.first.value = wrapper.prev.value;
		wrapper.prev.value = temp;
	}
}

private static void swapTwoNodes(Node root, int max, int min, NodePairWrapper wrapper, Node prev)
{
	if (root == null)
	{
		return;
	}
	swapTwoNodes(root.left, root.value, min, wrapper, root);
	
	if (root.value > max || root.value < min)
	{
		if (wrapper.first == null)
		{
			wrapper.first = root;
			wrapper.prev = root;
		}
		else
		{
			wrapper.second = root;
			
			// found second, swap first and second
			int temp = wrapper.first.value;
			wrapper.first.value = wrapper.second.value;
			wrapper.second.value = temp;
			return;
		}
	}
	swapTwoNodex(root.right, max, root.value, wrapper, root);
}
