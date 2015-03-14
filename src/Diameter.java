/*
Diameter of a Binary Tree
March 15, 2010
The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in the tree. 
The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded 
(note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
*/
private static int GetHeight(Node root)
{
	if (root == null)
	{
		return 0;
	}
	
	return 1 + Math.Max(GetHeight(root.Left), GetHeight(root.Right));
}

public static int Diameter(Node root)
{
	if (root == null)
	{
		return 0;
	}
	
	int lHeight = GetHeight(root.Left);
	int rHeight = GetHeight(root.Right);
	
	int lDiameter = Diameter(root.Left);
	int rDiameter = Diameter(root.Right);
	
	return Math.Max(1 + Math.Max(lHeight, rHeight), Math.Max(lDiameter, rDiameter));
}