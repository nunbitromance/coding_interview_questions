/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
       4
      / \
     3   5 
    / \
   1   2 
   
4 + 3 + 1 + 4 + 3 + 2 + 4 + 5 */
public class Solution {
    
    public int sumNumbers(TreeNode root) {
        if (root == null) {return 0;}
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        sum = sum * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            return sum;
        }
        
        int lSum = sumNumbers(root.left, sum);
        int rSum = sumNumbers(root.right, sum);
        
        return lSum + rSum;
    }
}
