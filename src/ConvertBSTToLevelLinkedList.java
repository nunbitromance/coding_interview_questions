/*
Populating Next Right Pointers in Each NodeOct 28 '12
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/
public static Node CreateLevelLinkedLists(Node root)
{
	Queue<Node> curLevel = new Queue<Node>();
	curLevel.Add(root);
	Queue<Node> nextLevel = Queue<Node>();
	
	while (curLevel.IsEmpty() == false)
	{
		Node cur = curLevel.Dequeue();
		
		if (cur.Left != null)
		{
			nextLevel.Add(cur.Left);
		}
		if (cur.Right != null)
		{
			nextLevel.Add(cur.Right);
		}
		
		if (curLevel.IsEmpty())
		{
			// link all nodes in next level.
			Iterator<Node> itr = nextLevel.GetIterator();
			Node cur = itr.MoveNext();
			while (itr.HasNext() && cur != null)
			{
				Node next = itr.MoveNext();
				if (next != null)
				{
					cur.Next = next;
				}
				cur = next;
			}
			curLevel = nextLevel;
		}
	}
	
	return root;
}