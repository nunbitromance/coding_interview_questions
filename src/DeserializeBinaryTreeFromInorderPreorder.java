/*
Construct Binary Tree from Preorder and Inorder TraversalSep 30 '12
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

       3
     /  \
    4    5
   / \  / \
  6  7 8  9
  
  PRE: 3, 4, 6, 7, 5, 8, 9
  IN:  6, 4, 7, 3, 8, 5, 9
*/
public static Node BuildTree(int[] pre, int[] inorder, int pStart, int pEnd, int iStart, int iEnd)
{
	if (end < start)
	{
		return null;
	}
	
	Node root = new Node(pre[pStart]);
	int rootInorderIndex = iStart;
	while (inorder[rootInorderIndex] != pre[pStart])
	{
		rootInorderIndex++;
	}
	
	root.Left = BuildTree(pre, inorder, pStart + 1, pStart + rootInorderIndex - 1, iStart, iStart + rootInorderIndex - 1);
	root.Right = BuildTree(pre, inorder, pStart + rootInorderIndex, pEnd, iStart + rootInorderIndex + 1, iEnd);
	
	return root;
}
