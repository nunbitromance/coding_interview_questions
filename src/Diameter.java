/*
Diameter of a Binary Tree
March 15, 2010
The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in the tree. 
The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded 
(note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
*/
private static int getHeight(Node root)
{
	if (root == null)
	{
		return 0;
	}
	
	return 1 + Math.max(getHeight(root.left), getHeight(root.right));
}

public static int diameter(Node root)
{
	if (root == null)
	{
		return 0;
	}
	
	int lHeight = getHeight(root.left);
	int rHeight = getHeight(root.right);
	
	int lDiameter = diameter(root.left);
	int rDiameter = diameter(root.right);
	
	return Math.max(1 + lHeight + rHeight), Math.max(lDiameter, rDiameter));
}
