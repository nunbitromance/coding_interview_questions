/*
Unique Binary Search Trees
0
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

    public int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        return numTrees(n, map);
    }
    
    private int numTrees(int n, Map<Integer, Integer> map) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += numTrees(i - 1, map) * numTrees(n - i, map);
        }
        map.put(n, result);
        return result;
    }
