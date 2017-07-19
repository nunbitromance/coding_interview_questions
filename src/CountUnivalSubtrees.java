/*
Input: root of below tree
              5
             / \
            1   5
           / \   \
          5   5   5
Output: 4
There are 4 subtrees with single values.


Input: root of below tree
              5
             / \
            4   5
           / \   \
          4   4   5                
Output: 5
There are five subtrees with single values.
*/
public class Result {
  public boolean isUnival = false;
  public int count = 0;
  public Result(boolean isUniv, int c) {
    this.isUnival = isUniv;
    this.count = c;
  }
}

public Result countUnivalSubtrees(Node root) {
  if (root == null) {
    return new Result(true, 0);
  }
  
  Result lResult = countUnivalSubtrees(root.left);
  Result rResult = countUnivalSubtrees(root.right);
  Result curResult = new Result(false, lResult.count + rResult.count);
  if ((root.left == null || lResult.isUnival && root.value == root.left.value) &&
      (root.right == null || rResult.isUnival && root.value == root.right.value)) {
        curResult.isUnival = true;
        curResult.count++;
      }
  return curResult;
}
