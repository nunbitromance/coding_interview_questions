/*
Boundary Traversal of binary tree
September 12, 2012
Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root. For example, 
boundary traversal of the following tree is “20 8 4 10 14 25 22?

Solution: 
1. Print the left boundary 
1.1. Similar to preorder, ONLY deal with left child!

2. Print all leaf nodes
2.1. Similar to inorder (or preorder), ONLY print leaf nodes!

3. Print the right boundary
3.1. Similar to a postorder, ONLY deal with right child!

*/
public void boundaryTraversal(Node root)
{
	leftPreOrder(root.left);
	inOrderLeafOnly(root);
	rightPostOrder(root.right);	
}

public void leftPreOrder(Node root)
{
	if (root == null || (root.Left == null && root.Right == null))
	{
		return;
	}
	
	System.out.print(root.value);
	
	if (root.left != null) {
		leftPreOrder(root.left);
	}
}

public void inOrderLeafOnly(Node root)
{
	if (root == null)
	{
		return;
	}
	
	inOrderLeafOnly(root.left);
	if (root.left == null && root.right == null)
	{
		System.out.print(root.value);
	}
	inOrderLeafOnly(root.right);
}

public void rightPostOrder(Node root)
{
	if (root == null || (root.left == null && root.right == null))
	{
		return;
	}
	
	if (root.right != null) {
		rightPostOrder(root.right);
	}
	
	System.out.print(root.value);
}
