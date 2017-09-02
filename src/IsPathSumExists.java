/*
Path SumOct 14 '12
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/
public static bool isPathSumExists(Node root, int sum)
{
	if (root == null)
	{
		return (sum == 0);
	}

	int localSum = sum - root.Value;
	
	if (localSum < 0)
	{
		// already exhausted sum.
		return false;
	}
	
	return isPathSumExists(root.Left, localSum) || isPathSumExists(root.Right, localSum);
}

/*
Path Sum IIOct 14 '12
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/
public static void printPathSums(Node root, int sum, int level, List<Node> path)
{
	if (root == null)
	{
		if (sum == 0)
		{
			Print(path);
		}
		return;
	}
	
	int localSum = sum - root.Value;
	
	if (localSum < 0)
	{
		return;
	}
	
	path.add(root.Value);
	printPathSums(root.Left, localSum, level + 1, path);
	printPathSums(root.Right, localSum, level + 1, path);
	path.remove(path.size() - 1);
}
