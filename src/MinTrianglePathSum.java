//Given a triangle, find the minimum path sum from top to bottom 
/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

public int minPath(List<List<Integer>> triangle) 
{
    int[] total = new int[triangle.size()];

    int l = triangle.size() - 1;
 
    for (int i = 0; i < triangle[l].size(); i++) 
    {
        total[i] = triangle[l][i];
    }
 
    // iterate from second last row
    for (int i = triangle.size() - 2; i >= 0; i--) 
    {
        for (int j = 0; j < triangle[i + 1].size() - 1; j++) 
        {
            total[j] = triangle[i][j] + Math.min(total[j], total[j + 1]);
        }
    }
 
    return total[0];
}
