/*
https://leetcode.com/problems/flatten-2d-vector/description/
Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].


*/

public class Vector2D implements Iterator<Integer> {

    private int row = 0;
    private int col = 0;
    private List<List<Integer>> m = null;
    
    public Vector2D(List<List<Integer>> vec2d) {
        row = 0;
        col = 0;
        m = vec2d;
    }

    @Override
    public Integer next() {
        Integer x = m.get(row).get(col++);
        if (col >= m.get(row).size()) {
            row++;
            col = 0;
        }
        return x;
    }

    @Override
    public boolean hasNext() {
        return row < m.size() && col < m.get(row).size();
    }
}

