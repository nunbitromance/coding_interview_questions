/*
The key to solve inorder traversal of binary tree includes the following:

The order of "inorder" is: left child -> parent -> right child
Use a stack to track nodes
Understand when to push node into the stack and when to pop node out of the stack
*/

//Definition for binary tree
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
         ArrayList<Integer> lst = new ArrayList<Integer>();
 
        if(root == null)
            return lst; 
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //define a pointer to track nodes
        TreeNode p = root;
 
        while(!stack.empty() || p != null){
 
            // if it is not null, push to stack
            //and go down the tree to left
            if(p != null){
                stack.push(p);
                p = p.left;
 
            // if no left child
            // pop stack, process the node
            // then let p point to the right
            }else{
                TreeNode t = stack.pop();
                lst.add(t.val);
                p = t.right;
            }
        }
 
        return lst;
    }
}
