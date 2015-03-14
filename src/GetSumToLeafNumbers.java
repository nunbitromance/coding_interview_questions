/*
Sum Root to Leaf NumbersFeb 19
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/
public static int GetSumToLeafNumbers(Node root, int sum)
{
	if (root == null)
	{
		return 0;
	}
	
	int sum = sum * 10 + root.Value;
	
	return GetSumToLeafNumbers(root.Left, sum) + GetSumToLeafNumbers(root.Right, sum);
}