package practice;

public class LowestCommonAncestor {

    private static class Result {
        public int found = 0;
    }
    
    private TreeNode findLca(TreeNode root, TreeNode a, TreeNode b, Result result) {
        if (root == null) {
            return null;
        } else if (root == a || root == b) {
            result.found++;
            return root;
        }
        
        TreeNode left = findLca(root.left, a, b, result);
        TreeNode right = findLca(root.right, a, b, result);
        
        if (left != null && right != null) {
            return root;
        }
        
        return (left == null) ? right : left;
    }
    
    private TreeNode findNode(TreeNode root, TreeNode x) {
        if (root == null) {
            return null;
        } else if (root == x) {
            return root;
        }
        
        TreeNode left = findNode(root.left, x);
        if (left != null) {
            return left;
        }
        TreeNode right = findNode(root.right, x);
        if (right != null) {
            return right;
        }
        return null;
    }
    
    public TreeNode findLca(TreeNode root, TreeNode a, TreeNode b) {
        // validation
        Result r = new Result();
        TreeNode lca = findLca(root, a, b, r);
        if (r.found < 2) {
            if (lca == a && findNode(root, b) != null) {
                return lca;
            } else if (lca == b && findNode(root, a) != null) {
                return lca;
            }
            return null;
        }
        return lca;
    }
    
    
    /**
     * @param args
     *   
        4
      /   \
     2     6
    / \   / \
   1   3 5   7
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        
        TreeNode random = new TreeNode(8);
        
        
        System.out.println(new LowestCommonAncestor().findLca(root, root.left, root.right).value); //4
        System.out.println(new LowestCommonAncestor().findLca(root, root.left.left, root.left.right).value); //2
        System.out.println(new LowestCommonAncestor().findLca(root, root.left, root.left.right).value); //2
        System.out.println(new LowestCommonAncestor().findLca(root, root.left, random)); //null
    }

}
