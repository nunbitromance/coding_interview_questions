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
	public static List<Node> buildTrees(int start, int end)
	{
		List<Node> result = new List<Node>();
		if (start > end)
		{
			result.add(null);
			return result;
		}
		else if (start == end)
		{
			result.add(new Node(start));
			return result;
		}

		for (int i = start; i <= end; i++)
		{
			List<Node> leftTrees = buildTrees(start, i-1);
			List<Node> rightTrees = buildTrees(i+1, end);

			// all possible trees made with start, i-1
			for (int j = 0; j < leftTrees.size(); j++)
			{
				// all possible trees made with i + 1, end
				for (int k = 0; k < rightTrees.size(); k++)
				{
					Node root = new Node(i);
					root.left = leftTrees.get(j);
					root.right = rightTrees.get(k);
					result.add(root);
				}
			}
		} 
		return root;
	}

        public int totalTrees(int n, Map<Integer, Integer> memo) {
		if (n == 1 || n == 0) {
			return 1;
		}
		
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		
		int sum = 0;
		for (int k = 2; k <= n; k++) {
			int left = totalTrees(k - 1, memo);
			int right = totalTrees(k + 1, memo);
			sum = sum + (left * right);
		}
		
		memo.put(n, sum);
		
		return sum;
	}
}
