/* Find A Path Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example: Given the below binary tree and sum = 22, return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
Solution

This can be easily solved in O(n) time with recursion. A trick part is that this is asking for a root-to-leaf path, not any path starting from root.
 */
 
 public boolean hasPathSum(TreeNode root, int sum) {  
   if (root == null) return false;  
   if (root.left == null && root.right == null) // get to a leaf 
     return (sum == root.val);  
   return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);  
 }  
 
 /*
 Find ALL Path Sum

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example: Given the below binary tree and sum = 22, return [[5,4,11,2], [5,8,4,5]].
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
Solution

In this case, we need to keep track of the current path and also the result set. The basic idea is similar to previous version:
Recursively visit left and right subtrees of the root and keep the current root updated (be careful about this part);
If we hit a leaf and the pass-in sum is equal to the value of the node, then add the path to our result set.
Notice that we make a copy of the path before we added it to our result set. The reason is that when we add an Object (here, an ArrayList), Java add a copy of the pointer (i.e. a reference) of the Object, rather than a deep copy. So, any changes to content of the original Object will reflect into our final result set.


During recursion, we
visit each node constant times
the amortized time of add/remove an item on an ArrayList is O(1)
making a copy for each result costs at most O(logn).
So, the worst-case running time and space usage could be O(nlogn), where we have a full binary tree and each root-to-leaf path is eligible to be a valid result.
*/

 public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {  
   ArrayList<ArrayList<Integer>> resSet = new ArrayList<ArrayList<Integer>>();  
   findPathSum(root, sum, new ArrayList<Integer>(), resSet);  
   return resSet;  
 }  
   
 private void findPathSum(TreeNode root, int sum,  
                          ArrayList<Integer> path,  
                          ArrayList<ArrayList<Integer>> resSet) {  
   if (root == null) return;  
   path.add(root.val);  
   if (root.left == null && root.right == null) { // get to a leaf 
     if (sum == root.val) { // found a path 
       // has to make a copy, otherwise the content may be changed  
       ArrayList<Integer> curPath = new ArrayList<Integer>(path);  
       resSet.add(curPath);  
     }  
   }  
   findPathSum(root.left, sum - root.val, path, resSet);  
   findPathSum(root.right, sum - root.val, path, resSet);  
   path.remove(path.size()-1);  
 }  
 
 /*
 Binary Tree Maximum Path Sum

Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

For example: Given the below binary tree, return 6.
    -1
   /  \
  1    2
 / \
2   3
Solution

Let's start from a simpler version: suppose the path must contain the root. It can be solved in O(n) time as follows:
Recursively find the max partial path sum in the left subtree (A partial path is either an empty path or a path starting from left child of the root but not necessarily ending at a leaf);
Recursively find the max partial path sum in the right subtree;
Return the maximum of (root.value, root.value+max-left-path-sum, root.value+max-right-path-sum, root.value+max-left-path-sum+max-right-path-sum).
Now, go back to the original problem. As said, "The path may start and end at any node", and thus, it may or may not contain the root. We can run the above algorithm on each node, but it requires O(n^2) time and obviously there are lots of redundancies of doing that. Another way is to keep track the current maximum path sum of each node and update it to a new higher value if exists.

So, in each recursion, we need to return the max partial path sum and the current max path sum.

Unfortunately, in Java, we can't pass in an int of current max to keep it updated as Java passes in primitive variables by value (see java-passing-arguments-into-methods.html). In this case, we either pass in an array of two item or construct an Object that contains the two. In the code given below, we use the latter way for better readability, it is easy to change it to the former way and we left it to readers.

This algorithm runs in time O(n) by visiting each node constant times, and uses O(n) spaces with recursion.
*/

 public int maxPathSum(TreeNode root) {  
   // pass in an Object that will be filled in the two values
   Data data = maxSubPath(root);  
   return data.sum;  
 }  

 private class Data {
   int path = 0;
   int sum = Integer.MIN_VALUE;
 }

 private Data maxSubPath(TreeNode root) {  
   Data data = new Data();
   if (root == null) return data;

   Data l = maxSubPath(root.left);
   Data r = maxSubPath(root.right);

   data.path = Math.max(0, Math.max(l.path, r.path) + root.val);
   data.sum = Math.max(Math.max(l.sum, r.sum), l.path+root.val+r.path);
   return data;  
 }


 
