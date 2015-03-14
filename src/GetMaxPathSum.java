/*
	Binary Tree Maximum Path SumNov 8 '12
	Given a binary tree, find the maximum path sum.
	
	The path may start and end at any node in the tree.
	
	For example:
	Given the below binary tree,
	
	       1
	      / \
	     2   3
	Return 6.
*/
 public static int maxPathSum(Node root)
{
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
    int csum = 0;
    int maxsum = int.MinValue;
    maxPathSumHelper(root, ref csum, ref maxsum);
    return maxsum;
}

public static void maxPathSumHelper(Node node, ref int csum, ref int maxsum)
{
    if (node == null)
    {
        csum = 0;
        return;
    }
    int lsum = 0, rsum = 0;
    maxPathSumHelper(node.Left, ref lsum, ref maxsum);
    maxPathSumHelper(node.Right, ref rsum, ref maxsum);
    // current sum is max of (just node, node and left sum, node and right sum)
    csum = Math.Max(node.Value, Math.Max(node.Value + lsum, node.Value + rsum));
    // max sum is max of current sum, left + current value + right sum.
    maxsum = Math.Max(maxsum, Math.Max(csum, node.Value + lsum + rsum));
}

public static void Main(string[] args)
{
    /*       -1
    >    -1      -1
    >  3    -4 8     1
    >     6      -5     1
    >                7
     */
    Node root = new Node {Value = -1};
    root.Left = new Node {Value = -1};
    root.Right = new Node {Value = -1};
    root.Left.Left = new Node { Value = 3 };
    root.Left.Right = new Node{Value = -4 };
    root.Left.Right.Left = new Node {Value = 6 };

    root.Right.Left = new Node { Value = 8 };
    root.Right.Right = new Node {Value = 1};
    root.Right.Left.Right = new Node {Value = -5};
    root.Right.Left.Right.Right = new Node {Value = 7};
    root.Right.Right.Right = new Node { Value = 1 };

    int maxSum = 0;
    //GetMaxPathSum(root, ref maxSum, 0);
    maxSum = maxPathSum(root);

    Console.ReadLine();
}