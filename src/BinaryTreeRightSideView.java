/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private class IntWrapper {
        public int value;
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        IntWrapper w = new IntWrapper();
        w.value = -1;
        List<Integer> list = new ArrayList<Integer>();
        rightSideViewHelper(root, 0, w, list);
        return list;
    }
    
    private void rightSideViewHelper(TreeNode root, int curLevel, IntWrapper maxLevel, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (maxLevel.value < curLevel) {
            maxLevel.value++;
            result.add(root.val);
        } else {
            rightSideViewHelper(root.right, curLevel + 1, maxLevel, result);
            rightSideViewHelper(root.left, curLevel + 1, maxLevel, result);
        }
    }
}
