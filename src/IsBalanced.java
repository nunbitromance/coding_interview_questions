// Check Height and Get Height if both sides dont differ by more than 1.
public static bool isBalanced(Node root)
{
	return (isBalanced(root) != -1);
}

// return -1 if not balanced, return height otherwise.
private static int compareHeight(Node root)
{
	if (root == null)
	{
		return 0;
	}
	
	int lHeight = compareHeight(root.Left);
	if (compareHeight == -1)
	{
		return -1;
	}
	
	int rHeight = compareHeight(root.Right);
	if (compareHeight == -1)
	{
		return -1;
	}
	
	if (Math.Abs(lHeight - rHeight) > 1)
	{
		return -1;
	}
	else return 1 + Math.Max(lHeight, rHeight);
}

// Option #2: naive but works. get left height and right height.
public static bool isBalanced(Node root)
{
	if (root == null)
	{
		return true;
	}
	
	return Math.Abs(getHeight(root.Left) - getHeight(root.Right)) <= 1;
}

private static int getHeight(Node root)
{
	if (root == null)
	{
		return 0;
	}
	
	return 1 + Math.Max(getHeight(root.Left), getHeight(root.Right));
}