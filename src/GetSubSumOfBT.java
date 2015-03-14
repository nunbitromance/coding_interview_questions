public int getSubSum(Node root, int[] maxSum)
{
    if (root == null)
    {
        return 0;
    }
    
    int sum = getSubSum(root.Left, maxSum) + root.Value + getSubSum(root.Right, maxSum);
    
    // Process information
    maxSum[0] = Math.Max(sum, maxSum[0]);

    return sum;
}


/*
Get Maximum Sum of Subtree
*/
public static int GetMaxSubtreeSum(Node root)
{
	int max = 0;
	GetMaxSubtreeSumRec(root, ref max);
	return max;
}

private static int GetMaxSubtreeSumRec(Node root, ref int maxSum)
{
	if (root == null)
	{
		return 0;
	}
	
	int s = GetMaxSubtreeSumRec(root.Left) + root + GetMaxSubtreeSumRec(root.Right);
	if (s > maxSum)
	{
		maxSum = s;
	}
	return s;
}