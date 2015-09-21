public static bool isBST(Node root)
{
	return isBST(root, int.Max, 0);
}

private static bool isBST(Node root, int max, int min)
{
	if (root == null)
	{
		return true;
	}
	
	if (root.Value > max || root.Value < min)
	{
		return false;
	}
	
	if (!isBST(root.getLeft(), root.getValue(), min))
	{
		return false;
	}

	if (!isBST(root.getRight(), max, root.getValue())
	{
		return false;
	}
	
	return true;
}
