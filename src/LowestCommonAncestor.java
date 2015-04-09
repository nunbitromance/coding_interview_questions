public Node findLca(Node x, Node y, Node root) {
  if (root == null) {
    return null;
  }

  if (root == x) {
    return x;
  }
  if (root == y) {
    return y;
  }
  
  Node leftLca = findLca(x, y, root.left);
  Node rightLca = findLca(x, y, root.right);
  
  if (leftLca != null && rightLca != null) {
    return root;
  }
  return (leftLca != null) ? leftLca : rightLca;
}
