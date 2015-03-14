/*

Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

*/
public static Node FlattenTree(Node root)
{
	if (root == null)
	{
		return null;
	}	
	
	Node leftFlatList = FlattenTree(root.Left); // 2 -> 3 -> 4
	Node rightFlatList = FlattenTree(root.Right); // 5 -> 6
	
	root.Right = leftFlatList;
	
	Node t = leftFlatList;
	while (t.Right != null)
	{
		t = t.Right;
	}
	t.Next = rightFlatList;
	
	return root;
}
