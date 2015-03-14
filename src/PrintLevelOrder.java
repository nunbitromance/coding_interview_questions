/*
Given a binary tree, print out the tree in level order (ie, from left to right, level by level). Output a newline after the end of each level. Breadth First Search (BFS) is not allowed.

     3
   /  \
  9   20    
     /  \
    15    7
For example, the level order output of the tree above is:

3 
9 20 
15 7
*/
public static void PrintLevelOrderUsingDFS(Node root)
{
	int h = GetHeight(root);
	
	for (int i = 1; i <= h; i++)
	{
		PrintLevel(root, i);
	}
}

private static void PrintLevel(Node root, int level)
{
	if (root == null)
	{
		return;
	}
	
	if (level == 1)
	{
		Print(root);
	}
	else
	{
		PrintLevel(root.Left, level - 1);
		PrintLevel(root.Right, level - 1);
	}
}

/*
Binary Tree Level Order Traversal IIOct 1 '12
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]
*/

public static void PrintLevelOrderUsingDFS(Node root)
{
	int h = GetHeight(root);
	
	for (int i = h; i >= 1; i--)
	{
		PrintLevel(root, i);
	}
}

public static void PrintLevelOrderUsingBFS(Node root)
{
	Dictionary<int, List<Node>> dictionary = new Dictionary<int, List<Node>>();
	int curLevel = 0;
	
	List<Node> curLevelList = new List<Node>();
	curLevel.Add(root);
	
	dictionary.Add(curLevel, root);
	
	while (curLevelList.Count > 0)
	{
		List<Node> nextLevelList = new List<Node>();
		foreach (Node n in curLevelList)
		{
			if (n.Left != null)
			{
				nextLevelList.Add(n.Left);
			}
			if (n.Right != null)
			{
				nextLevelList.Add(n.Right);
			}
		}
		curLevel++;
		dictionary.Add(curLevel, nextLevel);
		curLevelList = nextLevelList;
	}
	
	for (int i = curLevel; i >= 0; i--)
	{
		List<Node> levelList = dictionary.Get(i);
		Print(levelList);
	}
}