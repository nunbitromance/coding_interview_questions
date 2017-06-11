/**
   http://algorithms.tutorialhorizon.com/files/2015/03/Provide-the-Next-Siblings-Pointers-in-a-Given-Binary-Tree.1-1.png
*/
public Node provideSiblings(Node root) {
		if (root != null) {

			if (root.left != null) { // check if left node is not null
				// make the left node's sibling points to the right node of root
				root.left.nextSibling = root.right;
			}
			if (root.right != null) {
				if (root.nextSibling != null)// check if root has any sibling
					// make the right node's sibling points root's next siblings
					// left node
					root.right.nextSibling = root.nextSibling.left;
			}
			provideSiblings(root.left);
			provideSiblings(root.right);
			return root; 

		}
		return null;
	}
