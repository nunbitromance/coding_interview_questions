/*
    3
   / \
  9  20
    /  \
   15   7
   
  Visit order: 3 -> 9 -> 20 -> 15 -> 7
*/
// Non-recursion method
public static Node bfs(Node root, int target)
{
	Queue<Node> queue = new LinkedList<Node>();
	queue.offer(root);
	Set<Node> visited = new HashSet<Node>();
	while (!queue.isEmpty())
	{
		Node cur = queue.poll();
		if (cur.value == target) {
			return cur;
		}
		visited.add(cur);
		for (Node c : cur.children) {
			if (!visited.contains(c)) {
				queue.offer(c);	
			}
		}
	}
	return null;
}
