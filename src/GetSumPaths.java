
public static void getSumPaths(Node root, int sum)
{
	sumPaths(root, sum, new int[Int.Max], 0);
}

public static void sumPaths(Node root, int sum, int[] path, int level)
{
	if (root == null)
	{
		return;
	}
	
	int curSum = 0;
	path[level] = root.Value;
	
	for (int i = level; i >= 0; i--)
	{
		curSum += path[i];
		
		if (sum < curSum)
		{
			break;
		}
		else if (sum == curSume)
		{
			print(path, i, level);
			break;
		}
	}
	
	sumPaths(root.Left, sum, path, level + 1);
	sumPaths(root.Right, sum, path, level + 1);
}
