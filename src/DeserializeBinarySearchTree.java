// Part 2: Deserialize pre-order list into tree.
public static Node deserialize(List<Node> list)
{
	return deserialize(list, 0, list.length - 1);
}

// deserialize a binary search tree
private static Node deserialize(List<Node> list, int begin, int end)
{
	if (begin > end)
	{
		return null;
	}
	
	Node root = list[begin];
	// find right child whose value is greater than root.
	int rightIndex = begin + 1;
	while (rightIndex <= end)
	{
		if (list[rightIndex].Value > root.Value)
		{
			break;
		}
		rightIndex++;
	}
	
	root.Left = deserialize(list, begin+1, rightIndex-1);
	root.Right = deserialize(list, rightIndex, end);
}

