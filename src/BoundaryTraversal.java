/*
Boundary Traversal of binary tree
September 12, 2012
Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root. For example, boundary traversal of the following tree is “20 8 4 10 14 25 22?
*/
public static void PrintBinaryTreeBoundary(Node root)
{
	PrintLeftPreorder(root.Left);
	PrintLeafInorder(root);
	PrintRightPostorder(root.Right);	
}

public static void PrintLeftPreorder(Node root)
{
	if (root == null || (root.Left == null && root.Right == null))
	{
		return;
	}
	
	Print(root.Value);
	
	PrintLeafPreorder(root.Left);
	PrintLeafPreorder(root.Left);
}

public static void PrintLeafInorder(Node root)
{
	if (root == null)
	{
		return;
	}
	
	PrintLeafInorder(root.Left);
	if (root.Left == null && root.Right == null)
	{
		Print(root.Value);
	}
	PrintLeafInorder(root.Right);
}

public static void PrintRightPostorder(Node root)
{
	if (root == null || (root.Left == null && root.Right == null))
	{
		return;
	}
	
	PrintLeafPreorder(root.Left);
	PrintLeafPreorder(root.Left);
	
	Print(root.Value);
}