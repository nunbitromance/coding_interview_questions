/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if(root.val == p.val || root.val == q.val) {
            // if root is p or q then root is the lca.
            return root;
        } else if(p.val == q.val) {
            // if p and q are same, return p
            return p;
        } else if((p.val < root.val && q.val > root.val) ||(p.val > root.val && q.val < root.val)) {
            // in between p and q or q and p
            return root;
        } else if (root.val < p.val && root.val < q.val) {
            // recurse on right since root is smaller than both.
            return lowestCommonAncestor(root.right, p, q);
        }
        // recurse on left since root is greater than both.
        return lowestCommonAncestor(root.left, p, q);
    }
}
