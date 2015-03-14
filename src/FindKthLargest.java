public Node findKthLargest(Node root, int k, int[] cur)
{
    if (root == null)
    {
        return null;
    }
    
    findKthLargest(root.Right, k, cur); 
    
    // Process information
    cur[0]--;
    if (cur[0] == 0)
    {
        return root;
    }
   
    findKthLargest(root.Left, k, cur);
}



