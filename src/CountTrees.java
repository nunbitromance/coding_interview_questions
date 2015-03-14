/*
Unique Binary Search Trees
0
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public static int CountTrees(int n)
{
	if (n == 0 || n == 1)
	{
		return n;
	}
	
	int sum = 0; int left, right = 0;
	for (int k = 0; k < n; k++)
	{
		left = CountTrees(k);
		right = CountTrees(n - k - 1);
		
		sum += left * right;
	}
	
	return count;
}