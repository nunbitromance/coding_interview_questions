/*
           1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9 
               
			  
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9 
*/

class Vertical {
  public int min;
  public int max;
}

class Node {
  
  public Node(int val) {
    this.val = val;
  }
  public int val;
  public Node left;
  public Node right;
}

class Solution {
  
  public void findMinMax(Node root, Vertical v, int hd) {
    if (root == null) {
      return; 
    }
    
    if (hd < v.min) {
      v.min = hd;
    } else if (hd > v.max) {
      v.max = hd;
    } 
    findMinMax(root.left, v, hd - 1);
    findMinMax(root.right, v, hd + 1);
  }
  
  public void printVertical(Node root, int hd, int target) {
    if (root == null) {
      return; 
    }
    
    if (hd == target) {
      System.out.print(root.val + " ");
    } 
    printVertical(root.left, hd - 1, target);
    printVertical(root.right, hd + 1, target);
  }
  
  
  public static void main(String[] args) {
    Vertical v = new Vertical();
    v.min = Integer.MAX_VALUE;
    v.max = Integer.MIN_VALUE;
    
    /* Let us construct the tree shown in above diagram */
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.left.right = new Node(8);
    root.right.right.right = new Node(9);
    
    new Solution().findMinMax(root, v, 0);
    
    for (int i = v.min; i <= v.max; i++) {
      new Solution().printVertical(root, 0, i); 
      System.out.println("");
    }
  }
}

