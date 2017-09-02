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
	
	Here's my ideas:

A path from start to end, goes up on the tree for 0 or more steps, then goes down for 0 or more steps. 
Once it goes down, it can't go up. Each path has a highest node, which is also the lowest common ancestor of all other nodes on the 
path.
A recursive method maxPathDown(TreeNode node) (1) computes the maximum path sum with highest node is the input node, update 
maximum if necessary (2) returns the maximum sum of the path that can be extended to input node's parent.
*/
public class Solution {
    int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
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
