/* check if there is a path between two nodes s and t */
public class Node
{
	public Node[] children {get;set;}
	public bool visited {get;set;}
}

public static bool pathExists(Node s, Node t)
{
	Node cur = s;
	Stack<Node> st = new Stack<Node>();
	st.push(s);
	
	while (st.isEmpty() != true)
	{
		cur = st.pop();
		
		if (cur == t)
		{
			return true;
		}
		cur.visited = true;
		foreach (Node child in cur.children())
		{
			if (child.visited == false)
			{
				st.push(child);
				break;
			}
		}
	}
	
	return false;
}