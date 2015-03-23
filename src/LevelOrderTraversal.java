    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> curQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();
        curQueue.offer(root);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tempResult = new ArrayList<Integer>();
        
        while (!curQueue.isEmpty()) {
            TreeNode node = curQueue.poll();
            tempResult.add(node.val);
            if (node.left != null) {
                nextQueue.offer(node.left);
            }
            if (node.right != null) {
                nextQueue.offer(node.right);
            }
            if (curQueue.isEmpty()) {
                result.add(tempResult);
                tempResult = new ArrayList<Integer>();
                curQueue = nextQueue;
            }
        }
        
        return result;
    }
