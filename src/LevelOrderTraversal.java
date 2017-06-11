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

    /**
     * Use one queue and delimiter to print level by level
     */
    public void levelByLevelOneQueueUsingDelimiter(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root != null) {
                System.out.print(root.data + " ");
                if (root.left != null) {
                    q.offer(root.left);
                }
                if (root.right != null) {
                    q.offer(root.right);
                }
            } else {
                if (!q.isEmpty()) {
                    System.out.println();
                    q.offer(null);
                }
            }
        }
    }


    /**
     * Use one queue and count to print level by level
     */
    public void levelByLevelOneQueueUsingCount(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        int levelCount = 1;
        int currentCount = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            while (levelCount > 0) {
                root = q.poll();
                System.out.print(root.data + " ");
                if (root.left != null) {
                    currentCount++;
                    q.offer(root.left);
                }
                if (root.right != null) {
                    currentCount++;
                    q.offer(root.right);
                }
                levelCount--;
            }
            System.out.println();
            levelCount = currentCount;
            currentCount = 0;
        }
    }
