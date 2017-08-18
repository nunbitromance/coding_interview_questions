/*Construct Binary Tree from just preorder
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

The idea is simple: print the tree in pre-order traversal and use "X" to denote null node and split node with ",". We can use a StringBuilder for building the string on the fly. For deserializing, we use a Queue to store the pre-order traversal and since we have "X" as null node, we know exactly how to where to end building subtress.
*/
public class Codec {
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}

/*Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.
Note: You may assume that duplicates do not exist in the tree.
Discussion

Why can we build a binary tree from preorder and inorder traversal?

Preorder, as its name, always visits root first and then left and right subtrees. That is to say, walking through a preorder list, each node we hit would be a "root" of a subtree (treat a leaf as a tree with no subtrees).
Inorder, on the other hand, always visits left subtree first and then root and then right subtree, which means that given a root, inorder list can tell us the sizes of its left and right subtrees.
Think about it.
Can we build a binary tree from any two traversal of the tree?

In this section, we discuss how to construct a tree with preorder and inorder traversal. In the next section, we will discuss a similar how-to for postorder and inorder traversal. But we can't build a tree with preorder and postorder traversal. Why? As we can't separate left subtree and right subtree. A simple example is shown below.

     1            1
    /      or      \    ??
   2                2
Solution

To build a binary tree, intuitively, we can do it recursively. Basically,
Pick up the first node in the preorder list and create a tree node with the value as root;
Look it up in the inorder list to determine the sizes of left and right subtrees;
Recursively build up the left and right subtrees.
Notice that we need to look up each value in the inorder list. If this step takes time O(n), the entire algorithm goes up to O(n^2)! So, we first create a hash table that maps a value to its index in the inorder list. By doing this, the look-up time reduced to O(1) with a O(n) one-time preparation computation.
Be careful about base case and boundary cases: empty tree, a (sub-)tree without left (or right) tree, etc., and about subtree size calculations.

Here is the algorithm.
*/
 public TreeNode buildTree(int[] preorder, int[] inorder) {  
   HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();  
   int len = inorder.length;  
   if (len < 1) return null;  
   // map node value to its index in inorder results  
   for (int i=0; i<inorder.length; ++i) {  
     inorderMap.put(inorder[i], i);  
   }  
   return buildSubTree(preorder, 0, inorderMap, 0, len-1);  
 }  

 private TreeNode buildSubTree(int[] preorder, int cur,  
                HashMap<Integer, Integer> inorder, int start, int end) {  
   TreeNode root = new TreeNode(preorder[cur]);  
   if (start < end) { // if more than one node left  
     int mid = inorder.get(preorder[cur]);  
     if (mid > start) {  
       root.left = buildSubTree(preorder, cur+1, inorder, start, mid-1);  
     }  
     if (mid < end) {  
       root.right = buildSubTree(preorder, cur+mid-start+1, inorder, mid+1, end);  
     }  
   }  
   return root; // Base case: start==end, i.e. only one node, simply return it.  
 }  

This algorithm runs in time O(n) and uses O(n) spaces (for hash and recursion).
*/

/*
Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.
Note: You may assume that duplicates do not exist in the tree.
Solution

Notice that postorder visits nodes in a tree in a left->right->root order. If we read postorder list backwards, it gives us a root->right->left order, which is kind of  a "mirror-like" way of preorder (root->left->right) traversal. Thus, several small modifications of previous algorithm can solve this problem, as shown below.
*/
 public TreeNode buildTree(int[] inorder, int[] postorder) {  
   int len = inorder.length;  
   if (len == 0 || len != postorder.length) return null;  
   // map inorder values to their indices  
   HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  
   for (int i=0; i<len; ++i) {  
     map.put(inorder[i], i);  
   }  
   // build the tree  
   // read postorder values backwards  
   return buildSubTree(postorder, 0, len-1, len-1, map);  
 }  
   
 private TreeNode buildSubTree(int[] postorder, int start, int end, int cur,  
                HashMap<Integer, Integer> inorder) {  
   if (start > end)  return null; // Base case: start > end, i.e. invalid index, return null

   int val = postorder[cur];  
   TreeNode root = new TreeNode(val);  
   int mid = inorder.get(val);  
   // read postorder values backwards  
   root.left = buildSubTree(postorder, start, mid-1, cur-(end-mid)-1, inorder);  
   root.right = buildSubTree(postorder, mid+1, end, cur-1, inorder);  

   return root;  
 }  
