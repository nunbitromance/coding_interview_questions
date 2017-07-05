/*
* Given a BST, replace each node with the sum of the values of all the nodes that are greater than that node. Only constraint being that I was not allowed to use any global or static variable.
*/

          5               
         / \       
        /   \      
       /     \     
      /       \    
     4         7       
    /         / \   
   /         /   \  
  2          6   8   
 / \             
1 3             
                                
          21               
           / \       
          /   \      
         /     \     
        /       \    
      26          8       
      /          / \   
     /          /   \  
    33         15   0   
   / \             
  35 30

int visit(Node n, int add) {
    if (n == null) {
      return add;
    }
    int curVal = n.data;
    n.data = visit(n.right, add);
    return visit(n.left, n.data + curVal);
  }

   void visit(Node root) {
    visit(root, 0);
  }
