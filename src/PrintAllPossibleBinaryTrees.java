/*
Unique Binary Search Trees IIAug 27 '12
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
public static List<Node> BuildAllPossibleBinaryTrees(int start, int end)
{
	List<Node> result = new List<Node>();
	
	if (start > end)
	{
		return null;
	}
	else if (start == end)
	{
		result.Add(new Node(start));
		return result;
	}
	
	for (int i = start; i <= end; i++)
	{
		List<Node> leftTrees = PrintAllTrees(start, i-1);
		List<Node> rightTrees = PrintAllTrees(i+1, end);

		// all possible trees made with start, i-1
		for (int j = 0; j < leftTrees.Count; j++)
		{
			// all possible trees made with i + 1, end
			for (int k = 0; k < rightTrees.Count; k++)
			{
				Node root = new Node(i);
				root.Left = leftTrees[j];
				root.Right = rightTrees[k];
				result.Add(root);
			}
		}
	} 


	
	return root;
}
	}
 
	public int totalTree(int n) {
		if (n == 1 || n == 0)
			return 1;
		else {
			int left = 0;
			int right = 0;
			int sum = 0;
			for (int k = 1; k <= n; k++) {
				left = totalTree(k - 1);
				right = totalTree(n - k);
				sum = sum + (left * right);
			}
			return sum;
		}
	}
}
